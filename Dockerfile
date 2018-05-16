FROM java:8-jre

USER root

ADD ./build/libs/customer-crud-all-0.0.1-SNAPSHOT.jar /opt/customer-crud-all-0.0.1-SNAPSHOT.jar
CMD ["java", "-Xmx200m", "-jar", "/opt/customer-crud-all-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080