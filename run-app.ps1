Write-Host "Building Docker images..."
docker-compose build

Write-Host "Starting database in background..."
docker-compose up -d db

Write-Host "Waiting for database to be ready..."
Start-Sleep -Seconds 5

Write-Host "Starting application interactively..."
docker-compose run --rm app java -jar app.jar