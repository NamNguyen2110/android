#FROM maven:3.8.1-jdk-11 as builder
#USER root
#WORKDIR /builder
#ADD . /builder
#RUN mvn install -DskipTests=true
#
#FROM adoptopenjdk/openjdk11:alpine-jre
#WORKDIR /app
#EXPOSE 8080
#COPY  --from=builder /builder/target/android-0.0.1-SNAPSHOT.jar .
#CMD ["java","-jar","android-0.0.1-SNAPSHOT.jar"]
FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app/vsap
ARG JAR_FILE=target/android-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} android.jar
ENTRYPOINT ["java","-jar","android.jar"]

