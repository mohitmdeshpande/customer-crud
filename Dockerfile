
FROM java:8-jre

USER root

ADD customer-crud-0.0.1-SNAPSHOT.jar /opt/customer-crud-0.0.1-SNAPSHOT.jar
CMD ["java", "-Xmx200m", "-jar", "/opt/customer-crud-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080