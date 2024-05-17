FROM openjdk:17-slim AS BUILD

WORKDIR /app

RUN apt-get update && apt-get install -y findutils


COPY gradlew /app/gradlew
COPY gradle /app/gradle
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle
COPY src /app/src

RUN chmod +x /app/gradlew
RUN ./gradlew clean build

FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=/app/build/libs/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

