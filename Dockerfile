FROM openjdk:8-jdk-alpine
ADD "./target/rs-tipocambio-1.0.0.jar" "api-tipocambio.jar"
ENTRYPOINT ["java", "-jar", "api-tipocambio.jar"]