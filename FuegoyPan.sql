-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: serverless-us-central1.sysp0000.db2.skysql.com    Database: FuegoyPan
-- ------------------------------------------------------
-- Server version	11.8.6-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,'Pan','unidades',NULL),(2,'Carne','kg',NULL),(3,'Queso','rebanadas',NULL),(4,'Lechuga','kg',NULL),(5,'Tomate','kg',NULL),(6,'Patata','kg',NULL),(7,'Aceite','litros',NULL),(8,'Carne de vaca','gr',NULL),(9,'Carne de vaca madurada 30 días','gr',NULL),(10,'Patty de carne','und',NULL),(11,'Doble patty','und',NULL),(12,'Pollo crujiente','gr',NULL),(13,'Heura burger (vegana)','und',NULL),(14,'Pulled pork BBQ','gr',NULL),(15,'Carrillada asada','gr',NULL),(16,'Bacon','gr',NULL),(17,'Bacon crujiente','gr',NULL),(18,'Taquitos de jamón','gr',NULL),(19,'Fingers de pollo','gr',NULL),(20,'Alitas de pollo','gr',NULL),(21,'Nuggets de pollo','gr',NULL),(22,'Queso cheddar','gr',NULL),(23,'Doble queso cheddar','gr',NULL),(24,'Queso edam','gr',NULL),(25,'Polvo de queso','gr',NULL),(26,'Cheddar líquido','gr',NULL),(27,'Pan de burger','und',NULL),(28,'Pan brioche','und',NULL),(29,'Cebolla','gr',NULL),(30,'Cebolla morada','gr',NULL),(31,'Cebolla crujiente','gr',NULL),(32,'Pepinillo','gr',NULL),(33,'Pepinillo picado','gr',NULL),(34,'Jalapeño','gr',NULL),(35,'Salsa Oculto','ml',NULL),(36,'Salsa BBQ','ml',NULL),(37,'Salsa Emmy','ml',NULL),(38,'Salsa Mayo-Bacon','ml',NULL),(39,'Mayo Trufada','ml',NULL),(40,'Alioli','ml',NULL),(41,'Salsa Ranchera','ml',NULL),(42,'Mermelada de bacon','gr',NULL),(43,'Huevo frito','und',NULL),(44,'Bits de chicharrones fritos','gr',NULL),(45,'Setas','gr',NULL),(46,'Trufa','gr',NULL),(47,'Pimentón de la Vera','gr',NULL),(48,'Sal','gr',NULL),(49,'Cebollino','gr',NULL),(50,'Patatas fritas','gr',NULL),(51,'Boniatos','gr',NULL),(52,'Bacon Bits','gr',NULL),(53,'Queso para tarta','gr',NULL),(54,'Pistacho','gr',NULL),(55,'Chocolate','gr',NULL),(56,'Galletas Oreo','gr',NULL),(57,'Helado de vainilla','gr',NULL),(58,'Leche','ml',NULL),(59,'Cerveza','ml',NULL),(60,'Refresco','ml',NULL),(61,'Agua','ml',NULL),(62,'Bebida energética','ml',NULL),(63,'Azúcar','kg',NULL);
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `visible` bit(1) DEFAULT NULL,
  `category` enum('bebida','comida','postre','salsa') DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Cheese Burger','Hamburguesa con queso, lechuga y tomate',8.5,_binary '','comida','/images/products/cheese-burger.jpg'),(2,'Patatas Fritas','Patatas fritas crujientes',3.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/985db78ff6d2581097e69ed5b3859f94/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(3,'La Faraona','Doble patty, doble queso cheddar, bacon crujiente...',12.5,_binary '','comida','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPfMfSIsi9H4x0wbz92QB0ZAPSdPzSdt4r5w&s'),(4,'BBQ Cheeseburger','Doble patty, doble queso cheddar, bacon crujiente, salsa BBQ, alioli y pepinillo picado',11.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/9a71a30dbfee81af31fc6718b7acccfc/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(5,'Alan Garner','Doble patty, doble queso cheddar, bacon crujiente y Salsa Oculto',10.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/f5835a7fb660d0f7ed0726944f8ee5fb/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(6,'Pedroxes','Doble patty, queso edam, mermelada bacon, carrillada asada, taquitos de jamon y polvo de queso',12.5,_binary '','comida','https://lamejorhamburguesa.com/html5Upload/server/php/files/medium/pedroxessala1.jpg'),(7,'TruFake','Doble patty, doble queso cheddar, bacon crujiente, huevo frito y mayo Trufada',12.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/1f452b1580dec852447dcd72cc09b8f2/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(8,'Harvey','Doble patty, doble queso cheddar, bacon crujiente, lechuga, tomate, cebolla morada y salsa Oculto',11.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/98624fea4725932d43356ac8df86c85a/7f4ae9ca0446cbc23e71d8d395a98428.jpeg'),(9,'Madurada','Carne vaca madurada 30 días, queso cheddar, bacon, cebolla crujiente, pepinillo y Salsa Oculto',14.5,_binary '','comida','https://dondecomemosahora.com/wp-content/uploads/2026/02/IMG_2935.jpg'),(10,'Emily','Doble patty, doble queso cheddar, bacon crujiente y Salsa Emmy',10.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/8e9aff3e457cf17553c8d8b6070036c4/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(11,'Eggy','Doble patty, queso cheddar, bacon crujiente, huevo frito y Salsa Mayo-Bacon',11.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/34e1b3b8994dc60b9c35bfca7d7bd2bd/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(12,'Chicken','Pollo crujiente, queso cheddar, pepinillo, cebolla y salsa BBQ',10.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/a1ce3270c772a66368c72d740622ee03/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(13,'Vegan','Heura burger, lechuga, tomate, cebolla morada y Salsa Oculto',10.5,_binary '','comida','https://th.bing.com/th/id/OIP.mbS28S5dry3hVMWIfDwwjwHaE7?r=0&o=7rm=3&rs=1&pid=ImgDetMain&o=7&rm=3'),(14,'Patatas Premium','Bacon BBQ Fries, Truffle Fries o Bacon Cheese Fries',4.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/ddfb9e98e8922a5f0333058b1da4e21c/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(15,'Boniatos','Sweet Potatoes',3.1,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/985db78ff6d2581097e69ed5b3859f94/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(16,'Fingers de Pollo','Tiras de pollo crujientes acompañadas de salsa Oculto',7.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/1cf8d3c92e5ec9625ac13d8a5af68703/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(17,'Alitas BBQ','Alitas marinadas en BBQ, bañadas en más salsa BBQ, bacon bits y cebollino',8.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/4edc6228b25125a619236007fe75c767/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(18,'Tequeños de Queso','Palitos de masa de trigo rellenos de queso y acompañados de salsa Oculto',7.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/11971985a7e3b17d92b437949d481636/bc9c318a9c96996e2d990faf2b0c65f6.jpeg'),(19,'Nuggets de cheddar y jalapeño','Nuggets rellenos de cheddar líquido con un toque picante',7.5,_binary '','comida','https://tb-static.uber.com/prod/image-proc/processed_images/50e950fb43756a66062532a7d68a6aca/c67fc65e9b4e16a553eb7574fba090f1.jpeg'),(20,'Tarta de queso clasica','Tarta de queso horneada sabor tradicional',7,_binary '','postre','/images/products/tarta-queso-clasica.jpg'),(21,'Tarta dubái gold','Tarta de queso con pistacho y chocolate',7,_binary '','postre','/images/products/tarta-dubai.jpg'),(22,'Oreo Shake','Batido de leche, helado de vainilla y galletas Oreo',5.5,_binary '','bebida','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7cE_3eASCzC5VTh0VxYDRY3KViWS6Iy20Zg&s'),(23,'Shake de temporada','Sabores disponibles por temporada limitada',5.5,_binary '','bebida','/images/products/shake-temporada.jpg'),(24,'Cerveza','Cerveza',1.5,_binary '','bebida','https://grifoencasa.mahou.es/cdn/shop/files/vasodoblecana0_33cls.jpg?v=1742211956'),(25,'Tercios','Cerveza en tercio',2.5,_binary '','bebida','https://tucervezaadomicilio.com/wp-content/uploads/2020/07/estrella-galicia-quinto.jpg'),(26,'Refrescos 500ml','Refrescos variados',2.5,_binary '','bebida','https://deor.es/10047-large_default/cocacola-lata-33cl-24-uds.jpg'),(27,'Agua','Agua embotellada',2,_binary '','bebida','https://pizzeriadolomiti.es/wp-content/uploads/2016/09/45.jpg'),(28,'Energética','Bebida energética',2.2,_binary '','bebida','https://m.media-amazon.com/images/I/61ZmXXdgEdL.jpg'),(29,'Salsa extra','Salsa adicional para tu pedido',1.5,_binary '','salsa','https://www.monouso.es/cdn-cgi/image/width=610,quality=80/54718-large_default/tarrina-inox-para-salsas-75ml-12-uds.jpg'),(30,'Coca Cola','Bebida refrescante con gas',2.5,_binary '','bebida','https://deor.es/10047-large_default/cocacola-lata-33cl-24-uds.jpg'),(31,'Tarta de Chocolate','Postre de chocolate',4.5,_binary '','postre','/images/products/tarta-chocolate.jpg'),(32,'Helado de Vainilla','Helado cremoso',3,_binary '','postre','/images/products/helado-vainilla.jpg'),(33,'Ketchup','Salsa de tomate',0.5,_binary '','salsa','/images/products/ketchup.jpg'),(34,'Mayonesa','Salsa cremosa',0.5,_binary '','salsa','/images/products/mayonesa.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `ingredient_id` bigint(20) NOT NULL,
  `quantity` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_product_ingredient` (`product_id`,`ingredient_id`),
  UNIQUE KEY `UKi2r54dij70nvt39uy2ctom93g` (`product_id`,`ingredient_id`),
  KEY `fk_recipe_ingredient` (`ingredient_id`),
  CONSTRAINT `fk_recipe_ingredient` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_recipe_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,1,1,1),(2,1,2,0.15),(6,1,3,1),(7,1,4,0.02),(8,1,5,0.03),(9,2,6,0.25),(10,2,7,0.05),(11,2,47,2),(12,2,48,2),(13,2,50,200),(14,3,11,1),(15,3,14,50),(16,3,17,30),(17,3,23,100),(18,3,35,20),(19,3,44,20),(20,4,11,1),(21,4,17,30),(22,4,23,100),(23,4,33,15),(24,4,36,30),(25,4,40,20),(26,5,11,1),(27,5,17,30),(28,5,23,100),(29,5,35,20),(30,6,11,1),(31,6,15,60),(32,6,18,30),(33,6,24,50),(34,6,25,10),(35,6,42,30),(36,7,11,1),(37,7,17,30),(38,7,23,100),(39,7,39,20),(40,7,43,1),(41,8,11,1),(42,8,17,30),(43,8,23,100),(44,8,4,30),(45,8,5,40),(46,8,30,20),(47,8,35,20),(48,9,9,200),(49,9,16,30),(50,9,22,50),(51,9,31,20),(52,9,32,15),(53,9,35,20),(54,10,11,1),(55,10,17,30),(56,10,23,100),(57,10,37,20),(58,11,11,1),(59,11,17,30),(60,11,22,50),(61,11,38,20),(62,11,43,1),(63,12,12,150),(64,12,22,40),(65,12,29,20),(66,12,32,20),(67,12,36,20),(68,13,4,30),(69,13,5,40),(70,13,13,1),(71,13,30,20),(72,13,35,20),(73,14,50,200),(74,14,52,30),(75,15,51,200),(76,16,19,150),(77,16,35,30),(78,17,20,200),(79,17,36,50),(80,17,49,5),(81,17,52,20),(82,18,35,30),(83,18,53,150),(84,19,21,150),(85,19,26,50),(86,19,34,10),(87,19,35,30),(88,20,53,200),(89,20,58,50),(90,20,63,30),(91,21,53,200),(92,21,54,30),(93,21,55,20),(94,21,58,50),(95,21,63,10),(96,22,56,50),(97,22,57,100),(98,22,58,200),(99,31,55,0.2),(100,31,58,0.3),(101,31,63,0.1),(102,32,57,0.5),(103,32,63,0.08);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_lines`
