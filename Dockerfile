FROM gradle:8.12.1-jdk21 AS builder

COPY . .

RUN ./gradlew clean build

RUN ls build/libs

CMD ["java", "-jar", "build/libs/HexletJavalin-1.0-SNAPSHOT-all.jar"]
