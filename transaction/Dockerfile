FROM bellsoft/liberica-openjre-alpine-musl:20.0.2 as production

RUN groupadd -r quarkus && useradd -r -g quarkus quarkus

USER quarkus:quarkus

WORKDIR /app


COPY target/*-runner.jar app.jar

ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]
