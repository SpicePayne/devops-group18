FROM openjdk:latest
COPY ./target/ReportsApp.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "ReportsApp.jar"]