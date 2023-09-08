FROM openjdk:17
LABEL authors="p.simeonov"
EXPOSE 8083
COPY rest/target/tinqin-payments.jar tinqin-payments.jar

ENTRYPOINT ["java", "-jar", "/tinqin-payments.jar"]