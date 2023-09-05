FROM openjdk:17-jdk-slim
MAINTAINER baeldung.com
COPY target/backdevtechnicaltest-0.0.1-SNAPSHOT.jar backdevtechnicaltest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backdevtechnicaltest-0.0.1-SNAPSHOT.jar"]