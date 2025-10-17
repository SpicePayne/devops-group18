FROM openjdk:25
COPY ./target/ReportsApp.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "ReportsApp"]