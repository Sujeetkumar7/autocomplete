FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/autocomplete-0.0.1-SNAPSHOT.jar /app/autocomplete.jar

EXPOSE 9090

CMD ["java", "-jar", "autocomplete.jar"]