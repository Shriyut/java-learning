FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/customerAPI-0.0.1-SNAPSHOT.jar /app/customerAPI.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "customerAPI.jar"]