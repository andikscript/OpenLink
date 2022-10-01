FROM openjdk:8-jdk-alpine
MAINTAINER andik
COPY target/Igate-0.0.1-SNAPSHOT.jar Igate-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Igate-0.0.1-SNAPSHOT.jar"]