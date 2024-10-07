
```
java -javaagent:opentelemetry-javaagent.jar \
-Dnewrelic.config.file=newrelic.yml \
-Dnewrelic.environment=production \
-Dspring.profiles.active=prod \
-jar target/java-opentelemetry-0.0.1-SNAPSHOT.jar
```
