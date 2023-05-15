FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

RUN mkdir destination-dir-for-add
ADD sample.tar.gz /destination-dir-for-add

EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]
