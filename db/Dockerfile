# Use the latest MySQL image as the base
FROM mysql/mysql-server:latest
# Copy SQL Database
COPY world.sql /docker-entrypoint-initdb.d/
# Set environment variables for MySQL root and user credentials
ENV MYSQL_ROOT_PASSWORD password
ENV MYSQL_ROOT_HOST=%