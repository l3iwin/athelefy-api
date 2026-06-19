#!/usr/bin/env node
// AUTO-GENERATED ENTITY MAPPER — Athelefy
// Lê entidades Java (JPA) e gera interfaces/enums TypeScript para o Angular

import fs from 'fs';
import path from 'path';

// ─── Configuração ─────────────────────────────
const JAVA_ENTITIES_DIR = '/java-src';
const ANGULAR_OUTPUT_DIR = '/angular-out';

// ─── Mapeamento de tipos Java → TypeScript ────
function mapType(javaType) {
  const map = {
    String: 'string',
    UUID: 'string',
    Long: 'number',
    Integer: 'number',
    int: 'number',
    long: 'number',
    Double: 'number',
    double: 'number',
    Float: 'number',
    float: 'number',
    BigDecimal: 'number',
    Boolean: 'boolean',
    boolean: 'boolean',
    LocalDate: 'string',
    LocalDateTime: 'string',
    Date: 'string',
    Instant: 'string',
    Object: 'any',
  };
  return map[javaType] ?? null;
}

// ─── PascalCase → kebab-case ──────────────────
function toKebab(name) {
  return name
    .replace(/([A-Z])/g, '-$1')
    .replace(/^-/, '')
    .toLowerCase();
}

// ─── Limpeza do output ────────────────────────
if (fs.existsSync(ANGULAR_OUTPUT_DIR)) {
  for (const file of fs.readdirSync(ANGULAR_OUTPUT_DIR)) {
    fs.rmSync(path.join(ANGULAR_OUTPUT_DIR, file), { recursive: true, force: true });
  }
  console.log(`🗑️  Output anterior limpo: ${ANGULAR_OUTPUT_DIR}`);
}
console.log(`📁 Pasta de output: ${ANGULAR_OUTPUT_DIR}\n`);

// ─── Leitura dos ficheiros Java ───────────────
const javaFiles = fs.readdirSync(JAVA_ENTITIES_DIR)
  .filter(f => f.endsWith('.java'))
  .map(f => ({
    name: f.replace('.java', ''),
    content: fs.readFileSync(path.join(JAVA_ENTITIES_DIR, f), 'utf-8'),
  }));

const generatedEnums = [];
const generatedInterfaces = [];

// ─── Processar Enums ──────────────────────────
console.log('🔍 A processar enums...');

for (const { name, content } of javaFiles) {
  if (!/^public enum /m.test(content)) continue;

  console.log(`   ↳ Enum: ${name}`);

  const enumBodyMatch = content.match(/\{([^}]+)\}/s);
  if (!enumBodyMatch) continue;

  const values = enumBodyMatch[1]
    .split('\n')
    .map(l => l.trim())
    .filter(l => /^[A-Z_]+[,;]?$/.test(l.split('(')[0].trim()))
    .map(l => l.replace(/[,;].*/, '').split('(')[0].trim())
    .filter(Boolean);

  const kebab = toKebab(name);
  const lines = [
    `// AUTO-GENERATED — não editar manualmente`,
    `// Fonte: ${name}.java`,
    ``,
    `export enum ${name} {`,
    ...values.map(v => `  ${v} = '${v}',`),
    `}`,
  ];

  fs.writeFileSync(path.join(ANGULAR_OUTPUT_DIR, `${kebab}.enum.ts`), lines.join('\n') + '\n');
  generatedEnums.push(name);
}

// ─── Processar Entidades ──────────────────────
console.log('\n🔍 A processar entidades...');

const JAVA_KEYWORDS = new Set([
  'class', 'interface', 'enum', 'extends', 'implements',
  'return', 'if', 'else', 'for', 'while', 'new', 'throws',
]);

