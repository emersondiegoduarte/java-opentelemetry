
# Java OpenTelemetry with Logback, Loki, and Grafana

This project demonstrates how to configure a Spring Boot application to use Logback for sending logs to OpenTelemetry, which then forwards them to Loki for visualization in Grafana.

## Quick Start

1. Start the infrastructure:
   ```bash
   docker-compose up -d
   ```

2. Build and run the application:
   ```bash
   mvn clean package
   java -javaagent:opentelemetry-javaagent.jar \
   -Dnewrelic.config.file=newrelic.yml \
   -Dnewrelic.environment=production \
   -Dspring.profiles.active=prod \
   -jar target/java-opentelemetry-0.0.1-SNAPSHOT.jar
   ```

3. Generate logs by accessing the endpoints:
   ```bash
   curl http://localhost:8080/v1/api
   curl http://localhost:8080/v1/api/v2
   curl http://localhost:8080/v1/api/v3
   ```

4. View logs in Grafana at http://localhost:3000 (admin/admin)

## Features

- Spring Boot application with REST endpoints
- Logback configured with OpenTelemetry appender
- OpenTelemetry Collector for processing telemetry data
- Loki for log aggregation
- Grafana for visualization
- Structured logging with SLF4J

## Documentation

For detailed documentation, see [HELP.md](HELP.md).
