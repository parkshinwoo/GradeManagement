-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: grade_management
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `StudentID` int(11) NOT NULL AUTO_INCREMENT,
  `Student_name` varchar(30) NOT NULL,
  `Attendance` int(11) DEFAULT '0',
  `Late` int(11) DEFAULT '0',
  `Absent` int(11) DEFAULT '0',
  `Midterm` int(11) DEFAULT '0',
  `Final` int(11) DEFAULT '0',
  `Presentation` int(11) DEFAULT '0',
  `Project_proposal` int(11) DEFAULT '0',
  `Requirement_specification` int(11) DEFAULT '0',
  `Gui_plan` int(11) DEFAULT '0',
  `Design_specification` int(11) DEFAULT '0',
  `Project_code` int(11) DEFAULT '0',
  `Final_report` int(11) DEFAULT '0',
  `Total_score` int(11) DEFAULT '0',
  `Grade` varchar(8) NOT NULL DEFAULT '아직 부여 안됌',
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'박신우',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(2,'조태구',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(3,'김혜인',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(4,'임주영',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(5,'아이린',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(6,'예리',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(7,'웬디',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(8,'조이',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(9,'슬기',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(10,'나연',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(11,'지효',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(12,'다현',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(13,'모모',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(14,'사나',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(15,'쯔위',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(16,'미나',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(17,'정연',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(18,'채영',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(19,'유재석',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(20,'박명수',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(21,'정준하',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(22,'노홍철',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(23,'정형돈',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(24,'하하',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(25,'전진',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(26,'길',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(27,'황광희',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(28,'박재범',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(29,'김연아',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌'),(30,'박찬호',0,0,0,0,0,0,0,0,0,0,0,0,0,'아직 부여 안됌');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-01  1:46:24
