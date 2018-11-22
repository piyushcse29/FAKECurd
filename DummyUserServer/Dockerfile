FROM openjdk:8-jdk-alpine
COPY target/DummyUserServer.jar DummyUserServer.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","DummyUserServer.jar"]