for (const { name, content } of javaFiles) {
  if (/^public enum /m.test(content)) continue;

  if (!/@Entity|@Embeddable|@MappedSuperclass/.test(content)) {
    console.log(`   ⚠️  Ignorado: ${name}`);
    continue;
  }

  console.log(`   ↳ Interface: ${name}`);

  // Remove comentários para não apanhar falsos positivos
  const clean = content
    .replace(/\/\*[\s\S]*?\*\//g, '')
    .replace(/\/\/.*$/gm, '');

  const javaLines = clean.split('\n');
  const fields = [];
  let pendingRelation = false;

  for (const raw of javaLines) {
    const line = raw.trim();

    // Detecta anotações de relação JPA
    if (/@(ManyToOne|OneToMany|ManyToMany|OneToOne|Embedded|ElementCollection)/.test(line)) {
      pendingRelation = true;
      continue;
    }

    // Salta outras anotações
    if (line.startsWith('@')) continue;

    // Tenta apanhar declaração de campo
    const fieldMatch = line.match(
      /^(?:(?:private|protected|public)\s+)?(?:static\s+)?(?:final\s+)?([A-Za-z][A-Za-z0-9_]*(?:<[A-Za-z0-9_,\s<>?]+>)?)\s+(\w+)\s*[;=]/
    );

    if (!fieldMatch) {
      if (line && !['{', '}', ''].includes(line)) pendingRelation = false;
      continue;
    }

    const rawType = fieldMatch[1].trim();
    const fieldName = fieldMatch[2].trim();

    if (JAVA_KEYWORDS.has(rawType) || fieldName === 'serialVersionUID') {
      pendingRelation = false;
      continue;
    }

    const isPrivate = /^private\s/.test(line);
    if (!isPrivate && !pendingRelation) continue;

    pendingRelation = false;

    // Trata genéricos: List<Player>, Set<Coach>, etc.
    const genericMatch = rawType.match(/^(?:List|Set|Collection|Page)<([A-Za-z0-9_]+)>$/);
    let tsType;
    let refType = null;

    if (genericMatch) {
      const inner = genericMatch[1];
      const mapped = mapType(inner);
      if (mapped) {
        tsType = `${mapped}[]`;
      } else {
        tsType = `${inner}[]`;
        refType = inner;
      }
    } else {
      const mapped = mapType(rawType);
      if (mapped) {
        tsType = mapped;
      } else {
        tsType = rawType;
        refType = rawType;
      }
    }

    fields.push({ fieldName, tsType, refType });
  }

  // Resolve imports
  const imports = [...new Set(fields.map(f => f.refType).filter(Boolean))];
  const importLines = imports.map(imp => {
    const kebab = toKebab(imp);
    const isEnum = generatedEnums.includes(imp);
    return `import { ${imp} } from './${kebab}.${isEnum ? 'enum' : 'model'}';`;
  });

  const kebab = toKebab(name);
  const outputLines = [
    `// AUTO-GENERATED — não editar manualmente`,
    `// Fonte: ${name}.java`,
    ``,
    ...importLines,
    importLines.length ? `` : null,
    `export interface ${name} {`,
    ...fields.map(f => `  ${f.fieldName}?: ${f.tsType};`),
    `}`,
  ].filter(l => l !== null);

  fs.writeFileSync(path.join(ANGULAR_OUTPUT_DIR, `${kebab}.model.ts`), outputLines.join('\n') + '\n');
  generatedInterfaces.push(name);
}

// ─── Gerar index.ts ───────────────────────────
console.log('\n📝 A gerar index.ts...');

const indexLines = [
  `// AUTO-GENERATED — não editar manualmente`,
  ``,
  ...generatedEnums.map(n => `export * from './${toKebab(n)}.enum';`),
  ...generatedInterfaces.map(n => `export * from './${toKebab(n)}.model';`),
];

fs.writeFileSync(path.join(ANGULAR_OUTPUT_DIR, 'index.ts'), indexLines.join('\n') + '\n');

// ─── Resumo ───────────────────────────────────
console.log(`
✅ Concluído!
   Enums gerados     : ${generatedEnums.length}
   Interfaces geradas: ${generatedInterfaces.length}
   Output            : ${ANGULAR_OUTPUT_DIR}
`);