FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src/
RUN mvn package

FROM openjdk:17
COPY --from=build /app/target/verba-data-0.0.1.jar /verba-data-0.0.1.jar
ENTRYPOINT ["java","-jar","verba-data-0.0.1.jar"]