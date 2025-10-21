FROM openjdk:25
COPY ./target/v0.1-alpha-3.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "v0.1-alpha-3.jar"]