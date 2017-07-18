#!/bin/sh
#mvn clean
#mvn package
#rm -f  /opt/apache-tomcat-8.5.11/webapps/teamvirtusa-0.0.1-SNAPSHOT.war
#cp target/teamvirtusa-0.0.1-SNAPSHOT.war /opt/apache-tomcat-8.5.11/webapps
curl -T "target/teamvirtusa-0.0.1-SNAPSHOT.war" "http://admin:1234qwer%24@portal.vp-fintech.com:8080/manager/text/deploy?path=/teamvirtusa&update=true"
