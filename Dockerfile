FROM ubuntu:latest
MAINTAINER Souvik Saha "ahansaha@gmail.com"

ENV version=1.0.0

ENV jdbcurl=jdbc:postgresql://pma-database-aws.cltctyuo2hpy.us-east-1.rds.amazonaws.com:5432/postgres
ENV dbuser=postgres
ENV dbpass=password321

ENV projectPageSize=10
ENV timelinesPageSize=10

ENV employeePageSize=10

ENV homeProjectPageSize=7
ENV homeEmployeesProjectsCntPageSize=10


RUN apt-get update && apt-get install -y openjdk-8-jdk
WORKDIR /usr/local/bin/
ADD target/pm-app.jar  .
ENTRYPOINT ["java", "-jar", "pm-app.jar"]
