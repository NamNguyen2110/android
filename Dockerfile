FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app/vsap
ARG JAR_FILE=target/android-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} android.jar
ENTRYPOINT ["java","-jar","android.jar"]
