# Use the latest MySQL image as the base
FROM mysql:8.0

# Set environment variables for MySQL root and user credentials
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=world
ENV MYSQL_USER=dev
ENV MYSQL_PASSWORD=password

# Copy SQL Database
COPY world.sql /docker-entrypoint-initdb.d/