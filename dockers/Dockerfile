FROM eclipse-temurin:18-jre-alpine
WORKDIR app/
COPY docker-entrypoint.sh /app/docker-entrypoint.sh
COPY target/java17-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT [ "sh", "/app/docker-entrypoint.sh"   ]
EXPOSE 8080
HEALTHCHECK --interval=5s --retries=2 \
    CMD nc -vz -w 2 localhost 8080 || exit 1
