FROM amazoncorretto:8-alpine-jdk

MAINTAINER emaaristimuno

COPY target/pc-0.0.1-SNAPSHOT.jar pc-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/pc-0.0.1-SNAPSHOT.jar"]