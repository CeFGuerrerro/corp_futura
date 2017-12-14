CREATE DATABASE  IF NOT EXISTS `corpfutura` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `corpfutura`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: corpfutura
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `codeudores`
--

DROP TABLE IF EXISTS `codeudores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codeudores` (
  `id_codeudor` int(11) NOT NULL,
  `dui` char(10) NOT NULL,
  `dui_codeudor` char(10) NOT NULL,
  PRIMARY KEY (`id_codeudor`,`dui`),
  KEY `fk_CODEUDORES_DATOS_PERSONALES1_idx` (`dui_codeudor`),
  KEY `fk_CODEUDORES_DATOS_PERSONALES2_idx` (`dui`),
  CONSTRAINT `fk_CODEUDORES_DATOS_PERSONALES1` FOREIGN KEY (`dui_codeudor`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CODEUDORES_DATOS_PERSONALES2` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codeudores`
--

LOCK TABLES `codeudores` WRITE;
/*!40000 ALTER TABLE `codeudores` DISABLE KEYS */;
/*!40000 ALTER TABLE `codeudores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditos`
--

DROP TABLE IF EXISTS `creditos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditos` (
  `dui` char(10) NOT NULL,
  `id_solicitud_credito` int(11) NOT NULL,
  `monto` double DEFAULT NULL,
  `plazo` tinyint(4) DEFAULT NULL,
  `cuota` double DEFAULT NULL,
  `forma_pago` tinyint(4) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `fecha_primer_pago` date DEFAULT NULL,
  `asesoria` double DEFAULT NULL,
  `cuota_final` double DEFAULT NULL,
  `descuento_cf` bit(1) DEFAULT NULL,
  `capital_des` double DEFAULT NULL,
  `intereses_des` double DEFAULT NULL,
  `mora_des` double DEFAULT NULL,
  `saldo_pagado` double DEFAULT NULL,
  `saldo_restante` double DEFAULT NULL,
  `interes_pagados` double DEFAULT NULL,
  `iva_pagado` double DEFAULT NULL,
  `mora_pagada` double DEFAULT NULL,
  `cuotas_pagadas` int(5) DEFAULT NULL,
  `cuotas_por_pagar` int(5) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`dui`,`id_solicitud_credito`),
  KEY `fk_CREDITOS_SOLICITUD_CREDITO1_idx` (`dui`,`id_solicitud_credito`),
  CONSTRAINT `fk_CREDITOS_SOLICITUD_CREDITO1` FOREIGN KEY (`dui`, `id_solicitud_credito`) REFERENCES `solicitud_credito` (`dui`, `id_solicitud_credito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditos`
--

LOCK TABLES `creditos` WRITE;
/*!40000 ALTER TABLE `creditos` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_conyugue`
--

DROP TABLE IF EXISTS `datos_conyugue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_conyugue` (
  `dui` char(10) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `lugar_trabajo` varchar(300) DEFAULT NULL,
  `cargo` varchar(200) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`dui`),
  KEY `fk_DATOS_CONYUGUE_DATOS_PERSONALES_idx` (`dui`),
  CONSTRAINT `fk_DATOS_CONYUGUE_DATOS_PERSONALES` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_conyugue`
--

LOCK TABLES `datos_conyugue` WRITE;
/*!40000 ALTER TABLE `datos_conyugue` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_conyugue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_personales`
--

DROP TABLE IF EXISTS `datos_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_personales` (
  `dui` char(10) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `nit` char(17) NOT NULL,
  `estado_civil` tinyint(4) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `fecha_expedicion` date NOT NULL,
  `profesion` varchar(200) NOT NULL,
  `ocupacion` varchar(200) DEFAULT NULL,
  `nivel_estudio` tinyint(4) NOT NULL,
  `cantidad_hijos` varchar(10) NOT NULL,
  `dependen` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`dui`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales`
--

LOCK TABLES `datos_personales` WRITE;
/*!40000 ALTER TABLE `datos_personales` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_personales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `declaracion_bienes`
--

DROP TABLE IF EXISTS `declaracion_bienes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `declaracion_bienes` (
  `id_bien` int(11) NOT NULL,
  `dui` char(10) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `nombre` varchar(300) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL,
  `valuo` double DEFAULT NULL,
  `foto_bien` varchar(200) DEFAULT NULL,
  `total_garantia` double DEFAULT NULL,
  PRIMARY KEY (`id_bien`,`dui`),
  KEY `fk_DECLARACION_BIENES_DATOS_PERSONALES2_idx` (`dui`),
  CONSTRAINT `fk_DECLARACION_BIENES_DATOS_PERSONALES2` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `declaracion_bienes`
--

LOCK TABLES `declaracion_bienes` WRITE;
/*!40000 ALTER TABLE `declaracion_bienes` DISABLE KEYS */;
/*!40000 ALTER TABLE `declaracion_bienes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domicilio` (
  `dui` char(10) NOT NULL,
  `domicilio` varchar(500) NOT NULL,
  `punto_referencia` varchar(1000) DEFAULT NULL,
  `como_llegar` varchar(1000) DEFAULT NULL,
  `tiempo_vivienda` varchar(100) NOT NULL,
  `situacion_vivienta` tinyint(4) NOT NULL,
  PRIMARY KEY (`dui`),
  KEY `fk_DOMICILIO_DATOS_PERSONALES_idx` (`dui`),
  CONSTRAINT `fk_DOMICILIO_DATOS_PERSONALES` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluacion_credito`
--

DROP TABLE IF EXISTS `evaluacion_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluacion_credito` (
  `dui` char(10) NOT NULL,
  `id_solicitud_credito` int(11) NOT NULL,
  `monto` double NOT NULL,
  `plazo` tinyint(4) NOT NULL,
  `cuota` double NOT NULL,
  `forma_pago` tinyint(4) NOT NULL,
  `iva_cuota` double NOT NULL,
  `fecha_evaluacion` date NOT NULL,
  `fuentes_fondos` tinyint(4) NOT NULL,
  `justificacion` varchar(1000) NOT NULL,
  `tipo_garantia` tinyint(4) NOT NULL,
  PRIMARY KEY (`dui`,`id_solicitud_credito`),
  KEY `fk_EVALUACION_CREDITO_SOLICITUD_CREDITO1_idx` (`dui`,`id_solicitud_credito`),
  CONSTRAINT `fk_EVALUACION_CREDITO_SOLICITUD_CREDITO1` FOREIGN KEY (`dui`, `id_solicitud_credito`) REFERENCES `solicitud_credito` (`dui`, `id_solicitud_credito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacion_credito`
--

LOCK TABLES `evaluacion_credito` WRITE;
/*!40000 ALTER TABLE `evaluacion_credito` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacion_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familiares`
--

DROP TABLE IF EXISTS `familiares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familiares` (
  `dui` char(10) NOT NULL,
  `id` int(11) NOT NULL,
  `parentesco` varchar(50) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `lugar_trabajo` varchar(300) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`dui`,`id`),
  KEY `fk_FAMILIARES_DATOS_PERSONALES_idx` (`dui`),
  CONSTRAINT `fk_FAMILIARES_DATOS_PERSONALES` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familiares`
--

LOCK TABLES `familiares` WRITE;
/*!40000 ALTER TABLE `familiares` DISABLE KEYS */;
/*!40000 ALTER TABLE `familiares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_negocio`
--

DROP TABLE IF EXISTS `informacion_negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informacion_negocio` (
  `dui` char(10) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `giro` varchar(200) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `como_llegar` varchar(1000) DEFAULT NULL,
  `tiempo_funcion` varchar(50) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `horarios` varchar(500) DEFAULT NULL,
  `rutas_venta` varchar(500) DEFAULT NULL,
  `utilidad_mensual` varchar(10) NOT NULL,
  `numero_empleados` varchar(10) DEFAULT NULL,
  `tipo_local` tinyint(4) NOT NULL,
  PRIMARY KEY (`dui`),
  KEY `fk_INFORMACION_NEGOCIO_DATOS_PERSONALES1_idx` (`dui`),
  CONSTRAINT `fk_INFORMACION_NEGOCIO_DATOS_PERSONALES1` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_negocio`
--

LOCK TABLES `informacion_negocio` WRITE;
/*!40000 ALTER TABLE `informacion_negocio` DISABLE KEYS */;
/*!40000 ALTER TABLE `informacion_negocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mora`
--

DROP TABLE IF EXISTS `mora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mora` (
  `id_mora` int(11) NOT NULL,
  `dui` char(10) NOT NULL,
  `id_solicitud_credito` int(11) NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `mora_total` double DEFAULT NULL,
  `mora_cancelada` double DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `fecha_cancelacion` date DEFAULT NULL,
  PRIMARY KEY (`id_mora`),
  KEY `fk_MORA_CREDITOS1` (`dui`,`id_solicitud_credito`),
  CONSTRAINT `fk_MORA_CREDITOS1` FOREIGN KEY (`dui`, `id_solicitud_credito`) REFERENCES `solicitud_credito` (`dui`, `id_solicitud_credito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mora`
--

LOCK TABLES `mora` WRITE;
/*!40000 ALTER TABLE `mora` DISABLE KEYS */;
/*!40000 ALTER TABLE `mora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos` (
  `id_pago` int(11) NOT NULL,
  `dui` char(10) NOT NULL,
  `id_solicitud_credito` int(11) NOT NULL,
  `num_factura` varchar(15) DEFAULT NULL,
  `monto_pagado` double DEFAULT NULL,
  `capital_abonado` double DEFAULT NULL,
  `interes` double DEFAULT NULL,
  `iva_intereses` double DEFAULT NULL,
  `iva_mora` double DEFAULT NULL,
  `mora` double DEFAULT NULL,
  `cuota_numero` int(11) DEFAULT NULL,
  `cancelado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `fk_PAGOS_CREDITOS1` (`dui`,`id_solicitud_credito`),
  CONSTRAINT `fk_PAGOS_CREDITOS1` FOREIGN KEY (`dui`, `id_solicitud_credito`) REFERENCES `solicitud_credito` (`dui`, `id_solicitud_credito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referencias`
--

DROP TABLE IF EXISTS `referencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referencias` (
  `dui` char(10) NOT NULL,
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `empresa` varchar(300) DEFAULT NULL,
  `parentesco` varchar(50) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `tipo_referencia` bit(1) NOT NULL,
  PRIMARY KEY (`dui`,`id`),
  KEY `fk_REFERENCIAS_DATOS_PERSONALES1_idx` (`dui`),
  CONSTRAINT `fk_REFERENCIAS_DATOS_PERSONALES1` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referencias`
--

LOCK TABLES `referencias` WRITE;
/*!40000 ALTER TABLE `referencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `referencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_credito`
--

DROP TABLE IF EXISTS `solicitud_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud_credito` (
  `id_solicitud_credito` int(11) NOT NULL,
  `dui` char(10) NOT NULL,
  `fecha_solicitud` date NOT NULL,
  `tipo_credito` tinyint(4) NOT NULL,
  `monto_requerido` double NOT NULL,
  `plazo` tinyint(4) NOT NULL,
  `cuota` double NOT NULL,
  `iva_cuota` double NOT NULL,
  `forma_pago` tinyint(4) NOT NULL,
  `destino_credito` varchar(300) DEFAULT NULL,
  `estado` tinyint(4) NOT NULL,
  `observacion` varchar(1000) DEFAULT NULL,
  `visita` bit(1) DEFAULT NULL,
  `estados_financieros` bit(1) DEFAULT NULL,
  `fecha_visita` date NULL,
  `infored` tinyint(4) NULL,
  `desembolso` bit(1) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`dui`,`id_solicitud_credito`),
  KEY `fk_SOLICITUD_CREDITO_DATOS_PERSONALES1_idx` (`dui`),
  KEY `fk_SOLICITUD_CREDITO_USUARIOS1_idx` (`id_usuario`),
  CONSTRAINT `fk_SOLICITUD_CREDITO_DATOS_PERSONALES1` FOREIGN KEY (`dui`) REFERENCES `datos_personales` (`dui`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SOLICITUD_CREDITO_USUARIOS1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_credito`
--

LOCK TABLES `solicitud_credito` WRITE;
/*!40000 ALTER TABLE `solicitud_credito` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `rol` tinyint(4) DEFAULT NULL,
  `cartera` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'david ','12345',1,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-29 11:24:21
