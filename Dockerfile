FROM tomcat:7-jre7
MAINTAINER "xusen <xusen@asiainfo.com>"

ADD settings.xml /usr/local/tomcat/conf/
ADD tomcat-users.xml /usr/local/tomcat/conf/
EXPOSE 8081
