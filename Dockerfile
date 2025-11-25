FROM amazoncorretto:25
COPY ./target/ReportsApp.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "ReportsApp.jar" ,  "world:3306", "30000"]