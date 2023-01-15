FROM openjdk:17
ADD target/iGSE-API-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]