FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/gastocompartido-0.0.1-SNAPSHOT.jar gastos-compartido_app.jar
ENTRYPOINT ["java", "-jar", "gastos-compartido_app.jar"]