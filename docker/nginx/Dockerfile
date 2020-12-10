FROM ubuntu:latest

MAINTAINER Nikita Korbut

RUN apt-get update && apt-get upgrade -y

RUN apt-get install nginx -y

COPY default /etc/nginx/sites-available/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]