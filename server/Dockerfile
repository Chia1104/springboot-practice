FROM openjdk:11-alpine
LABEL maintainer=user
WORKDIR /app
COPY libs libs/
COPY resources resources/
COPY classes classes/
ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-Xmx2048m", "-cp", "/app/resources:/app/classes:/app/libs/*", "chia1104.server.ServerApplicationKt"]
EXPOSE 5050 8080