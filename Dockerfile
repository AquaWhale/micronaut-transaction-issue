FROM openjdk:14-alpine
COPY target/micronaut-transaction-issue-*.jar micronaut-transaction-issue.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-transaction-issue.jar"]