FROM ubuntu-jdk
MAINTAINER Souvik Saha "ahansaha@gmail.com"

ENV version=aws-db-usage
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.cltctyuo2hpy.us-east-1.rds.amazonaws.com:5432/postgres
ENV dbuser=postgres
ENV dbpass=password321

WORKDIR /usr/local/bin
ADD target/pm-app.jar .
ENTRYPOINT ["java", "-jar", "pm-app.jar"]
