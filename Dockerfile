
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/santander-0.0.1-SNAPSHOT.war app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]