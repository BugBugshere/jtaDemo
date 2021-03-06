DROP DATABASE IF EXISTS `jta-income`;

CREATE DATABASE `jta-income`;

USE `jta-income`;

DROP TABLE IF EXISTS `income`;

CREATE TABLE `income` (
                          `id` INT(20) NOT NULL AUTO_INCREMENT,
                          `userId` INT(20) NOT NULL,
                          `amount` FLOAT(8,2) NOT NULL,
  `operateDate` DATETIME  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP DATABASE IF EXISTS `jta-user`;

CREATE DATABASE `jta-user`;

USE `jta-user`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` INT(20) NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(50) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;