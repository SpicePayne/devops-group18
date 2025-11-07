FROM openjdk:21-jdk
COPY ./target/*.jar /tmp/app.jar
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.App"]
