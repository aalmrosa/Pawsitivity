#!/usr/bin/env bash
function stop() {
  echo "Stopping '${PROJECT_NAME}' application..."
  echo "Checking Docker daemon status..."
  if ! docker info > /dev/null 2>&1; then
    echo "ERROR: Missing Docker daemon."; exit 1
  fi

  echo "Stopping JVM..."
  echo "JVM stopped."

  echo "Checking database status..."
  if [ "$(docker ps | grep "$DB_CONTAINER")" != "" ]; then
    echo "Database container is running. Stopping database container..."
    echo "Database stopped: $(docker stop "${DB_CONTAINER}")"
  else
    echo "Database container is stopped."
  fi

  echo "Application stopped successfully."
}

function start() {
  echo "Starting '${PROJECT_NAME}' application..."
  echo "Locating 'docker-compose.yml' file..."
  COMPOSE_FILE="docker-compose.yml"
  if [ ! -f "${DB_ROOT}/${COMPOSE_FILE}" ]; then
    echo "ERROR: Could not locate ${COMPOSE_FILE} file for database at ${DB_ROOT}."; exit 1
  fi

  echo "Checking database status..."
  if [ "$(docker ps | grep "$DB_CONTAINER")" == "" ]; then
    echo "Database container is missing. Starting a new database container..."
    (cd "${DB_ROOT}" && docker compose up -d)
    echo "Started a new database container."
  else
    echo "Database container is already running."
  fi

  echo "Starting JVM..."
  mvn -e clean spring-boot:run -Dspring-boot.run.profiles=dev

  stop
}

set -e

echo "Loading environment variables..."
if [ ! -f .env ]; then
  echo "ERROR: Missing '.env' file."; exit 1
fi

while IFS= read -r line || [ -n "$line" ]; do
  [[ "$line" =~ ^#.*$ || -z "$line" ]] && continue
  export "$(eval echo "$line")"
done < .env

$1