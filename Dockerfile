# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/challenge-0.0.1.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} challenge-0.0.1.jar
EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","challenge-0.0.1.jar"]