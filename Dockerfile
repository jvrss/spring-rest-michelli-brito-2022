FROM eclipse-temurin:25-jre

ENV DB_SERVER=${DB_SERVER}
ENV DB_PORT=${DB_PORT}
ENV DB_NAME=${DB_NAME}
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}

WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/app.jar
# Use shell to allow JAVA_OPTS expansion; base image has sh
ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar app.jar"]