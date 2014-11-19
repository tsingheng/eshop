eshop
=====

B2C电子网上商城


<h2>导入eclipse步骤-确保装好maven</h2>
<h3>下载shangtech-fromework</h3>
<ol class="task-list">
	<li>fork and clone <a href="https://github.com/tsingheng/shangtech-framework">shangtech-framework</a></li>
	<li>命令行到shangtech-framework目录</li>
	<li>执行mvn install命令</li>
	<li>如果要导入shangtech-framework就继续执行下面的步骤</li>
	<li>执行mvn eclipse:eclipse命令</li>
	<li>eclipse import</li>
	<li>项目右键->Configure->Convert to maven Project</li>
</ol>
<h3>eshop</h3>
<ol class="task-list">
  <li>clone eshop代码</li>
  <li>命令行到项目所在路径</li>
  <li>执行mvn install命令</li>
  <li>执行mvn eclipse:eclipse命令</li>
  <li>导入eclipse</li>
  <li>项目右键->Configure->Convert to maven Project</li>
  <li>Done!</li>
</ol>