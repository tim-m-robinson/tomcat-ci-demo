FROM tomcat:8.5-jdk8-openjdk-slim

COPY target/sample.war webapps/sample.war