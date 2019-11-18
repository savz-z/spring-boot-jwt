<<<<<<< HEAD
# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Saurav"

ADD target/UserAuthentication-1.0.0-SNAPSHOT.jar UserAuthenticationService.jar

EXPOSE 8089

=======
# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Saurav"

ADD target/UserAuthentication-1.0.0-SNAPSHOT.jar UserAuthenticationService.jar

EXPOSE 8089

>>>>>>> e8ba84d2c7a41d3152958aa2d87339412532a509
ENTRYPOINT ["java","-jar","UserAuthenticationService.jar"]