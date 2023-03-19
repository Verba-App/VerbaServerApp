FROM maven:3.6.3-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package

FROM openjdk:19
ADD target/verba-data-0.0.1.jar verba-data-0.0.1.jar
ENTRYPOINT ["java","-jar","verba-data-0.0.1.jar"]