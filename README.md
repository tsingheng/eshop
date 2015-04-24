eshop
=====

电子网上商城


## 导入eclipse步骤-确保装好maven
### eshop
1. 确保安装jdk1.7环境
2. clone eshop代码
3. 命令行到项目所在路径
4. 执行mvn install命令
5. 执行mvn eclipse:eclipse命令(如果你使用的是myeclipse则执行mvn eclipse:myeclipse)</li>
6. 导入eclipse/myeclipse
7. 项目右键->Configure->Convert to maven Project(myeclipse不知道有没有这个选项,这一步不操作也可以)
8. 创建mysql数据库eshop
9. 拷贝shop-manager/src/main/resources/config/_jdbc.properties为shop-manager/src/main/resources/config/jdbc.properties并填好数据库参数
10. Done!   

### shangtech-fromework
shangtech-framework包含一些spring-hibernate的基础类,当你执行完上面的操作以后,项目中应该就有shangtech-framework的jar包了,如果你感兴趣,点击[shangtech-framework](https://github.com/tsingheng/shangtech-framework)查看源码
