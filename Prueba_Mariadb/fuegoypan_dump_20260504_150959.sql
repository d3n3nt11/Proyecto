-- ============================================
-- DUMP DE BASE DE DATOS: FuegoyPan
-- Fecha: 04/05/2026 15:10:00
-- Host: serverless-europe-west3.sysp0000.db2.skysql.com
-- ============================================

SET FOREIGN_KEY_CHECKS=0;
SET NAMES utf8mb4;

-- --------------------------------------------
-- TABLA: users
-- --------------------------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profile_photo` varchar(255) DEFAULT NULL,
  `register_at` datetime(6) DEFAULT NULL,
  `role` enum('ADMIN','CAMARERO','GERENTE') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3g1j96g94xpk3lpxl2qbl985x` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `users` (`id`, `enabled`, `name`, `password`, `profile_photo`, `register_at`, `role`) VALUES (1, true, 'yeray', '$2a$10$B2o4UnCMS8MXv72nZOJWee5YYM8S5OtRFoU/su2OeNNbl3lCMyl3u', NULL, '2026-05-04 12:04:13.721218', 'CAMARERO');
INSERT INTO `users` (`id`, `enabled`, `name`, `password`, `profile_photo`, `register_at`, `role`) VALUES (2, true, 'admin', '$2a$10$I4/tOWcdGDUm4JI2d0tPX.4d0QjxM.XB0c.7TnJZaB1w4seHM8bZq', NULL, '2026-05-04 12:04:14.108529', 'ADMIN');
INSERT INTO `users` (`id`, `enabled`, `name`, `password`, `profile_photo`, `register_at`, `role`) VALUES (3, true, 'gerente', '$2a$10$LbgSu1VRlHLRLrMxQLf9j.J.T96gyanjnKR3AVnrF0W081/aXQmxm', NULL, '2026-05-04 12:04:14.368689', 'GERENTE');

