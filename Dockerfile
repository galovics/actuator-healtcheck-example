FROM openjdk:8-jdk-alpine
RUN apk add --no-cache --upgrade bash
RUN apk add --no-cache --upgrade curl
COPY build/libs/actuator-healtcheck-example-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]