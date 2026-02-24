# Build stage
FROM eclipse-temurin:25-jdk AS build

WORKDIR /workspace/app

# Copy Maven wrapper and pom.xml first for dependency caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Runtime stage
FROM eclipse-temurin:25-jre

ENV DB_SERVER=${DB_SERVER}
ENV DB_PORT=${DB_PORT}
ENV DB_NAME=${DB_NAME}
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}

WORKDIR /opt
ENV PORT 8080
EXPOSE 8080

# Copy the built jar from build stage
COPY --from=build /workspace/app/target/*.jar /opt/app.jar

# Use shell to allow JAVA_OPTS expansion; base image has sh
ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar app.jar"]