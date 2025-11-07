FROM openjdk:21-jdk
COPY ./target/ReportsApp.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "ReportsApp.jar"]