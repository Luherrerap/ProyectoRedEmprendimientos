-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: red_emprendimientos
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `id_comentario` int NOT NULL AUTO_INCREMENT,
  `contenido` mediumtext,
  `fecha_comentario` datetime DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_informacion_emprendimiento` int NOT NULL,
  `id_publicaciones` int NOT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `fk_Comentario_Usuario1_idx` (`id_usuario`),
  KEY `fk_Comentario_Informacion_emprendimiento1_idx` (`id_informacion_emprendimiento`),
  KEY `fk_Comentario_Publicaciones1_idx` (`id_publicaciones`),
  CONSTRAINT `fk_Comentario_Informacion_emprendimiento1` FOREIGN KEY (`id_informacion_emprendimiento`) REFERENCES `informacion_emprendimiento` (`id_informacion_emprendimiento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Comentario_Publicaciones1` FOREIGN KEY (`id_publicaciones`) REFERENCES `publicaciones` (`id_publicaciones`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Comentario_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_usuario`
--

DROP TABLE IF EXISTS `datos_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_usuario` (
  `id_datos_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `apellidos_usuario` varchar(100) NOT NULL,
  `biografia_usuario` mediumtext,
  `pais_usuario` varchar(45) NOT NULL,
  `etnia` varchar(100) DEFAULT NULL,
  `genero` varchar(100) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_region` int NOT NULL,
  PRIMARY KEY (`id_datos_usuario`,`id_usuario`),
  KEY `fk_Datos_usuario_Usuario1_idx` (`id_usuario`),
  KEY `fk_Datos_usuario_Region1_idx` (`id_region`),
  CONSTRAINT `fk_Datos_usuario_Region1` FOREIGN KEY (`id_region`) REFERENCES `region` (`id_region`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Datos_usuario_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_usuario`
--

LOCK TABLES `datos_usuario` WRITE;
/*!40000 ALTER TABLE `datos_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_emprendimiento`
--

DROP TABLE IF EXISTS `informacion_emprendimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_emprendimiento` (
  `id_informacion_emprendimiento` int NOT NULL AUTO_INCREMENT,
  `nombre_emprendimiento` varchar(100) NOT NULL,
  `descripcion_emprendimiento` mediumtext NOT NULL,
  `imagen_emprendimiento_url` varchar(255) DEFAULT NULL,
  `fecha_creacion_emprendimiento` datetime DEFAULT NULL,
  `estado_emprendimiento` bit(1) DEFAULT NULL,
  `id_tipo_emprendimiento` int NOT NULL,
  `id_usuario` int NOT NULL,
  `id_region` int NOT NULL,
  PRIMARY KEY (`id_informacion_emprendimiento`),
  KEY `fk_Informacion_emprendimiento_Tipo_emprendimiento1_idx` (`id_tipo_emprendimiento`),
  KEY `fk_Informacion_emprendimiento_Usuario1_idx` (`id_usuario`),
  KEY `fk_Informacion_emprendimiento_Region1_idx` (`id_region`),
  CONSTRAINT `fk_Informacion_emprendimiento_Region1` FOREIGN KEY (`id_region`) REFERENCES `region` (`id_region`),
  CONSTRAINT `fk_Informacion_emprendimiento_Tipo_emprendimiento1` FOREIGN KEY (`id_tipo_emprendimiento`) REFERENCES `tipo_emprendimiento` (`id_tipo_emprendimiento`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_Informacion_emprendimiento_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_emprendimiento`
--

LOCK TABLES `informacion_emprendimiento` WRITE;
/*!40000 ALTER TABLE `informacion_emprendimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `informacion_emprendimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like`
--

DROP TABLE IF EXISTS `like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like` (
  `id_like` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_publicaciones` int NOT NULL,
  `id_informacion_emprendimiento` int NOT NULL,
  PRIMARY KEY (`id_like`),
  KEY `fk_Like_Usuario1_idx` (`id_usuario`),
  KEY `fk_Like_Publicaciones1_idx` (`id_publicaciones`),
  KEY `fk_Like_Informacion_emprendimiento1_idx` (`id_informacion_emprendimiento`),
  CONSTRAINT `fk_Like_Informacion_emprendimiento1` FOREIGN KEY (`id_informacion_emprendimiento`) REFERENCES `informacion_emprendimiento` (`id_informacion_emprendimiento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Like_Publicaciones1` FOREIGN KEY (`id_publicaciones`) REFERENCES `publicaciones` (`id_publicaciones`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Like_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like`
--

LOCK TABLES `like` WRITE;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
/*!40000 ALTER TABLE `like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id_like` int NOT NULL AUTO_INCREMENT,
  `id_informacion_emprendimiento` int DEFAULT NULL,
  `id_publicaciones` int DEFAULT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_like`),
  KEY `FK4iv9xene17fm8y2q806pykpr4` (`id_informacion_emprendimiento`),
  KEY `FKnv3v7xjgwpudkgu37gfftk3is` (`id_publicaciones`),
  KEY `FKti6pt3sq20qhpl2mqvwtix8e1` (`id_usuario`),
  CONSTRAINT `FK4iv9xene17fm8y2q806pykpr4` FOREIGN KEY (`id_informacion_emprendimiento`) REFERENCES `informacion_emprendimiento` (`id_informacion_emprendimiento`),
  CONSTRAINT `FKnv3v7xjgwpudkgu37gfftk3is` FOREIGN KEY (`id_publicaciones`) REFERENCES `publicaciones` (`id_publicaciones`),
  CONSTRAINT `FKti6pt3sq20qhpl2mqvwtix8e1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicaciones`
--

DROP TABLE IF EXISTS `publicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicaciones` (
  `id_publicaciones` int NOT NULL AUTO_INCREMENT,
  `titulo_publicacion` varchar(250) NOT NULL,
  `contenido_publicacion` mediumtext NOT NULL,
  `fecha_creacion_publicacion` datetime DEFAULT NULL,
  `imagen_publicacion` varchar(255) DEFAULT NULL,
  `estado_publicacion` bit(1) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_emprendimiento` int NOT NULL,
  PRIMARY KEY (`id_publicaciones`),
  KEY `fk_Publicaciones_Usuario1_idx` (`id_usuario`),
  KEY `FK8y3nu3kuo79hdeidugnot27qk` (`id_emprendimiento`),
  CONSTRAINT `FK8y3nu3kuo79hdeidugnot27qk` FOREIGN KEY (`id_emprendimiento`) REFERENCES `informacion_emprendimiento` (`id_informacion_emprendimiento`),
  CONSTRAINT `fk_Publicaciones_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicaciones`
--

LOCK TABLES `publicaciones` WRITE;
/*!40000 ALTER TABLE `publicaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region` (
  `id_region` int NOT NULL AUTO_INCREMENT,
  `nombre_region` varchar(100) NOT NULL,
  PRIMARY KEY (`id_region`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Caribe'),(2,'Andina'),(3,'Pacifica'),(4,'Orinoquia'),(5,'Amazonia'),(6,'Insular');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_roles` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(255) NOT NULL,
  `fecha_creado` datetime NOT NULL,
  `modificado` datetime NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_roles`),
  KEY `fk_Roles_Usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_Roles_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_emprendimiento`
--

DROP TABLE IF EXISTS `tipo_emprendimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_emprendimiento` (
  `id_tipo_emprendimiento` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo_emprendimiento` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo_emprendimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_emprendimiento`
--

LOCK TABLES `tipo_emprendimiento` WRITE;
/*!40000 ALTER TABLE `tipo_emprendimiento` DISABLE KEYS */;
INSERT INTO `tipo_emprendimiento` VALUES (1,'Tecnología'),(2,'Comercio y Retail'),(3,'Salud y Bienestar'),(4,'Educación y Formación'),(5,'Medio Ambiente y Sostenibilidad'),(6,'Entretenimiento y Medios'),(7,'Alimentación y Gastronomía'),(8,'Finanzas y Negocios');
/*!40000 ALTER TABLE `tipo_emprendimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo` varchar(50) NOT NULL,
  `descripcion` tinytext,
  `estado_tipo_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Emprendedor','x',1),(2,'Admin','c',1);
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `email_usuario` varchar(100) NOT NULL,
  `password_usuario` varchar(100) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `actualizado` datetime DEFAULT NULL,
  `estado_usuario` tinyint DEFAULT NULL,
  `id_tipo_usuario` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_UNIQUE` (`email_usuario`),
  KEY `fk_Usuario_Tipo_usuario1_idx` (`id_tipo_usuario`),
  CONSTRAINT `fk_Usuario_Tipo_usuario1` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-04 18:11:33
