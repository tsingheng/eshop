eshop
=====

B2C电子网上商城


<h2>导入eclipse步骤-确保装好maven</h2>
<h3>eshop</h3>
<ol class="task-list">
  <li>确保安装jdk1.8环境</li>
  <li>clone eshop代码</li>
  <li>命令行到项目所在路径</li>
  <li>执行mvn install命令</li>
  <li>执行mvn eclipse:eclipse命令(如果你使用的是myeclipse则执行mvn eclipse:myeclipse)</li>
  <li>导入eclipse/myeclipse</li>
  <li>项目右键->Configure->Convert to maven Project(myeclipse不知道有没有这个选项,这一步不操作也可以)</li>
  <li>创建mysql数据库eshop</li>
  <li>拷贝shop-manager/src/main/resources/config/_jdbc.properties为shop-manager/src/main/resources/config/jdbc.properties并填好数据库参数</li>
  <li>Done!</li>
</ol>
<h3>shangtech-fromework</h3>
<p>shangtech-framework包含一些spring-hibernate的基础类,当你执行完上面的操作以后,项目中应该就有shangtech-framework的jar包了,如果你感兴趣,点击<a href="https://github.com/tsingheng/shangtech-framework">shangtech-framework</a>查看源码</p>
