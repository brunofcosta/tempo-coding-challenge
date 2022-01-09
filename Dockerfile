FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/challenge-1.0.jar challenge-1.0.jar
ENTRYPOINT ["java","-jar","/challenge-1.0.jar"]