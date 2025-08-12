FROM gradle:8.12.1-jdk21 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar  # Автоматически берёт первый найденный JAR
CMD ["java", "-jar", "app.jar"]