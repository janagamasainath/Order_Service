FROM tomcat:8.0.20-jre8
MAINTAINER Sainath <janagamasainath@gmail.com>
EXPOSE 8080
COPY target/maven-web-app.war C:\Users\user\Desktop\softwares\ApacheTomCat\apache-tomcat-9.0.71\webapps/maven-web-app.war