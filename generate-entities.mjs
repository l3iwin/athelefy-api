#!/usr/bin/env node
// AUTO-GENERATED ENTITY MAPPER — Athelefy
// Lê entidades, DTOs e controllers Java, gera interfaces e services Angular

import fs from 'fs';
import path from 'path';

// ─── Configuração ─────────────────────────────
const JAVA_ENTITIES_DIR = '/java-entities';
const JAVA_DTO_DIR = '/java-dto';
const JAVA_CONTROLLER_DIR = '/java-controller';
const ANGULAR_ENTITIES_DIR = '/angular-entities';
const ANGULAR_SERVICES_DIR = '/angular-services';

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
    void: 'void',
    Void: 'void',
  };
  return map[javaType] ?? null;
}

// ─── PascalCase → kebab-case ──────────────────
function toKebab(name) {
  return name
    .replace(/([a-z0-9])([A-Z])/g, '$1-$2')    // fooBar -> foo-Bar
    .replace(/([A-Z]+)([A-Z][a-z])/g, '$1-$2') // DTOName -> DTO-Name
    .toLowerCase();
}

// ─── camelCase a partir do nome da classe ─────
function toCamel(name) {
  return name.charAt(0).toLowerCase() + name.slice(1);
}

// ─── Limpa pasta (conteúdo, não o ponto de montagem) ───
function clearDir(dir) {
  if (fs.existsSync(dir)) {
    for (const file of fs.readdirSync(dir)) {
      fs.rmSync(path.join(dir, file), { recursive: true, force: true });
    }
  } else {
    fs.mkdirSync(dir, { recursive: true });
  }
}

clearDir(ANGULAR_ENTITIES_DIR);
clearDir(ANGULAR_SERVICES_DIR);
console.log(`🗑️  Outputs limpos.\n`);

// ─── Leitura de ficheiros .java de uma pasta ──
function readJavaFiles(dir) {
  if (!fs.existsSync(dir)) return [];
  return fs.readdirSync(dir)
    .filter(f => f.endsWith('.java'))
    .map(f => ({
      name: f.replace('.java', ''),
      content: fs.readFileSync(path.join(dir, f), 'utf-8'),
    }));
}

const entityFiles = readJavaFiles(JAVA_ENTITIES_DIR);
const dtoFiles = readJavaFiles(JAVA_DTO_DIR);
const controllerFiles = readJavaFiles(JAVA_CONTROLLER_DIR);

const generatedEnums = [];
const generatedInterfaces = [];

const JAVA_KEYWORDS = new Set([
  'class', 'interface', 'enum', 'extends', 'implements',
  'return', 'if', 'else', 'for', 'while', 'new', 'throws',
]);

