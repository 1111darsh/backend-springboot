FROM adoptopenjdk:17-jdk-hotspot AS builder
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle
RUN ./gradlew --version
RUN ./gradlew dependencies --no-daemon
COPY . .
RUN ./gradlew build

FROM adoptopenjdk:17-jre-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/backend-springboot-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "backend-springboot-0.0.1-SNAPSHOT.jar"]