--

DROP TABLE IF EXISTS `sale_lines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_lines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sale_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sale_lines_sale` (`sale_id`),
  KEY `fk_sale_lines_product` (`product_id`),
  CONSTRAINT `fk_sale_lines_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_sale_lines_sale` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_lines`
--

LOCK TABLES `sale_lines` WRITE;
/*!40000 ALTER TABLE `sale_lines` DISABLE KEYS */;
INSERT INTO `sale_lines` VALUES (1,1,3,1,12.5),(2,2,3,1,12.5),(3,3,1,1,8.5);
/*!40000 ALTER TABLE `sale_lines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `status` enum('OPEN','PAID','CLOSED','CANCELLED') NOT NULL,
  `created_at` datetime(6) DEFAULT current_timestamp(6),
  `stripe_session_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sales_user` (`user_id`),
  CONSTRAINT `fk_sales_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,3,12.5,'OPEN','2026-05-09 11:52:27.254028','cs_test_a1QQ2SNk2OH9G70qaHBQ7HB0WMOTr7hpT1EAti8BwYLySCJe77uYWrticS'),(2,3,12.5,'PAID','2026-05-09 15:26:09.613919',NULL),(3,3,8.5,'PAID','2026-05-09 20:37:58.724265',NULL);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_ingredient`
