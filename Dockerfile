FROM openjdk
COPY ./target/spe-major-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "spe-major-0.0.1-SNAPSHOT.jar"]