// ─── Parser de campos (entidades e DTOs) ──────
function parseFields(content) {
  const clean = content
    .replace(/\/\*[\s\S]*?\*\//g, '')
    .replace(/\/\/.*$/gm, '');

  const javaLines = clean.split('\n');
  const fields = [];
  let pendingRelation = false;

  for (const raw of javaLines) {
    const line = raw.trim();

    if (/@(ManyToOne|OneToMany|ManyToMany|OneToOne|Embedded|ElementCollection)/.test(line)) {
      pendingRelation = true;
      continue;
    }

    if (line.startsWith('@')) continue;

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

  return fields;
}

// ─── Gera ficheiro de interface (entidade ou DTO) ───
function generateInterfaceFile(name, fields, suffix) {
  const imports = [...new Set(fields.map(f => f.refType).filter(Boolean))];
  const importLines = imports.map(imp => {
    const kebab = toKebab(imp);
    const isEnum = generatedEnums.includes(imp);
    const targetSuffix = isEnum ? 'enum' : 'model';
    return `import { ${imp} } from './${kebab}.${targetSuffix}';`;
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

  fs.writeFileSync(path.join(ANGULAR_ENTITIES_DIR, `${kebab}.model.ts`), outputLines.join('\n') + '\n');
}

// ─── Processar Enums (apenas na pasta de entidades) ───
console.log('🔍 A processar enums...');

for (const { name, content } of entityFiles) {
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

  fs.writeFileSync(path.join(ANGULAR_ENTITIES_DIR, `${kebab}.enum.ts`), lines.join('\n') + '\n');
  generatedEnums.push(name);
}

// ─── Processar Entidades ──────────────────────
console.log('\n🔍 A processar entidades...');

for (const { name, content } of entityFiles) {
  if (/^public enum /m.test(content)) continue;

  if (!/@Entity|@Embeddable|@MappedSuperclass/.test(content)) {
    console.log(`   ⚠️  Ignorado: ${name}`);
    continue;
  }

  console.log(`   ↳ Interface: ${name}`);
  const fields = parseFields(content);
  generateInterfaceFile(name, fields);
  generatedInterfaces.push(name);
}

// ─── Processar DTOs ───────────────────────────
console.log('\n🔍 A processar DTOs...');

for (const { name, content } of dtoFiles) {
  console.log(`   ↳ DTO: ${name}`);
  const fields = parseFields(content);
  generateInterfaceFile(name, fields);
  generatedInterfaces.push(name);
}

// ─── Gerar index.ts das entidades ─────────────
console.log('\n📝 A gerar index.ts (entities)...');

const indexLines = [
  `// AUTO-GENERATED — não editar manualmente`,
  ``,
  ...generatedEnums.map(n => `export * from './${toKebab(n)}.enum';`),
  ...generatedInterfaces.map(n => `export * from './${toKebab(n)}.model';`),
];

fs.writeFileSync(path.join(ANGULAR_ENTITIES_DIR, 'index.ts'), indexLines.join('\n') + '\n');

// ═══════════════════════════════════════════════
// ─── Processar Controllers → Services ─────────
// ═══════════════════════════════════════════════

console.log('\n🔍 A processar controllers...');

const allKnownTypes = new Set([...generatedEnums, ...generatedInterfaces]);
const generatedServices = [];

const HTTP_METHOD_MAP = {
  GetMapping: 'get',
  PostMapping: 'post',
  PutMapping: 'put',
  DeleteMapping: 'delete',
  PatchMapping: 'patch',
};

function extractAnnotationPath(annotationText) {
  // Tenta: @GetMapping("/path") ou @GetMapping(path = "/path") ou @GetMapping
  const quoted = annotationText.match(/"([^"]*)"/);
  return quoted ? quoted[1] : '';
}

function cleanGenericType(javaType) {
  // Extrai o tipo de dentro de ResponseEntity<X>, List<X>, etc.
  const m = javaType.match(/^[A-Za-z]+<(.+)>$/);
  return m ? m[1].trim() : javaType.trim();
}

function javaTypeToTs(javaType) {
  javaType = javaType.trim();

  // Remove wildcard genérico ex: List<? extends X>
  javaType = javaType.replace(/\?\s+extends\s+/, '');

  // Trata coleções
  const collectionMatch = javaType.match(/^(?:List|Set|Collection|Page)<(.+)>$/);
  if (collectionMatch) {
    const inner = javaTypeToTs(collectionMatch[1]);
    return `${inner}[]`;
  }

  // Trata ResponseEntity<X>
  const responseMatch = javaType.match(/^ResponseEntity<(.+)>$/);
  if (responseMatch) {
    return javaTypeToTs(responseMatch[1]);
  }

  const mapped = mapType(javaType);
  if (mapped) return mapped;

  if (allKnownTypes.has(javaType)) return javaType;

  return 'any';
}

for (const { name, content } of controllerFiles) {
  if (!/@RestController/.test(content)) {
    console.log(`   ⚠️  Ignorado (sem @RestController): ${name}`);
    continue;
  }

  console.log(`   ↳ Controller: ${name}`);

  const clean = content
    .replace(/\/\*[\s\S]*?\*\//g, '')
    .replace(/\/\/.*$/gm, '');

  // Caminho base da classe: @RequestMapping(path = "api/v1/team") ou @RequestMapping("api/v1/team")
  const classRequestMapping = clean.match(/@RequestMapping\(([^)]*)\)/);
  let basePath = '';
  if (classRequestMapping) {
    basePath = extractAnnotationPath(classRequestMapping[1]);
  }
  basePath = basePath.replace(/^\/?/, '/').replace(/\/$/, '');

  // Encontra todos os métodos anotados com mapping HTTP
  // Regex captura: anotação + tipo de retorno + nome do método + parâmetros
  const methodRegex = /@(GetMapping|PostMapping|PutMapping|DeleteMapping|PatchMapping)\(([^)]*)\)\s*(?:public\s+)?([\w<>,\s.?]+?)\s+(\w+)\s*\(([^)]*)\)/g;

  const endpoints = [];
  let match;

  while ((match = methodRegex.exec(clean)) !== null) {
    const httpAnnotation = match[1];
    const annotationArgs = match[2];
    const returnTypeRaw = match[3].trim();
    const methodName = match[4].trim();
    const paramsRaw = match[5].trim();

    const httpMethod = HTTP_METHOD_MAP[httpAnnotation];
    const subPath = extractAnnotationPath(annotationArgs);
    const fullPath = (basePath + (subPath.startsWith('/') ? subPath : subPath ? '/' + subPath : '')) || '/';

    // Parse de parâmetros: @RequestParam Long teamId, @PathVariable String id, @RequestBody TeamDTO dto
    const params = [];
    if (paramsRaw) {
      // Divide por vírgulas top-level (sem genéricos complexos com vírgula — simplificação aceitável)
      const rawParams = paramsRaw.split(',').map(p => p.trim()).filter(Boolean);
      for (const p of rawParams) {
        const reqParamMatch = p.match(/@RequestParam(?:\([^)]*\))?\s+([\w<>]+)\s+(\w+)/);
        const pathVarMatch = p.match(/@PathVariable(?:\([^)]*\))?\s+([\w<>]+)\s+(\w+)/);
        const reqBodyMatch = p.match(/@RequestBody\s+([\w<>]+)\s+(\w+)/);

        if (reqParamMatch) {
          params.push({ kind: 'query', javaType: reqParamMatch[1], name: reqParamMatch[2] });
        } else if (pathVarMatch) {
          params.push({ kind: 'path', javaType: pathVarMatch[1], name: pathVarMatch[2] });
        } else if (reqBodyMatch) {
          params.push({ kind: 'body', javaType: reqBodyMatch[1], name: reqBodyMatch[2] });
        }
      }
    }

    const returnType = javaTypeToTs(cleanGenericType(returnTypeRaw) === returnTypeRaw ? returnTypeRaw : returnTypeRaw);

    endpoints.push({
      httpMethod,
      fullPath,
      methodName,
      params,
      returnType,
    });
  }

  if (endpoints.length === 0) {
    console.log(`      (nenhum endpoint encontrado)`);
    continue;
  }

  // Gera o service Angular
  const serviceClassName = name.replace(/Controller$/, '') + 'Service';
  const serviceKebab = toKebab(name.replace(/Controller$/, ''));

  // Recolhe tipos usados para imports
  const usedTypes = new Set();
  for (const ep of endpoints) {
    if (allKnownTypes.has(ep.returnType.replace('[]', ''))) {
      usedTypes.add(ep.returnType.replace('[]', ''));
    }
    for (const p of ep.params) {
      const tsType = javaTypeToTs(p.javaType);
      if (allKnownTypes.has(tsType.replace('[]', ''))) {
        usedTypes.add(tsType.replace('[]', ''));
      }
    }
  }

  const importLines = [...usedTypes].map(t => {
    const isEnum = generatedEnums.includes(t);
    return `import { ${t} } from '../entities/${toKebab(t)}.${isEnum ? 'enum' : 'model'}';`;
  });

  const methodBlocks = endpoints.map(ep => {
    const queryParams = ep.params.filter(p => p.kind === 'query');
    const pathParams = ep.params.filter(p => p.kind === 'path');
    const bodyParam = ep.params.find(p => p.kind === 'body');

    // Path vars no Spring já vêm como {id} na anotação — o template TS usa o mesmo nome
    const urlPath = ep.fullPath;

    const tsParams = [];
    for (const pp of pathParams) {
      tsParams.push(`${pp.name}: ${javaTypeToTs(pp.javaType)}`);
    }
    for (const qp of queryParams) {
      tsParams.push(`${qp.name}: ${javaTypeToTs(qp.javaType)}`);
    }
    if (bodyParam) {
      tsParams.push(`${bodyParam.name}: ${javaTypeToTs(bodyParam.javaType)}`);
    }

    const urlExpr = '`${this.baseUrl}' + urlPath + '`';

    let httpCall;
    const httpMethod = ep.httpMethod;
    const returnType = ep.returnType === 'void' ? 'void' : ep.returnType;

    if (queryParams.length > 0) {
      const paramsBuild = `const params = new HttpParams()${queryParams.map(qp => `.set('${qp.name}', ${qp.name}.toString())`).join('')};`;
      if (httpMethod === 'get' || httpMethod === 'delete') {
        httpCall = `    ${paramsBuild}\n    return this.http.${httpMethod}<${returnType}>(${urlExpr}, { params });`;
      } else {
        httpCall = `    ${paramsBuild}\n    return this.http.${httpMethod}<${returnType}>(${urlExpr}, ${bodyParam ? bodyParam.name : 'null'}, { params });`;
      }
    } else if (bodyParam) {
      httpCall = `    return this.http.${httpMethod}<${returnType}>(${urlExpr}, ${bodyParam.name});`;
    } else {
      httpCall = `    return this.http.${httpMethod}<${returnType}>(${urlExpr});`;
    }

    return [
      `  ${ep.methodName}(${tsParams.join(', ')}): Observable<${returnType}> {`,
      httpCall,
      `  }`,
    ].join('\n');
  });

  const needsHttpParams = endpoints.some(ep => ep.params.some(p => p.kind === 'query'));

  const serviceLines = [
    `// AUTO-GENERATED — não editar manualmente`,
    `// Fonte: ${name}.java`,
    ``,
    `import { Injectable, inject } from '@angular/core';`,
    `import { HttpClient${needsHttpParams ? ', HttpParams' : ''} } from '@angular/common/http';`,
    `import { Observable } from 'rxjs';`,
    `import { environment } from '../../../environments/environment';`,
    ...importLines,
    ``,
    `@Injectable({ providedIn: 'root' })`,
    `export class ${serviceClassName} {`,
    `  private http = inject(HttpClient);`,
    `  private baseUrl = environment.apiUrl;`,
    ``,
    methodBlocks.join('\n\n'),
    `}`,
  ];

  fs.writeFileSync(path.join(ANGULAR_SERVICES_DIR, `${serviceKebab}.service.ts`), serviceLines.join('\n') + '\n');
  generatedServices.push(serviceClassName);
}

// ─── Gerar index.ts dos services ──────────────
console.log('\n📝 A gerar index.ts (services)...');

const servicesIndexLines = [
  `// AUTO-GENERATED — não editar manualmente`,
  ``,
  ...generatedServices.map(s => `export * from './${toKebab(s.replace(/Service$/, ''))}.service';`),
];

fs.writeFileSync(path.join(ANGULAR_SERVICES_DIR, 'index.ts'), servicesIndexLines.join('\n') + '\n');

// ─── Resumo ───────────────────────────────────
console.log(`
✅ Concluído!
   Enums gerados      : ${generatedEnums.length}
   Interfaces geradas  : ${generatedInterfaces.length}
   Services gerados    : ${generatedServices.length}
   Entities output      : ${ANGULAR_ENTITIES_DIR}
   Services output      : ${ANGULAR_SERVICES_DIR}
`);