--

DROP TABLE IF EXISTS `stock_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_ingredient` (
  `ingredient_id` bigint(20) NOT NULL,
  `current_stock` double DEFAULT NULL,
  `min_stock` double DEFAULT NULL,
  `max_stock` double DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`ingredient_id`),
  CONSTRAINT `fk_stock_ingredient` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_ingredient`
--

LOCK TABLES `stock_ingredient` WRITE;
/*!40000 ALTER TABLE `stock_ingredient` DISABLE KEYS */;
INSERT INTO `stock_ingredient` VALUES (1,5,5,50,'2026-05-11'),(2,19.85,2,20,'2026-05-09'),(3,29,3,30,'2026-05-14'),(4,9.98,1,10,'2026-05-08'),(5,9.97,1,10,'2026-05-08'),(6,15,2,15,'2026-05-14'),(7,5,1,5,'2026-06-03'),(8,5000,100,1000,'2025-03-15'),(9,1000,100,1000,'2025-03-20'),(10,500,100,1000,'2025-03-10'),(11,299,100,1000,'2025-03-10'),(12,2000,100,1000,'2025-03-12'),(13,200,100,1000,'2025-04-01'),(14,1450,100,1000,'2025-03-08'),(15,1000,100,1000,'2025-03-08'),(16,3000,100,1000,'2025-03-20'),(17,1970,100,1000,'2025-03-15'),(18,800,100,1000,'2025-03-18'),(19,500,50,1000,'2026-12-31'),(20,500,50,1000,'2026-12-31'),(21,500,50,1000,'2026-12-31'),(22,1500,100,1000,'2025-03-28'),(23,900,100,1000,'2025-03-28'),(24,1000,100,1000,'2026-12-31'),(25,1000,100,1000,'2026-12-31'),(26,1000,100,1000,'2026-12-31'),(27,500,100,1000,'2025-03-25'),(29,1000,100,1000,'2025-03-10'),(30,1000,100,1000,'2026-12-31'),(31,1000,100,1000,'2026-12-31'),(32,800,100,1000,'2025-03-15'),(33,1000,100,1000,'2026-12-31'),(34,1000,100,1000,'2026-12-31'),(35,4980,100,1000,'2025-06-30'),(36,3000,100,1000,'2025-05-30'),(37,1000,100,1000,'2026-12-31'),(38,1000,100,1000,'2026-12-31'),(39,1000,100,1000,'2026-12-31'),(40,1000,100,1000,'2026-12-31'),(42,1000,100,1000,'2026-12-31'),(43,300,100,1000,'2025-03-12'),(44,980,100,1000,'2026-12-31'),(47,1000,100,1000,'2026-12-31'),(48,1000,100,1000,'2026-12-31'),(49,1000,100,1000,'2026-12-31'),(50,5000,100,1000,'2025-04-30'),(51,2000,100,1000,'2025-04-30'),(52,1000,100,1000,'2025-04-30'),(53,500,100,1000,'2025-03-20'),(54,1000,100,1000,'2026-12-31'),(55,8,1,20,'2026-08-02'),(56,1000,100,1000,'2026-12-31'),(57,1000,100,1000,'2026-12-31'),(58,10,2,25,'2026-05-10'),(59,10000,100,1000,'2025-12-31'),(60,2000,200,5000,'2026-12-31'),(61,50,10,200,'2026-06-03'),(62,2000,200,5000,'2026-12-31'),(63,12,2,30,'2027-05-04');
/*!40000 ALTER TABLE `stock_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_movement`
--

DROP TABLE IF EXISTS `stock_movement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_movement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `sale_id` bigint(20) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `type` enum('RESTOCK','SALE','ADJUSTMENT') DEFAULT NULL,
  `created_at` datetime(6) DEFAULT current_timestamp(6),
  PRIMARY KEY (`id`),
  KEY `fk_stock_movement_ingredient` (`ingredient_id`),
  KEY `fk_stock_movement_sale` (`sale_id`),
  CONSTRAINT `fk_stock_movement_ingredient` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_stock_movement_sale` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_movement`
