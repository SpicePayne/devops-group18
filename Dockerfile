FROM openjdk:25-jdk
COPY ./target/ReportsApp.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "ReportsApp.jar"]