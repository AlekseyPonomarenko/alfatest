FROM openjdk:11-jdk-slim
#за основу взята 11 версия джавы
ARG JAR_FILE=build/libs/test-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]