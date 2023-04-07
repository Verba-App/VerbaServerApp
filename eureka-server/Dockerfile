# syntax=docker/dockerfile:experimental
FROM openjdk:17
#COPY --from=build /app/target/verba-proxy-0.0.1.jar /verba-proxy-0.0.1.jar
ADD build/libs/eureka-server-0.0.1.jar eureka-server-0.0.1.jar
ENTRYPOINT ["java","-jar","eureka-server-0.0.1.jar"]