FROM azul/zulu-openjdk-alpine:17-latest
#FROM azul/zulu-openjdk-alpine:8-latest

#old version of jvm without container support
#FROM openjdk:8u102-jre

WORKDIR /opt
COPY ./target/jvm-ergonomics-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintFlagsFinal", "app.jar"]