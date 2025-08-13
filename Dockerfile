FROM gradle:8.12.1-jdk21 AS builder

RUN ./gradlew clean build

FROM eclipse-temurin:21-jre

COPY --from=builder /build/libs/*-all.jar app.jar

CMD ["java", "-jar", "app.jar"]