--

LOCK TABLES `stock_movement` WRITE;
/*!40000 ALTER TABLE `stock_movement` DISABLE KEYS */;
INSERT INTO `stock_movement` VALUES (1,1,NULL,1,'RESTOCK','2026-05-08 17:17:18.050541'),(2,1,NULL,2,'RESTOCK','2026-05-08 17:17:18.177584'),(3,1,NULL,3,'RESTOCK','2026-05-08 17:17:18.749352'),(4,1,NULL,4,'RESTOCK','2026-05-08 17:17:18.919191'),(5,11,2,-1,'SALE','2026-05-09 15:26:26.849283'),(6,14,2,-50,'SALE','2026-05-09 15:26:27.705028'),(7,17,2,-30,'SALE','2026-05-09 15:26:28.409541'),(8,23,2,-100,'SALE','2026-05-09 15:26:29.114968'),(9,35,2,-20,'SALE','2026-05-09 15:26:29.817455'),(10,44,2,-20,'SALE','2026-05-09 15:26:30.533307'),(11,1,3,-1,'SALE','2026-05-09 20:38:02.026787'),(12,2,3,-0.15,'SALE','2026-05-09 20:38:03.392867'),(13,3,3,-1,'SALE','2026-05-09 20:38:03.933878'),(14,4,3,-0.02,'SALE','2026-05-09 20:38:04.464405'),(15,5,3,-0.03,'SALE','2026-05-09 20:38:05.021385');
/*!40000 ALTER TABLE `stock_movement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','CAMARERO','GERENTE') NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `register_at` datetime(6) DEFAULT current_timestamp(6),
  `profile_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$I4/tOWcdGDUm4JI2d0tPX.4d0QjxM.XB0c.7TnJZaB1w4seHM8bZq','ADMIN',_binary '','2026-05-07 19:46:56.254358',NULL),(2,'yeray','$2a$10$B2o4UnCMS8MXv72nZOJWee5YYM8S5OtRFoU/su2OeNNbl3lCMyl3u','CAMARERO',_binary '','2026-05-07 19:46:56.416286',NULL),(3,'gerente','$2a$10$LbgSu1VRlHLRLrMxQLf9j.J.T96gyanjnKR3AVnrF0W081/aXQmxm','GERENTE',_binary '','2026-05-07 19:46:56.544679',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-09 21:23:09
