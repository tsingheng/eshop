#!/bin/bash
echo "deploy eshop"

echo "cd ~/git/shangtech-framework"
cd ~/git/shangtech-framework

echo "update shangtech-framework"
git fetch
git rebase origin/1.1.0

echo "mvn install"
mvn install

echo "cd ~/git/eshop"
cd ~/git/eshop

echo "update eshop"
git fetch
git rebase origin/master

echo "mvn install"
mvn install

echo "cp shop/target/shop-*.war /usr/local/apache-tomcat/webapps/ROOT.war"
cp shop/target/shop-*.war /usr/local/apache-tomcat/webapps/ROOT.war

echo "shutdown.sh"
shutdown.sh

echo "ps auxww | grep tomcat| awk '$NF == "start" { system("kill -9 " $2)}'"
ps auxww | grep "tomcat"| awk '$NF == "start" { system("kill -9 " $2)}'

echo "rm -rf /usr/local/apache-tomcat/webapps/ROOT"
rm -rf /usr/local/apache-tomcat/webapps/ROOT

echo "rm -rf /usr/local/apache-tomcat/work/Catalina/localhost/ROOT"
rm -rf /usr/local/apache-tomcat/work/Catalina/localhost/ROOT

echo "startup.sh"
startup.sh

echo "tail -f /usr/local/apache-tomcat/logs/catalina.out"
tail -f /usr/local/apache-tomcat/logs/catalina.out