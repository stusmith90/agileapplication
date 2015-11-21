-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bsf-agile-tracking
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Current Database: `bsf-agile-tracking`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bsf-agile-tracking` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bsf-agile-tracking`;

--
-- Table structure for table `backlog`
--

DROP TABLE IF EXISTS `backlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `backlog` (
  `backlog_id` int(11) NOT NULL AUTO_INCREMENT,
  `backlog_type` varchar(255) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `project_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`backlog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backlog`
--

LOCK TABLES `backlog` WRITE;
/*!40000 ALTER TABLE `backlog` DISABLE KEYS */;
INSERT INTO `backlog` VALUES (1,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-01',0,NULL),(2,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-01',0,NULL),(3,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-11',0,NULL),(4,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-11',0,NULL),(5,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-11',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateUpdateEndDate()'),(6,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-10',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateUpdateName() - Updated'),(7,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-11',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateCreate()'),(8,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-09','2013-11-10',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateUpdateStartDate()'),(9,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-11',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateUpdateEndDate()'),(10,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-10',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateUpdateName() - Updated'),(11,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-10','2013-11-11',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateCreate()'),(12,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-09','2013-11-10',0,'edu.lmu.bfs.ase2.model.SprintBacklogTest.testHibernateUpdateStartDate()'),(13,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(14,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(15,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-17','2013-11-18',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(16,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-18',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated'),(17,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(18,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(19,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(20,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-17','2013-11-18',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(21,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-18',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated'),(22,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-19','2013-11-20',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(23,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-19','2013-11-20',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(24,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-18','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(25,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-19','2013-11-20',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(26,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-19','2013-11-19',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated'),(27,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(28,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogStartDate()'),(29,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogEndDate()'),(30,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogName() - Updated'),(31,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(32,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(33,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogStartDate()'),(34,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogEndDate()'),(35,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogName() - Updated'),(36,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(37,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(38,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(39,'productBacklog','2013-11-30','2013-12-01',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(40,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(41,'productBacklog','2013-12-01','2013-12-01',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated'),(42,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(43,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogStartDate()'),(44,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogEndDate()'),(45,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogName() - Updated'),(46,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(47,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(48,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogName() - Updated'),(49,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(50,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogUserStories()'),(51,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogUserStories()'),(52,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'Product Backlog'),(53,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogUserStories()'),(54,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(55,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogUserStories()'),(56,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogName() - Updated'),(57,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(58,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(59,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(60,'productBacklog','2013-11-30','2013-12-01',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(61,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(62,'productBacklog','2013-12-01','2013-12-01',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated'),(63,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(64,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogUserStories()'),(65,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testUpdateProductBacklogName() - Updated'),(66,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,0,'edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImplTest.testCreateProductBacklog()'),(67,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(68,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(69,'productBacklog','2013-11-30','2013-12-01',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(70,'productBacklog','2013-12-01','2013-12-02',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(71,'productBacklog','2013-12-01','2013-12-01',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated'),(72,'edu.lmu.bfs.ase2.model.ProductBacklog',NULL,NULL,1,'Product Backlog'),(73,'productBacklog','2013-12-04','2013-12-05',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(74,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-10-29','2013-11-05',1,'Sprint Backlog - Sprint 1'),(75,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-05','2013-11-12',1,'Sprint Backlog - Sprint 2'),(76,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-12','2013-11-19',1,'Sprint Backlog - Sprint 3'),(77,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-19','2013-11-26',1,'Sprint Backlog - Sprint 4'),(78,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-11-26','2013-12-03',1,'Sprint Backlog - Sprint 5'),(79,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-12-05','2013-12-06',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()'),(80,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-12-05','2013-12-06',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(81,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-12-04','2013-12-05',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()'),(82,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-12-05','2013-12-06',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()'),(83,'edu.lmu.bfs.ase2.model.SprintBacklog','2013-12-05','2013-12-05',0,'edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated');
/*!40000 ALTER TABLE `backlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (0,'My Project'),(1,'Work for ASE Assignment 2 - An Agile Tracking Tool');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text,
  `assigned_to` int(11) DEFAULT NULL,
  `estimate` int(11) DEFAULT NULL,
  `status` text,
  `user_story_id` int(11) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'DB Changes','DB Changes to add the Backlog table',1,1,'Complete',3),(2,'Model Class changes','Create Backlog, ProductBacklog classes and JUnit tests',2,3,'Complete',3),(3,'Hibernate changes','Create DAO and Impl classes and hibernate config',3,6,'Complete',3),(4,'User interface changes','Create Product Backlog Details window, listing User stories (dep. on User Story tasks)',1,12,'Complete',3);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_progress`
--

DROP TABLE IF EXISTS `task_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_progress` (
  `task_progress_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `time_spent` int(11) DEFAULT NULL,
  `time_remaining` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`task_progress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_progress`
--

LOCK TABLES `task_progress` WRITE;
/*!40000 ALTER TABLE `task_progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'SysAdmin','Pa55word','System Admin','edu.lmu.bfs.ase2.model.SystemAdmin'),(1,'Bamo','password','Bamo Nadir','edu.lmu.bfs.ase2.model.TeamMember'),(2,'Stuart','password','Stuart Smith','edu.lmu.bfs.ase2.model.TeamMember'),(3,'Fran','password','Fran Vaughan','edu.lmu.bfs.ase2.model.TeamMember'),(4,'fran1385509071989','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testUpdateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(5,'fran1385509072267','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(6,'fran1385509072881','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(7,'updt1385511994202','franupdated','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.ProductOwner'),(8,'fran1385512089532','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.SystemAdmin'),(9,'fran1385512116851','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.SystemAdmin'),(10,'fran1385512117282','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.SystemAdmin'),(11,'fran1385512117424','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.SystemAdmin'),(12,'updt1385934074053','franupdated','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.SystemAdmin'),(13,'fran1385934074430','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.SystemAdmin'),(14,'fran1385934074699','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.SystemAdmin'),(15,'fran1385934075120','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.SystemAdmin'),(16,'fran1385934075262','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.SystemAdmin'),(17,'updt1385934075425','franupdated','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.TeamMember'),(18,'fran1385934075596','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(19,'fran1385934075720','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(20,'fran1385934076036','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.TeamMember'),(21,'fran1385934076169','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(22,'updt1385934077329','franupdated','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.ProductOwner'),(23,'fran1385934077446','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.ProductOwner'),(24,'fran1385934077659','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.ProductOwner'),(25,'fran1385934077842','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.ProductOwner'),(26,'fran1385934077968','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.ProductOwner'),(27,'updt1385936949414','franupdated','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.SystemAdmin'),(28,'fran1385936949740','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.SystemAdmin'),(29,'fran1385936950019','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.SystemAdmin'),(30,'fran1385936950439','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.SystemAdmin'),(31,'fran1385936950597','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.SystemAdmin'),(32,'updt1385936950730','franupdated','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.TeamMember'),(33,'fran1385936950854','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(34,'fran1385936951005','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(35,'fran1385936951245','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.TeamMember'),(36,'fran1385936951351','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(37,'updt1385936952376','franupdated','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.ProductOwner'),(38,'fran1385936952474','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.ProductOwner'),(39,'fran1385936952556','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.ProductOwner'),(40,'fran1385936952729','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.ProductOwner'),(41,'fran1385936952855','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.ProductOwner');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_story`
--

DROP TABLE IF EXISTS `user_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_story` (
  `user_story_id` int(11) NOT NULL,
  `backlog_id` int(11) NOT NULL,
  `product_owner` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `acceptance_criteria` varchar(2000) DEFAULT NULL,
  `story_point_estimate` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_story_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_story`
--

LOCK TABLES `user_story` WRITE;
/*!40000 ALTER TABLE `user_story` DISABLE KEYS */;
INSERT INTO `user_story` VALUES (1,72,NULL,0,'As a Team Member I want to move User Stories from the Product Backlog to the Sprint Backlog.  The User Stories in the Sprint Backlog will represent the requirements for the work that the development team will complete during that Sprint.','As a Team Member I want to move User Stories from the Product Backlog to the Sprint Backlog.  The User Stories in the Sprint Backlog will represent the requirements for the work that the development team will complete during that Sprint.',NULL,0),(2,72,NULL,0,'As a Team Member, I want to be able to move any Tasks remaining at the end of the Sprint either back into the Product Backlog, or onto the next Sprint.  This is so that any unfulfilled Tasks can be completed in the next Sprint.','As a Team Member, I want to be able to move any Tasks remaining at the end of the Sprint either back into the Product Backlog, or onto the next Sprint.  This is so that any unfulfilled Tasks can be completed in the next Sprint.',NULL,0),(3,74,NULL,0,'As a Product Owner, I want to create  a Product Backlog.','As a Product Owner, I want to create  a Product Backlog.',NULL,0),(4,74,NULL,0,'As a Product Owner, I want to be able to add User Stories with descriptions to the Product Backlog.				','As a Product Owner, I want to be able to add User Stories with descriptions to the Product Backlog.	',NULL,0);
/*!40000 ALTER TABLE `user_story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `bsf-agile-tracking-test`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bsf-agile-tracking-test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bsf-agile-tracking-test`;

--
-- Table structure for table `backlog`
--

DROP TABLE IF EXISTS `backlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `backlog` (
  `backlog_id` int(11) NOT NULL AUTO_INCREMENT,
  `backlog_type` text NOT NULL,
  `name` text,
  `project_id` int(11) NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`backlog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backlog`
--

LOCK TABLES `backlog` WRITE;
/*!40000 ALTER TABLE `backlog` DISABLE KEYS */;
INSERT INTO `backlog` VALUES (1,'edu.lmu.bfs.ase2.model.SprintBacklog','edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogEndDate()',0,'2013-11-20','2013-11-21'),(2,'edu.lmu.bfs.ase2.model.SprintBacklog','edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()',0,'2013-11-20','2013-11-21'),(3,'edu.lmu.bfs.ase2.model.SprintBacklog','edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogStartDate()',0,'2013-11-19','2013-11-20'),(4,'edu.lmu.bfs.ase2.model.SprintBacklog','edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testCreateSprintBacklog()',0,'2013-11-20','2013-11-21'),(5,'edu.lmu.bfs.ase2.model.SprintBacklog','edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImplTest.testUpdateSprintBacklogName() - Updated',0,'2013-11-20','2013-11-20');
/*!40000 ALTER TABLE `backlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` text,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (0,'My Project'),(2,'My Project'),(3,'My Project');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project2`
--

DROP TABLE IF EXISTS `project2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project2` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` text,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project2`
--

LOCK TABLES `project2` WRITE;
/*!40000 ALTER TABLE `project2` DISABLE KEYS */;
/*!40000 ALTER TABLE `project2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text,
  `assigned_to` int(11) DEFAULT NULL,
  `estimate` int(11) DEFAULT NULL,
  `status` text,
  `user_story_id` int(11) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_progress`
--

DROP TABLE IF EXISTS `task_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_progress` (
  `task_progress_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `time_spent` int(11) DEFAULT NULL,
  `time_remaining` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`task_progress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_progress`
--

LOCK TABLES `task_progress` WRITE;
/*!40000 ALTER TABLE `task_progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text,
  `name` text,
  `role` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'SysAdmin','Pa55word','System Admin','edu.lmu.bfs.ase2.model.SystemAdmin'),(1,'fran','FRAN','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testCreateTeamMember()','edu.lmu.bfs.ase2.model.TeamMember'),(2,'fran1384981227030','FRAN','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testCreateTeamMember()','edu.lmu.bfs.ase2.model.TeamMember'),(3,'fran1384981313787','FRAN','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testCreateTeamMember()','edu.lmu.bfs.ase2.model.TeamMember'),(4,'fran1384981629032','fran','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testGetTeamMemberByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(5,'fran1384981629569','fran','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testCreateTeamMember()','edu.lmu.bfs.ase2.model.TeamMember'),(6,'fran1384981683336','fran','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testGetTeamMemberByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(7,'fran1384981784131','fran','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testGetTeamMemberByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(8,'fran1384981826398','fran','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testGetTeamMemberByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(9,'fran1384981877340','fran','edu.lmu.bfs.ase2.dao.impl.UserDAOImplTest.testGetTeamMemberByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(10,'fran1385153167915','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(11,'fran1385153647909','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(12,'fran1385153856318','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(13,'fran1385153865588','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(14,'fran1385153880578','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(15,'fran1385153880970','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetTeamMemberByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(16,'fran1385153881187','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testUpdateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(17,'fran1385153881387','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(18,'fran1385153881738','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testDeleteUser()','edu.lmu.bfs.ase2.model.TeamMember'),(19,'fran1385154029325','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsers()','edu.lmu.bfs.ase2.model.TeamMember'),(20,'franupdated1385154029728','franupdated','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.TeamMember'),(21,'fran1385154029922','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(22,'fran1385154030119','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(23,'fran1385154030465','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.TeamMember'),(24,'fran1385154121626','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUsers()','edu.lmu.bfs.ase2.model.ProductOwner'),(25,'franupdated1385154122043','franupdated','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.ProductOwner'),(26,'fran1385154122285','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.ProductOwner'),(27,'fran1385154122518','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.ProductOwner'),(28,'fran1385154122989','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.ProductOwner'),(29,'fran1385156984312','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsers()','edu.lmu.bfs.ase2.model.TeamMember'),(30,'fran1385156991473','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsers()','edu.lmu.bfs.ase2.model.TeamMember'),(31,'franupdated1385156991982','franupdated','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.TeamMember'),(32,'fran1385156992188','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.TeamMember'),(33,'fran1385156992407','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.TeamMember'),(34,'fran1385156992769','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.TeamMember'),(35,'fran1385156992892','fran','edu.lmu.bfs.ase2.dao.impl.TeamMemberDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.TeamMember'),(36,'fran1385157099412','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUsers()','edu.lmu.bfs.ase2.model.ProductOwner'),(37,'franupdated1385157099825','franupdated','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.ProductOwner'),(38,'fran1385157100028','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.ProductOwner'),(39,'fran1385157100235','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.ProductOwner'),(40,'fran1385157100583','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.ProductOwner'),(41,'fran1385157100700','fran','edu.lmu.bfs.ase2.dao.impl.ProductOwnerDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.ProductOwner'),(42,'fran1385157162811','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUsers()','edu.lmu.bfs.ase2.model.SystemAdmin'),(43,'franupdated1385157163188','franupdated','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testUpdateUser() Updated','edu.lmu.bfs.ase2.model.SystemAdmin'),(44,'fran1385157163387','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetByUsername()','edu.lmu.bfs.ase2.model.SystemAdmin'),(45,'fran1385157163608','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testCreateUser()','edu.lmu.bfs.ase2.model.SystemAdmin'),(46,'fran1385157163960','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUserById()','edu.lmu.bfs.ase2.model.SystemAdmin'),(47,'fran1385157164124','fran','edu.lmu.bfs.ase2.dao.impl.SystemAdminDAOImplTest.testGetUsersByRole()','edu.lmu.bfs.ase2.model.SystemAdmin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_story`
--

DROP TABLE IF EXISTS `user_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_story` (
  `user_story_id` int(11) NOT NULL,
  `backlog_id` int(11) NOT NULL,
  `product_owner` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `title` text,
  `description` text,
  `acceptance_criteria` text,
  `story_point_estimate` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_story_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_story`
--

LOCK TABLES `user_story` WRITE;
/*!40000 ALTER TABLE `user_story` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_story` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-08  3:02:49
