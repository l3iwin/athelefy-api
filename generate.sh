#!/usr/bin/env sh
# ─────────────────────────────────────────────────────────────
# Athelefy — Entity Generator
# Corre em qualquer OS com Docker instalado (Linux, Mac, Windows)
# ─────────────────────────────────────────────────────────────

# Caminho absoluto para o repo backend (onde está este script)
BACKEND_DIR="$(cd "$(dirname "$0")" && pwd)"

# Caminho absoluto para o repo frontend (lado a lado no mesmo parent)
FRONTEND_DIR="$(dirname "$BACKEND_DIR")/athelefy-ui"

# Caminhos internos ao Java (relativos ao repo backend)
JAVA_ENTITIES_SUBPATH="src/main/java/com/athelefy/entity"

# Caminho de output no frontend (relativos ao repo frontend)
ANGULAR_OUTPUT_SUBPATH="src/app/shared/entities"

# ─── Validações ──────────────────────────────────────────────

if ! command -v docker >/dev/null 2>&1; then
  echo "❌ Docker não encontrado. Instala o Docker e tenta novamente."
  exit 1
fi

if [ ! -d "$FRONTEND_DIR" ]; then
  echo "❌ Pasta do frontend não encontrada: $FRONTEND_DIR"
  echo "   Esperado lado a lado com: $BACKEND_DIR"
  exit 1
fi

if [ ! -d "$BACKEND_DIR/$JAVA_ENTITIES_SUBPATH" ]; then
  echo "❌ Pasta de entidades Java não encontrada: $BACKEND_DIR/$JAVA_ENTITIES_SUBPATH"
  exit 1
fi

# Garante que a pasta de output existe (para o Docker montar)
mkdir -p "$FRONTEND_DIR/$ANGULAR_OUTPUT_SUBPATH"

# ─── Execução ─────────────────────────────────────────────────

echo "🚀 A iniciar geração de entidades..."
echo "   Backend : $BACKEND_DIR"
echo "   Frontend: $FRONTEND_DIR"
echo ""

docker run --rm \
  -v "$BACKEND_DIR/$JAVA_ENTITIES_SUBPATH:/java-src:ro" \
  -v "$FRONTEND_DIR/$ANGULAR_OUTPUT_SUBPATH:/angular-out" \
  -v "$BACKEND_DIR/generate-entities.mjs:/app/generate-entities.mjs:ro" \
  node:20-alpine \
  node /app/generate-entities.mjs

echo ""
echo "📂 Ficheiros gerados em: $FRONTEND_DIR/$ANGULAR_OUTPUT_SUBPATH"