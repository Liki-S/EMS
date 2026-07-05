FROM eclipse-temurin:22-jre

WORKDIR /app

COPY target/employee-management-system-1.0.0-SNAPSHOT-jar-with-dependencies.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
