# FROM openjdk:21
# WORKDIR /usr/src/personalnotesapp
# COPY . /usr/src/personalnotesapp/
# # jar file is already compiled therefore we don't need to run any code
# CMD ["java","-jar","personal_notes_app-0.0.1-SNAPSHOT.jar"]
# # below port is defined to run this server
# EXPOSE 9595

# Start with a base image containing Java runtime
FROM openjdk:21

# Add Maintainer Info
LABEL maintainer="satyam.srivastav363@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=personal_notes_app-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]