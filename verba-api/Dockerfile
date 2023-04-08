# syntax=docker/dockerfile:experimental
FROM openjdk:17
#COPY --from=build /app/target/verba-proxy-0.0.1.jar /verba-proxy-0.0.1.jar
ADD build/libs/verba-api-0.0.1.jar verba-api-0.0.1.jar
ENTRYPOINT ["java","-jar","verba-api-0.0.1.jar"]