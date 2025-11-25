FROM amazoncorretto:25
COPY ./target/v0.1-alpha-2.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "v0.1-alpha-2.jar"]