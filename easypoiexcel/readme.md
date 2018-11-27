#easyPoi 导入导出 Excel/doc
#参考
#1、 官方文档 http://easypoi.mydoc.io/#text_197817
#2、 官方源码  https://gitee.com/lemur/easypoi/tree/master
#3、官方实例 ：https://gitee.com/lemur/easypoi-test
   #3.1 需要源码先分别install 再将.jar 引入maven 仓库 导入如下 pom
   #3.2  基于 4.0 版本
            <dependency>
         			<groupId>cn.afterturn</groupId>
         			<artifactId>easypoi-base</artifactId>
         			<version>4.0.0-SNAPSHOT</version>
         		</dependency>
         		<dependency>
         			<groupId>cn.afterturn</groupId>
         			<artifactId>easypoi-web</artifactId>
         			<version>4.0.0-SNAPSHOT</version>
         		</dependency>
         		<dependency>
         			<groupId>cn.afterturn</groupId>
         			<artifactId>easypoi-annotation</artifactId>
         			<version>4.0.0-SNAPSHOT</version>
         		</dependency>