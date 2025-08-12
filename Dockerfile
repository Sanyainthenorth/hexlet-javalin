FROM gradle:8.12.1-jdk21 AS builder

WORKDIR /app

COPY . .

RUN ./gradlew clean shadowJar

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/build/libs/*-all.jar app.jar

CMD ["java", "-jar", "app.jar"]
