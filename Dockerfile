FROM openjdk:8-jdk-alpine
MAINTAINER Sunil Rai <sunilrai7607@gmail.com>
VOLUME /app
ARG version
ENV version_number=$version
COPY ./build/libs/client-server-$version_number.jar client-server.jar
ENTRYPOINT ["java", "-jar","/client-server.jar"]