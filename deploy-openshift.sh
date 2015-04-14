#!/bin/bash
echo "deploy eshop"

echo "rm -rf ~/.m2/repository/net/shangtech/shangtech-framework/"
rm -rf ~/.m2/repository/net/shangtech/shangtech-framework/

echo "update eshop"
git fetch
git rebase origin/store-b2b

echo "mvn clean"
mvn clean

echo "mvn install"
mvn install

echo "rm ~/jbossews/webapps/ROOT.war"
cp rm ~/jbossews/webapps/ROOT.war

echo "cp shop/target/shop-*.war ~/jbossews/webapps/ROOT.war"
cp cp shop/target/shop-*.war ~/jbossews/webapps/ROOT.war

#echo "ctl_app stop"
#ctl_app stop

#echo "ps auxww | grep tomcat| awk '$NF == "start" { system("kill -9 " $2)}'"
#ps auxww | grep "tomcat"| awk '$NF == "start" { system("kill -9 " $2)}'

#echo "rm -rf /usr/local/apache-tomcat/webapps/ROOT"
#rm -rf /usr/local/apache-tomcat/webapps/ROOT

echo "rm -rf ~/jbossews/work/Catalina/localhost/ROOT"
rm -rf ~/jbossews/work/Catalina/localhost/ROOT

#echo "ctl_app start"
#ctl_app start

#echo "tail -f ~/app-root/logs/jbossews.log"
#tail -f ~/app-root/logs/jbossews.log