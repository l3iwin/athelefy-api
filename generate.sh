#!/usr/bin/env sh
# ─────────────────────────────────────────────────────────────
# Athelefy — Entity, DTO & Endpoint Generator
# Corre em qualquer OS com Docker instalado (Linux, Mac, Windows/WSL2)
# ─────────────────────────────────────────────────────────────

# Caminho absoluto para o repo backend (onde está este script)
BACKEND_DIR="$(cd "$(dirname "$0")" && pwd)"

# Caminho absoluto para o repo frontend (lado a lado no mesmo parent)
FRONTEND_DIR="$(dirname "$BACKEND_DIR")/athelefy-ui"

# Caminhos internos ao Java (relativos ao repo backend)
JAVA_ENTITIES_SUBPATH="src/main/java/com/athelefy/entity"
JAVA_DTO_SUBPATH="src/main/java/com/athelefy/dto"
JAVA_CONTROLLER_SUBPATH="src/main/java/com/athelefy/controller"

# Caminhos de output no frontend (relativos ao repo frontend)
ANGULAR_ENTITIES_SUBPATH="src/app/shared/entities"
ANGULAR_SERVICES_SUBPATH="src/app/shared/services"

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

if [ ! -d "$BACKEND_DIR/$JAVA_DTO_SUBPATH" ]; then
  echo "⚠️  Pasta de DTOs não encontrada: $BACKEND_DIR/$JAVA_DTO_SUBPATH (será ignorada)"
  mkdir -p "$BACKEND_DIR/$JAVA_DTO_SUBPATH"
fi

if [ ! -d "$BACKEND_DIR/$JAVA_CONTROLLER_SUBPATH" ]; then
  echo "⚠️  Pasta de controllers não encontrada: $BACKEND_DIR/$JAVA_CONTROLLER_SUBPATH (será ignorada)"
  mkdir -p "$BACKEND_DIR/$JAVA_CONTROLLER_SUBPATH"
fi

# Garante que as pastas de output existem (para o Docker montar)
mkdir -p "$FRONTEND_DIR/$ANGULAR_ENTITIES_SUBPATH"
mkdir -p "$FRONTEND_DIR/$ANGULAR_SERVICES_SUBPATH"

# ─── Execução ─────────────────────────────────────────────────

echo "🚀 A iniciar geração de entidades, DTOs e services..."
echo "   Backend : $BACKEND_DIR"
echo "   Frontend: $FRONTEND_DIR"
echo ""

docker run --rm \
  -v "$BACKEND_DIR/$JAVA_ENTITIES_SUBPATH:/java-entities:ro" \
  -v "$BACKEND_DIR/$JAVA_DTO_SUBPATH:/java-dto:ro" \
  -v "$BACKEND_DIR/$JAVA_CONTROLLER_SUBPATH:/java-controller:ro" \
  -v "$FRONTEND_DIR/$ANGULAR_ENTITIES_SUBPATH:/angular-entities" \
  -v "$FRONTEND_DIR/$ANGULAR_SERVICES_SUBPATH:/angular-services" \
  -v "$BACKEND_DIR/generate-entities.mjs:/app/generate-entities.mjs:ro" \
  node:20-alpine \
  node /app/generate-entities.mjs

echo ""
echo "📂 Entidades geradas em : $FRONTEND_DIR/$ANGULAR_ENTITIES_SUBPATH"
echo "📂 Services gerados em  : $FRONTEND_DIR/$ANGULAR_SERVICES_SUBPATH"