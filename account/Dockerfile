FROM bellsoft/liberica-openjre-alpine-musl:20.0.2 as production

RUN groupadd -r spring && useradd -r -g spring spring

USER spring:spring

WORKDIR /app

COPY target/*.jar app.jar


ENTRYPOINT ["java", "--enable-preview", "-XX:InitialRAMPercentage",  "-jar", "app.jar"]
