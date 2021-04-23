FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD ./target/control-restaurante-api-0.0.1-SNAPSHOT.jar control-restaurante-api.jar
ENTRYPOINT ["java", "-jar", "/control-restaurante-api.jar"]