-- --------------------------------------------
-- TABLA: ingredients
-- --------------------------------------------
DROP TABLE IF EXISTS `ingredients`;
CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (1, 'Pan', 'unidades');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (2, 'Carne', 'kg');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (3, 'Queso', 'rebanadas');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (4, 'Lechuga', 'kg');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (5, 'Tomate', 'kg');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (6, 'Patata', 'kg');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (7, 'Aceite', 'litros');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (8, 'Carne de vaca', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (9, 'Carne de vaca madurada 30 días', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (10, 'Patty de carne', 'und');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (11, 'Doble patty', 'und');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (12, 'Pollo crujiente', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (13, 'Heura burger (vegana)', 'und');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (14, 'Pulled pork BBQ', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (15, 'Carrillada asada', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (16, 'Bacon', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (17, 'Bacon crujiente', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (18, 'Taquitos de jamón', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (19, 'Fingers de pollo', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (20, 'Alitas de pollo', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (21, 'Nuggets de pollo', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (22, 'Queso cheddar', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (23, 'Doble queso cheddar', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (24, 'Queso edam', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (25, 'Polvo de queso', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (26, 'Cheddar líquido', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (27, 'Pan de burger', 'und');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (28, 'Pan brioche', 'und');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (29, 'Cebolla', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (30, 'Cebolla morada', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (31, 'Cebolla crujiente', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (32, 'Pepinillo', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (33, 'Pepinillo picado', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (34, 'Jalapeño', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (35, 'Salsa Oculto', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (36, 'Salsa BBQ', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (37, 'Salsa Emmy', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (38, 'Salsa Mayo-Bacon', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (39, 'Mayo Trufada', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (40, 'Alioli', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (41, 'Salsa Ranchera', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (42, 'Mermelada de bacon', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (43, 'Huevo frito', 'und');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (44, 'Bits de chicharrones fritos', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (45, 'Setas', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (46, 'Trufa', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (47, 'Pimentón de la Vera', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (48, 'Sal', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (49, 'Cebollino', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (50, 'Patatas fritas', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (51, 'Boniatos', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (52, 'Bacon Bits', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (53, 'Queso para tarta', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (54, 'Pistacho', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (55, 'Chocolate', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (56, 'Galletas Oreo', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (57, 'Helado de vainilla', 'gr');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (58, 'Leche', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (59, 'Cerveza', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (60, 'Refresco', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (61, 'Agua', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (62, 'Bebida energética', 'ml');
INSERT INTO `ingredients` (`id`, `name`, `unit`) VALUES (63, 'Azúcar', 'kg');

-- --------------------------------------------
-- TABLA: products
-- --------------------------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `visible` bit(1) DEFAULT NULL,
  `category` enum('bebida','comida','postre','salsa') DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (1, 'Hamburguesa con queso, lechuga y tomate', 'Cheese Burger', 8.5, true, NULL, NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (2, 'Patatas fritas crujientes', 'Patatas Fritas', 3.5, true, NULL, NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (3, 'Doble patty, doble queso cheddar, bacon crujiente, pulled pork BBQ, bits de chicharrones fritos y Salsa Oculto', 'La Faraona', 12.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (4, 'Doble patty, doble queso cheddar, bacon crujiente, salsa BBQ, alioli y pepinillo picado', 'BBQ Cheeseburger', 11.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (5, 'Doble patty, doble queso cheddar, bacon crujiente y Salsa Oculto', 'Alan Garner', 10.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (6, 'Doble patty, queso edam, mermelada bacon, carrillada asada, taquitos de jamon y polvo de queso', 'Pedroxes', 12.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (7, 'Doble patty, doble queso cheddar, bacon crujiente, huevo frito y mayo Trufada', 'TruFake', 12.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (8, 'Doble patty, doble queso cheddar, bacon crujiente, lechuga, tomate, cebolla morada y salsa Oculto', 'Harvey', 11.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (9, 'Carne vaca madurada 30 días, queso cheddar, bacon, cebolla crujiente, pepinillo y Salsa Oculto', 'Madurada', 14.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (10, 'Doble patty, doble queso cheddar, bacon crujiente y Salsa Emmy', 'Emily', 10.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (11, 'Doble patty, queso cheddar, bacon crujiente, huevo frito y Salsa Mayo-Bacon', 'Eggy', 11.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (12, 'Pollo crujiente, queso cheddar, pepinillo, cebolla y salsa BBQ', 'Chicken', 10.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (13, 'Heura burger, lechuga, tomate, cebolla morada y Salsa Oculto', 'Vegan', 10.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (14, 'Bacon BBQ Fries, Truffle Fries o Bacon Cheese Fries', 'Patatas Premium', 4.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (15, 'Sweet Potatoes', 'Boniatos', 3.1, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (16, 'Tiras de pollo crujientes acompañadas de salsa Oculto', 'Fingers de Pollo', 7.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (17, 'Alitas marinadas en BBQ, bañadas en más salsa BBQ, bacon bits y cebollino', 'Alitas BBQ', 8.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (18, 'Palitos de masa de trigo rellenos de queso y acompañados de salsa Oculto', 'Tequeños de Queso', 7.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (19, 'Nuggets rellenos de cheddar líquido con un toque picante', 'Nuggets de cheddar y jalapeño', 7.5, true, 'comida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (20, 'Tarta de queso horneada sabor tradicional', 'Tarta de queso clasica', 7.0, true, 'postre', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (21, 'Tarta de queso con pistacho y chocolate', 'Tarta dubái gold', 7.0, true, 'postre', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (22, 'Batido de leche, helado de vainilla y galletas Oreo', 'Oreo Shake', 5.5, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (23, 'Sabores disponibles por temporada limitada', 'Shake de temporada', 5.5, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (24, 'Cerveza', 'Cerveza', 1.5, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (25, 'Cerveza en tercio', 'Tercios', 2.5, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (26, 'Refrescos variados', 'Refrescos 500ml', 2.5, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (27, 'Agua embotellada', 'Agua', 2.0, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (28, 'Bebida energética', 'Energética', 2.2, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (29, 'Salsa adicional para tu pedido', 'Salsa extra', 1.5, true, 'salsa', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (30, 'Bebida refrescante con gas', 'Coca Cola', 2.5, true, 'bebida', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (31, 'Postre de chocolate', 'Tarta de Chocolate', 4.5, true, 'postre', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (32, 'Helado cremoso', 'Helado de Vainilla', 3.0, true, 'postre', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (33, 'Salsa de tomate', 'Ketchup', 0.5, true, 'salsa', NULL);
INSERT INTO `products` (`id`, `description`, `name`, `price`, `visible`, `category`, `image_url`) VALUES (34, 'Salsa cremosa', 'Mayonesa', 0.5, true, 'salsa', NULL);

-- --------------------------------------------
-- TABLA: stock_ingredient
-- --------------------------------------------
DROP TABLE IF EXISTS `stock_ingredient`;
CREATE TABLE `stock_ingredient` (
  `ingredient_id` bigint(20) NOT NULL,
  `current_stock` double DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `max_stock` double DEFAULT NULL,
  `min_stock` double DEFAULT NULL,
  PRIMARY KEY (`ingredient_id`),
  CONSTRAINT `FK9ij65f4en47wvl4hrot9v0wha` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (1, NULL, 2026-05-11, 50.0, 5.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (2, NULL, 2026-05-09, 20.0, 2.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (3, NULL, 2026-05-14, 30.0, 3.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (4, NULL, 2026-05-08, 10.0, 1.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (5, NULL, 2026-05-08, 10.0, 1.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (6, NULL, 2026-05-14, 15.0, 2.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (7, NULL, 2026-06-03, 5.0, 1.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (8, 5000.0, 2025-03-15, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (9, 1000.0, 2025-03-20, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (10, 500.0, 2025-03-10, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (11, 300.0, 2025-03-10, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (12, 2000.0, 2025-03-12, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (13, 200.0, 2025-04-01, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (14, 1500.0, 2025-03-08, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (15, 1000.0, 2025-03-08, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (16, 3000.0, 2025-03-20, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (17, 2000.0, 2025-03-15, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (18, 800.0, 2025-03-18, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (22, 1500.0, 2025-03-28, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (23, 1000.0, 2025-03-28, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (27, 500.0, 2025-03-25, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (29, 1000.0, 2025-03-10, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (32, 800.0, 2025-03-15, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (35, 5000.0, 2025-06-30, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (36, 3000.0, 2025-05-30, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (43, 300.0, 2025-03-12, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (50, 5000.0, 2025-04-30, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (51, 2000.0, 2025-04-30, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (52, 1000.0, 2025-04-30, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (53, 500.0, 2025-03-20, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (55, 8.0, 2026-08-02, 20.0, 1.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (58, 10.0, 2026-05-10, 25.0, 2.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (59, 10000.0, 2025-12-31, 1000.0, 100.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (61, 50.0, 2026-06-03, 200.0, 10.0);
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `expiration_date`, `max_stock`, `min_stock`) VALUES (63, 12.0, 2027-05-04, 30.0, 2.0);

-- --------------------------------------------
-- TABLA: recipe
-- --------------------------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` double NOT NULL,
  `ingredient_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKi2r54dij70nvt39uy2ctom93g` (`product_id`,`ingredient_id`),
  UNIQUE KEY `unique_product_ingredient` (`product_id`,`ingredient_id`),
  CONSTRAINT `FK2994ux6cd5ggw9j6todmlm09a` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FK3ggem7ag1va8nr3d2ipoegb3i` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (1, 1.0, 1, 1);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (2, 0.15, 2, 1);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (3, 1.0, 3, 1);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (4, 0.02, 4, 1);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (5, 0.03, 5, 1);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (6, 0.25, 6, 2);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (7, 0.05, 7, 2);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (8, 1.0, 47, 2);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (9, 2.0, 48, 2);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (10, 200.0, 50, 2);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (11, 1.0, 11, 3);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (12, 50.0, 14, 3);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (13, 30.0, 17, 3);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (14, 100.0, 23, 3);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (15, 20.0, 35, 3);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (16, 20.0, 44, 3);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (17, 1.0, 11, 4);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (18, 30.0, 17, 4);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (19, 100.0, 23, 4);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (20, 15.0, 33, 4);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (21, 30.0, 36, 4);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (22, 20.0, 40, 4);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (23, 1.0, 11, 5);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (24, 30.0, 17, 5);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (25, 100.0, 23, 5);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (26, 20.0, 35, 5);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (27, 1.0, 11, 6);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (28, 60.0, 15, 6);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (29, 30.0, 18, 6);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (30, 50.0, 24, 6);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (31, 10.0, 25, 6);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (32, 30.0, 42, 6);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (33, 1.0, 11, 7);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (34, 30.0, 17, 7);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (35, 100.0, 23, 7);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (36, 20.0, 39, 7);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (37, 1.0, 43, 7);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (38, 30.0, 4, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (39, 40.0, 5, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (40, 1.0, 11, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (41, 30.0, 17, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (42, 100.0, 23, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (43, 20.0, 30, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (44, 20.0, 35, 8);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (45, 200.0, 9, 9);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (46, 30.0, 16, 9);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (47, 50.0, 22, 9);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (48, 20.0, 31, 9);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (49, 15.0, 32, 9);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (50, 20.0, 35, 9);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (51, 1.0, 11, 10);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (52, 30.0, 17, 10);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (53, 100.0, 23, 10);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (54, 20.0, 37, 10);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (55, 1.0, 11, 11);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (56, 30.0, 17, 11);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (57, 50.0, 22, 11);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (58, 20.0, 38, 11);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (59, 1.0, 43, 11);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (60, 150.0, 12, 12);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (61, 40.0, 22, 12);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (62, 20.0, 29, 12);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (63, 20.0, 32, 12);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (64, 20.0, 36, 12);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (65, 30.0, 4, 13);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (66, 40.0, 5, 13);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (67, 1.0, 13, 13);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (68, 20.0, 30, 13);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (69, 20.0, 35, 13);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (70, 200.0, 50, 14);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (71, 30.0, 52, 14);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (72, 200.0, 51, 15);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (73, 150.0, 19, 16);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (74, 30.0, 35, 16);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (75, 200.0, 20, 17);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (76, 50.0, 36, 17);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (77, 5.0, 49, 17);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (78, 20.0, 52, 17);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (79, 30.0, 35, 18);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (80, 150.0, 53, 18);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (81, 150.0, 21, 19);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (82, 50.0, 26, 19);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (83, 10.0, 34, 19);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (84, 30.0, 35, 19);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (85, 50.0, 56, 22);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (86, 100.0, 57, 22);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (87, 200.0, 58, 22);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (88, 0.2, 55, 31);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (89, 0.3, 58, 31);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (90, 0.1, 63, 31);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (91, 0.5, 58, 32);
INSERT INTO `recipe` (`id`, `quantity`, `ingredient_id`, `product_id`) VALUES (92, 0.08, 63, 32);

-- --------------------------------------------
-- TABLA: sales
-- --------------------------------------------
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `status` enum('CANCELLED','CLOSED','OPEN','PAID') NOT NULL,
  `total` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5bgaw8g0rrbqdvafq36g58smk` (`user_id`),
  CONSTRAINT `FK5bgaw8g0rrbqdvafq36g58smk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------
-- TABLA: sale_lines
-- --------------------------------------------
DROP TABLE IF EXISTS `sale_lines`;
CREATE TABLE `sale_lines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `sale_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrv7cdt02ykk0w12tw35fr3w71` (`product_id`),
  KEY `FKkpwprnqql44yb12xdig9909u5` (`sale_id`),
  CONSTRAINT `FKkpwprnqql44yb12xdig9909u5` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`),
  CONSTRAINT `FKrv7cdt02ykk0w12tw35fr3w71` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------
-- TABLA: stock_movement
-- --------------------------------------------
DROP TABLE IF EXISTS `stock_movement`;
CREATE TABLE `stock_movement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `type` enum('ADJUSTMENT','RESTOCK','SALE') DEFAULT NULL,
  `ingredient_id` bigint(20) NOT NULL,
  `sale_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdlw12jcivxwrkj4qd8h8yke04` (`ingredient_id`),
  KEY `FKdv3h4ys74s183lc25guoj3qlu` (`sale_id`),
  CONSTRAINT `FKdlw12jcivxwrkj4qd8h8yke04` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`),
  CONSTRAINT `FKdv3h4ys74s183lc25guoj3qlu` FOREIGN KEY (`sale_id`) REFERENCES `sales` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



SET FOREIGN_KEY_CHECKS=1;

-- ============================================
-- FIN DEL DUMP
-- ============================================
