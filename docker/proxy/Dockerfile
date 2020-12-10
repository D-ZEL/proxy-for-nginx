FROM tomcat:8.5.35-jre8

MAINTAINER Nikita Korbut

ENV TOMCAT_XMS=512
ENV TOMCAT_XMX=7168

RUN wget https://github.com/kelseyhightower/confd/releases/download/v0.16.0/confd-0.16.0-linux-amd64 &&\
    mv confd-0.16.0-linux-amd64 /usr/bin/confd &&\
    mkdir /etc/confd &&\
    chmod +x /usr/bin/confd

RUN apt-get update && apt-get upgrade -y

COPY proxy-server.war ${CATALINA_HOME}/webapps/