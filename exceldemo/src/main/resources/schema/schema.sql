#建表
DROP TABLE IF EXISTS user4;
 CREATE table `user4` (
   `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
   `username` varchar(255) DEFAULT NULL,
   `sex` varchar(255) DEFAULT NULL,
   `number` varchar(255) DEFAULT NULL,
   `branch` varchar(255) DEFAULT NULL,
   `IDcard` varchar(255) DEFAULT NULL,
   `xingzhengban` varchar(255) DEFAULT NULL,
   `jiguan` varchar(255) DEFAULT NULL,
   `biyezhongxue` varchar(255) DEFAULT NULL,
   `phone1` varchar(255) DEFAULT NULL,
   `phone2` varchar(255) DEFAULT NULL,
   `email` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`userId`)
 ) ENGINE=InnoDB AUTO_INCREMENT=10017 DEFAULT CHARSET=utf8;
