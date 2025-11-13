FROM eclipse-temurin:21-jdk
COPY ./target/*.jar /tmp/app.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "ReportsApp.jar"]