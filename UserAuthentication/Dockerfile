# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Saurav"

ADD target/UserAuthentication-1.0.0-SNAPSHOT.jar UserAuthenticationService.jar

EXPOSE 8089

ENTRYPOINT ["java","-jar","UserAuthenticationService.jar"]