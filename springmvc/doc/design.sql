CREATE DATABASE  IF NOT EXISTS `design_shared` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `design_shared`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: design_shared
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority_list`
--

DROP TABLE IF EXISTS `authority_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority_UNIQUE` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_list`
--

LOCK TABLES `authority_list` WRITE;
/*!40000 ALTER TABLE `authority_list` DISABLE KEYS */;
INSERT INTO `authority_list` VALUES (1,'ROLE_LOGIN','登录权限','2018-03-24 06:23:33'),(2,'ROLE_LOGOUT','注销权限','2018-03-24 06:23:33'),(3,'ROLE_ALL_ALL_ALL','超级权限','2018-03-24 06:23:33'),(4,'ROLE_SEARCH','查询权限','2018-03-24 06:23:33'),(5,'ROLE_ADMIN','admin页面权限','2018-03-24 06:49:03'),(6,'ROLE_USER','user页面权限','2018-03-24 06:49:03');
/*!40000 ALTER TABLE `authority_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `first_table`
--

DROP TABLE IF EXISTS `first_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `first_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `first_table`
--

LOCK TABLES `first_table` WRITE;
/*!40000 ALTER TABLE `first_table` DISABLE KEYS */;
INSERT INTO `first_table` VALUES (1,'第一条数据'),(2,'第一条数据'),(3,'第一条数据'),(4,'第一条数据'),(5,'aaaaaaaaa'),(6,'service测试'),(7,'dev');
/*!40000 ALTER TABLE `first_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_group_authorities`
--

DROP TABLE IF EXISTS `user_group_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_group_authorities` (
  `user_group_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group_authorities`
--

LOCK TABLES `user_group_authorities` WRITE;
/*!40000 ALTER TABLE `user_group_authorities` DISABLE KEYS */;
INSERT INTO `user_group_authorities` VALUES (1,1,'2018-03-24 06:39:53'),(1,6,'2018-03-24 06:49:37'),(2,1,'2018-03-24 06:50:07'),(2,6,'2018-03-24 06:50:12'),(2,5,'2018-03-24 06:50:16');
/*!40000 ALTER TABLE `user_group_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_group_list`
--

DROP TABLE IF EXISTS `user_group_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_group_list` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(128) NOT NULL,
  `user_group_type` varchar(128) NOT NULL,
  `is_build_in` int(11) NOT NULL DEFAULT '0',
  `description` varchar(256) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group_list`
--

LOCK TABLES `user_group_list` WRITE;
/*!40000 ALTER TABLE `user_group_list` DISABLE KEYS */;
INSERT INTO `user_group_list` VALUES (1,'GROUP_USER','0',1,'普通用户组','2018-03-23 16:00:00'),(2,'GROUP_ADMIN','1',1,'管理员组','2018-03-23 16:00:00'),(3,'GROUP_SUPER_ADMIN','2',1,'超级管理员组','2018-03-23 16:00:00');
/*!40000 ALTER TABLE `user_group_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_list`
--

DROP TABLE IF EXISTS `user_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_list` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `user_role` int(11) NOT NULL DEFAULT '0',
  `login_count` int(11) NOT NULL DEFAULT '0',
  `last_login_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_list`
--

LOCK TABLES `user_list` WRITE;
/*!40000 ALTER TABLE `user_list` DISABLE KEYS */;
INSERT INTO `user_list` VALUES (1,'ZzzAhu163','zhaozizhang@corp.netease.com',1,0,NULL,'2018-03-24 07:24:16','2018-03-24 07:24:16','zzzlyy'),(2,'user1','a792356291@qq.com',0,0,NULL,'2018-03-24 07:24:44','2018-03-24 07:24:44','user1');
/*!40000 ALTER TABLE `user_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_usergroup_map`
--

DROP TABLE IF EXISTS `user_usergroup_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_usergroup_map` (
  `user_id` int(11) NOT NULL,
  `user_group_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_usergroup_map`
--

LOCK TABLES `user_usergroup_map` WRITE;
/*!40000 ALTER TABLE `user_usergroup_map` DISABLE KEYS */;
INSERT INTO `user_usergroup_map` VALUES (1,2,'2018-03-24 07:32:29'),(1,1,'2018-03-24 07:32:48'),(2,1,'2018-03-24 07:33:03');
/*!40000 ALTER TABLE `user_usergroup_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-25 16:58:14
