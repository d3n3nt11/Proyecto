-- Backup generado automáticamente
-- Base de datos: fuegoypan
SET FOREIGN_KEY_CHECKS = 0;

-- Estructura: ingredients
DROP TABLE IF EXISTS `ingredients`;
CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (1, 'Pan', 'unidades', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (2, 'Carne', 'kg', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (3, 'Queso', 'rebanadas', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (4, 'Lechuga', 'kg', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (5, 'Tomate', 'kg', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (6, 'Patata', 'kg', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (7, 'Aceite', 'litros', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (8, 'Carne de vaca', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (9, 'Carne de vaca madurada 30 días', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (10, 'Patty de carne', 'und', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (11, 'Doble patty', 'und', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (12, 'Pollo crujiente', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (13, 'Heura burger (vegana)', 'und', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (14, 'Pulled pork BBQ', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (15, 'Carrillada asada', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (16, 'Bacon', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (17, 'Bacon crujiente', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (18, 'Taquitos de jamón', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (19, 'Fingers de pollo', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (20, 'Alitas de pollo', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (21, 'Nuggets de pollo', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (22, 'Queso cheddar', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (23, 'Doble queso cheddar', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (24, 'Queso edam', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (25, 'Polvo de queso', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (26, 'Cheddar líquido', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (27, 'Pan de burger', 'und', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (28, 'Pan brioche', 'und', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (29, 'Cebolla', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (30, 'Cebolla morada', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (31, 'Cebolla crujiente', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (32, 'Pepinillo', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (33, 'Pepinillo picado', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (34, 'Jalapeño', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (35, 'Salsa Oculto', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (36, 'Salsa BBQ', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (37, 'Salsa Emmy', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (38, 'Salsa Mayo-Bacon', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (39, 'Mayo Trufada', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (40, 'Alioli', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (41, 'Salsa Ranchera', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (42, 'Mermelada de bacon', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (43, 'Huevo frito', 'und', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (44, 'Bits de chicharrones fritos', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (45, 'Setas', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (46, 'Trufa', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (47, 'Pimentón de la Vera', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (48, 'Sal', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (49, 'Cebollino', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (50, 'Patatas fritas', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (51, 'Boniatos', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (52, 'Bacon Bits', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (53, 'Queso para tarta', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (54, 'Pistacho', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (55, 'Chocolate', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (56, 'Galletas Oreo', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (57, 'Helado de vainilla', 'gr', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (58, 'Leche', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (59, 'Cerveza', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (60, 'Refresco', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (61, 'Agua', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (62, 'Bebida energética', 'ml', NULL);
INSERT INTO `ingredients` (`id`, `name`, `unit`, `image`) VALUES (63, 'Azúcar', 'kg', NULL);

-- Estructura: products
DROP TABLE IF EXISTS `products`;
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

INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (1, 'Cheese Burger', 'Hamburguesa con queso, lechuga y tomate', 8.5, true, 'comida', '/images/products/cheese-burger.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (2, 'Patatas Fritas', 'Patatas fritas crujientes', 3.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/985db78ff6d2581097e69ed5b3859f94/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (3, 'La Faraona', 'Doble patty, doble queso cheddar, bacon crujiente...', 12.5, true, 'comida', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPfMfSIsi9H4x0wbz92QB0ZAPSdPzSdt4r5w&s');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (4, 'BBQ Cheeseburger', 'Doble patty, doble queso cheddar, bacon crujiente, salsa BBQ, alioli y pepinillo picado', 11.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/9a71a30dbfee81af31fc6718b7acccfc/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (5, 'Alan Garner', 'Doble patty, doble queso cheddar, bacon crujiente y Salsa Oculto', 10.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/f5835a7fb660d0f7ed0726944f8ee5fb/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (6, 'Pedroxes', 'Doble patty, queso edam, mermelada bacon, carrillada asada, taquitos de jamon y polvo de queso', 12.5, true, 'comida', 'https://lamejorhamburguesa.com/html5Upload/server/php/files/medium/pedroxessala1.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (7, 'TruFake', 'Doble patty, doble queso cheddar, bacon crujiente, huevo frito y mayo Trufada', 12.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/1f452b1580dec852447dcd72cc09b8f2/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (8, 'Harvey', 'Doble patty, doble queso cheddar, bacon crujiente, lechuga, tomate, cebolla morada y salsa Oculto', 11.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/98624fea4725932d43356ac8df86c85a/7f4ae9ca0446cbc23e71d8d395a98428.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (9, 'Madurada', 'Carne vaca madurada 30 días, queso cheddar, bacon, cebolla crujiente, pepinillo y Salsa Oculto', 14.5, true, 'comida', 'https://dondecomemosahora.com/wp-content/uploads/2026/02/IMG_2935.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (10, 'Emily', 'Doble patty, doble queso cheddar, bacon crujiente y Salsa Emmy', 10.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/8e9aff3e457cf17553c8d8b6070036c4/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (11, 'Eggy', 'Doble patty, queso cheddar, bacon crujiente, huevo frito y Salsa Mayo-Bacon', 11.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/34e1b3b8994dc60b9c35bfca7d7bd2bd/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (12, 'Chicken', 'Pollo crujiente, queso cheddar, pepinillo, cebolla y salsa BBQ', 10.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/a1ce3270c772a66368c72d740622ee03/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (13, 'Vegan', 'Heura burger, lechuga, tomate, cebolla morada y Salsa Oculto', 10.5, true, 'comida', 'https://th.bing.com/th/id/OIP.mbS28S5dry3hVMWIfDwwjwHaE7?r=0&o=7rm=3&rs=1&pid=ImgDetMain&o=7&rm=3');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (14, 'Patatas Premium', 'Bacon BBQ Fries, Truffle Fries o Bacon Cheese Fries', 4.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/ddfb9e98e8922a5f0333058b1da4e21c/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (15, 'Boniatos', 'Sweet Potatoes', 3.1, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/985db78ff6d2581097e69ed5b3859f94/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (16, 'Fingers de Pollo', 'Tiras de pollo crujientes acompañadas de salsa Oculto', 7.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/1cf8d3c92e5ec9625ac13d8a5af68703/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (17, 'Alitas BBQ', 'Alitas marinadas en BBQ, bañadas en más salsa BBQ, bacon bits y cebollino', 8.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/4edc6228b25125a619236007fe75c767/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (18, 'Tequeños de Queso', 'Palitos de masa de trigo rellenos de queso y acompañados de salsa Oculto', 7.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/11971985a7e3b17d92b437949d481636/bc9c318a9c96996e2d990faf2b0c65f6.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (19, 'Nuggets de cheddar y jalapeño', 'Nuggets rellenos de cheddar líquido con un toque picante', 7.5, true, 'comida', 'https://tb-static.uber.com/prod/image-proc/processed_images/50e950fb43756a66062532a7d68a6aca/c67fc65e9b4e16a553eb7574fba090f1.jpeg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (20, 'Tarta de queso clasica', 'Tarta de queso horneada sabor tradicional', 7.0, true, 'postre', '/images/products/tarta-queso-clasica.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (21, 'Tarta dubái gold', 'Tarta de queso con pistacho y chocolate', 7.0, true, 'postre', '/images/products/tarta-dubai.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (22, 'Oreo Shake', 'Batido de leche, helado de vainilla y galletas Oreo', 5.5, true, 'bebida', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7cE_3eASCzC5VTh0VxYDRY3KViWS6Iy20Zg&s');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (23, 'Shake de temporada', 'Sabores disponibles por temporada limitada', 5.5, true, 'bebida', '/images/products/shake-temporada.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (24, 'Cerveza', 'Cerveza', 1.5, true, 'bebida', 'https://grifoencasa.mahou.es/cdn/shop/files/vasodoblecana0_33cls.jpg?v=1742211956');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (25, 'Tercios', 'Cerveza en tercio', 2.5, true, 'bebida', 'https://tucervezaadomicilio.com/wp-content/uploads/2020/07/estrella-galicia-quinto.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (26, 'Refrescos 500ml', 'Refrescos variados', 2.5, true, 'bebida', 'https://deor.es/10047-large_default/cocacola-lata-33cl-24-uds.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (27, 'Agua', 'Agua embotellada', 2.0, true, 'bebida', 'https://pizzeriadolomiti.es/wp-content/uploads/2016/09/45.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (28, 'Energética', 'Bebida energética', 2.2, true, 'bebida', 'https://m.media-amazon.com/images/I/61ZmXXdgEdL.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (29, 'Salsa extra', 'Salsa adicional para tu pedido', 1.5, true, 'salsa', 'https://www.monouso.es/cdn-cgi/image/width=610,quality=80/54718-large_default/tarrina-inox-para-salsas-75ml-12-uds.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (30, 'Coca Cola', 'Bebida refrescante con gas', 2.5, true, 'bebida', 'https://deor.es/10047-large_default/cocacola-lata-33cl-24-uds.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (31, 'Tarta de Chocolate', 'Postre de chocolate', 4.5, true, 'postre', '/images/products/tarta-chocolate.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (32, 'Helado de Vainilla', 'Helado cremoso', 3.0, true, 'postre', '/images/products/helado-vainilla.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (33, 'Ketchup', 'Salsa de tomate', 0.5, true, 'salsa', '/images/products/ketchup.jpg');
INSERT INTO `products` (`id`, `name`, `description`, `price`, `visible`, `category`, `image_url`) VALUES (34, 'Mayonesa', 'Salsa cremosa', 0.5, true, 'salsa', '/images/products/mayonesa.jpg');

-- Estructura: recipe
DROP TABLE IF EXISTS `recipe`;
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

INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (1, 1, 1, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (2, 1, 2, 0.15);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (6, 1, 3, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (7, 1, 4, 0.02);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (8, 1, 5, 0.03);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (9, 2, 6, 0.25);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (10, 2, 7, 0.05);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (11, 2, 47, 2.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (12, 2, 48, 2.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (13, 2, 50, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (14, 3, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (15, 3, 14, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (16, 3, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (17, 3, 23, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (18, 3, 35, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (19, 3, 44, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (20, 4, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (21, 4, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (22, 4, 23, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (23, 4, 33, 15.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (24, 4, 36, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (25, 4, 40, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (26, 5, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (27, 5, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (28, 5, 23, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (29, 5, 35, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (30, 6, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (31, 6, 15, 60.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (32, 6, 18, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (33, 6, 24, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (34, 6, 25, 10.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (35, 6, 42, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (36, 7, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (37, 7, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (38, 7, 23, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (39, 7, 39, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (40, 7, 43, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (41, 8, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (42, 8, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (43, 8, 23, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (44, 8, 4, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (45, 8, 5, 40.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (46, 8, 30, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (47, 8, 35, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (48, 9, 9, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (49, 9, 16, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (50, 9, 22, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (51, 9, 31, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (52, 9, 32, 15.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (53, 9, 35, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (54, 10, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (55, 10, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (56, 10, 23, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (57, 10, 37, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (58, 11, 11, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (59, 11, 17, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (60, 11, 22, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (61, 11, 38, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (62, 11, 43, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (63, 12, 12, 150.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (64, 12, 22, 40.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (65, 12, 29, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (66, 12, 32, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (67, 12, 36, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (68, 13, 4, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (69, 13, 5, 40.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (70, 13, 13, 1.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (71, 13, 30, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (72, 13, 35, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (73, 14, 50, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (74, 14, 52, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (75, 15, 51, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (76, 16, 19, 150.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (77, 16, 35, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (78, 17, 20, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (79, 17, 36, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (80, 17, 49, 5.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (81, 17, 52, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (82, 18, 35, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (83, 18, 53, 150.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (84, 19, 21, 150.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (85, 19, 26, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (86, 19, 34, 10.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (87, 19, 35, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (88, 20, 53, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (89, 20, 58, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (90, 20, 63, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (91, 21, 53, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (92, 21, 54, 30.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (93, 21, 55, 20.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (94, 21, 58, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (95, 21, 63, 10.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (96, 22, 56, 50.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (97, 22, 57, 100.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (98, 22, 58, 200.0);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (99, 31, 55, 0.2);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (100, 31, 58, 0.3);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (101, 31, 63, 0.1);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (102, 32, 57, 0.5);
INSERT INTO `recipe` (`id`, `product_id`, `ingredient_id`, `quantity`) VALUES (103, 32, 63, 0.08);

-- Estructura: sales
DROP TABLE IF EXISTS `sales`;
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

INSERT INTO `sales` (`id`, `user_id`, `total`, `status`, `created_at`, `stripe_session_id`) VALUES (1, 3, 12.5, 'OPEN', '2026-05-09 11:52:27.254028', 'cs_test_a1QQ2SNk2OH9G70qaHBQ7HB0WMOTr7hpT1EAti8BwYLySCJe77uYWrticS');
INSERT INTO `sales` (`id`, `user_id`, `total`, `status`, `created_at`, `stripe_session_id`) VALUES (2, 3, 12.5, 'PAID', '2026-05-09 15:26:09.613919', NULL);
INSERT INTO `sales` (`id`, `user_id`, `total`, `status`, `created_at`, `stripe_session_id`) VALUES (3, 3, 8.5, 'PAID', '2026-05-09 20:37:58.724265', NULL);

-- Estructura: sale_lines
DROP TABLE IF EXISTS `sale_lines`;
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

INSERT INTO `sale_lines` (`id`, `sale_id`, `product_id`, `quantity`, `unit_price`) VALUES (1, 1, 3, 1, 12.5);
INSERT INTO `sale_lines` (`id`, `sale_id`, `product_id`, `quantity`, `unit_price`) VALUES (2, 2, 3, 1, 12.5);
INSERT INTO `sale_lines` (`id`, `sale_id`, `product_id`, `quantity`, `unit_price`) VALUES (3, 3, 1, 1, 8.5);

-- Estructura: stock_batch
DROP TABLE IF EXISTS `stock_batch`;
CREATE TABLE `stock_batch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stock_ingredient_id` bigint(20) NOT NULL,
  `batch_number` varchar(100) DEFAULT NULL,
  `quantity` double NOT NULL,
  `expiration_date` date NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_stock_batch` (`stock_ingredient_id`,`batch_number`),
  CONSTRAINT `fk_batch_stock_ingredient` FOREIGN KEY (`stock_ingredient_id`) REFERENCES `stock_ingredient` (`ingredient_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (1, 1, NULL, 8.0, '2026-05-11', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (2, 2, NULL, 19.85, '2026-05-09', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (3, 3, NULL, 29.0, '2026-05-14', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (4, 4, NULL, 9.98, '2026-05-08', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (5, 5, NULL, 9.97, '2026-05-08', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (6, 6, NULL, 15.0, '2026-05-14', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (7, 7, NULL, 5.0, '2026-06-03', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (8, 8, NULL, 5000.0, '2025-03-15', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (9, 9, NULL, 1000.0, '2025-03-20', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (10, 10, NULL, 500.0, '2025-03-10', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (11, 11, NULL, 299.0, '2025-03-10', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (12, 12, NULL, 2000.0, '2025-03-12', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (13, 13, NULL, 200.0, '2025-04-01', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (14, 14, NULL, 1450.0, '2025-03-08', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (15, 15, NULL, 1000.0, '2025-03-08', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (16, 16, NULL, 3000.0, '2025-03-20', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (17, 17, NULL, 1970.0, '2025-03-15', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (18, 18, NULL, 800.0, '2025-03-18', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (19, 19, NULL, 500.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (20, 20, NULL, 500.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (21, 21, NULL, 500.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (22, 22, NULL, 1500.0, '2025-03-28', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (23, 23, NULL, 900.0, '2025-03-28', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (24, 24, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (25, 25, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (26, 26, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (27, 27, NULL, 500.0, '2025-03-25', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (28, 29, NULL, 1000.0, '2025-03-10', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (29, 30, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (30, 31, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (31, 32, NULL, 800.0, '2025-03-15', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (32, 33, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (33, 34, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (34, 35, NULL, 4980.0, '2025-06-30', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (35, 36, NULL, 3000.0, '2025-05-30', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (36, 37, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (37, 38, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (38, 39, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (39, 40, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (40, 42, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (41, 43, NULL, 300.0, '2025-03-12', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (42, 44, NULL, 980.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (43, 47, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (44, 48, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (45, 49, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (46, 50, NULL, 5000.0, '2025-04-30', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (47, 51, NULL, 2000.0, '2025-04-30', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (48, 52, NULL, 1000.0, '2025-04-30', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (49, 53, NULL, 500.0, '2025-03-20', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (50, 54, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (51, 55, NULL, 8.0, '2026-08-02', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (52, 56, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (53, 57, NULL, 1000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (54, 58, NULL, 10.0, '2026-05-10', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (55, 59, NULL, 10000.0, '2025-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (56, 60, NULL, 2000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (57, 61, NULL, 50.0, '2026-06-03', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (58, 62, NULL, 2000.0, '2026-12-31', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (59, 63, NULL, 12.0, '2027-05-04', '2026-05-10 01:32:12.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (64, 1, 'LOTE-20260510-9926', 6.0, '2026-05-11', '2026-05-10 18:20:03.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (65, 1, 'LOTE-20260510-3789', 6.0, '2026-05-11', '2026-05-10 18:20:37.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (66, 1, 'LOTE-20260510-7146', 20.0, '2026-05-11', '2026-05-10 18:29:41.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (67, 1, 'LOTE-20260510-5031', 20.0, '2026-05-11', '2026-05-10 18:29:45.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (68, 1, 'LOTE-20260510-1534', 60.0, '2026-05-11', '2026-05-10 18:32:49.0');
INSERT INTO `stock_batch` (`id`, `stock_ingredient_id`, `batch_number`, `quantity`, `expiration_date`, `created_at`) VALUES (69, 4, 'LOTE-20260510-2827', 4.98, '2026-05-21', '2026-05-10 18:34:40.0');

-- Estructura: stock_ingredient
DROP TABLE IF EXISTS `stock_ingredient`;
CREATE TABLE `stock_ingredient` (
  `ingredient_id` bigint(20) NOT NULL,
  `current_stock` double DEFAULT NULL,
  `min_stock` double DEFAULT NULL,
  `max_stock` double DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`ingredient_id`),
  CONSTRAINT `fk_stock_ingredient` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (1, 120.0, 5.0, 50.0, '2026-05-11');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (2, 19.85, 2.0, 20.0, '2026-05-09');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (3, 29.0, 3.0, 30.0, '2026-05-14');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (4, 4.98, 1.0, 10.0, '2026-05-21');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (5, 9.97, 1.0, 10.0, '2026-05-08');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (6, 15.0, 2.0, 15.0, '2026-05-14');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (7, 5.0, 1.0, 5.0, '2026-06-03');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (8, 5000.0, 100.0, 1000.0, '2025-03-15');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (9, 1000.0, 100.0, 1000.0, '2025-03-20');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (10, 500.0, 100.0, 1000.0, '2025-03-10');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (11, 299.0, 100.0, 1000.0, '2025-03-10');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (12, 2000.0, 100.0, 1000.0, '2025-03-12');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (13, 200.0, 100.0, 1000.0, '2025-04-01');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (14, 1450.0, 100.0, 1000.0, '2025-03-08');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (15, 1000.0, 100.0, 1000.0, '2025-03-08');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (16, 3000.0, 100.0, 1000.0, '2025-03-20');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (17, 1970.0, 100.0, 1000.0, '2025-03-15');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (18, 800.0, 100.0, 1000.0, '2025-03-18');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (19, 500.0, 50.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (20, 500.0, 50.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (21, 500.0, 50.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (22, 1500.0, 100.0, 1000.0, '2025-03-28');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (23, 900.0, 100.0, 1000.0, '2025-03-28');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (24, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (25, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (26, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (27, 500.0, 100.0, 1000.0, '2025-03-25');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (29, 1000.0, 100.0, 1000.0, '2025-03-10');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (30, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (31, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (32, 800.0, 100.0, 1000.0, '2025-03-15');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (33, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (34, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (35, 4980.0, 100.0, 1000.0, '2025-06-30');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (36, 3000.0, 100.0, 1000.0, '2025-05-30');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (37, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (38, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (39, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (40, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (42, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (43, 300.0, 100.0, 1000.0, '2025-03-12');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (44, 980.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (47, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (48, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (49, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (50, 5000.0, 100.0, 1000.0, '2025-04-30');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (51, 2000.0, 100.0, 1000.0, '2025-04-30');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (52, 1000.0, 100.0, 1000.0, '2025-04-30');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (53, 500.0, 100.0, 1000.0, '2025-03-20');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (54, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (55, 8.0, 1.0, 20.0, '2026-08-02');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (56, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (57, 1000.0, 100.0, 1000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (58, 10.0, 2.0, 25.0, '2026-05-10');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (59, 10000.0, 100.0, 1000.0, '2025-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (60, 2000.0, 200.0, 5000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (61, 50.0, 10.0, 200.0, '2026-06-03');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (62, 2000.0, 200.0, 5000.0, '2026-12-31');
INSERT INTO `stock_ingredient` (`ingredient_id`, `current_stock`, `min_stock`, `max_stock`, `expiration_date`) VALUES (63, 12.0, 2.0, 30.0, '2027-05-04');

-- Estructura: stock_movement
DROP TABLE IF EXISTS `stock_movement`;
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

INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (1, 1, NULL, 1.0, 'RESTOCK', '2026-05-08 17:17:18.050541');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (2, 1, NULL, 2.0, 'RESTOCK', '2026-05-08 17:17:18.177584');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (3, 1, NULL, 3.0, 'RESTOCK', '2026-05-08 17:17:18.749352');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (4, 1, NULL, 4.0, 'RESTOCK', '2026-05-08 17:17:18.919191');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (5, 11, 2, -1.0, 'SALE', '2026-05-09 15:26:26.849283');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (6, 14, 2, -50.0, 'SALE', '2026-05-09 15:26:27.705028');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (7, 17, 2, -30.0, 'SALE', '2026-05-09 15:26:28.409541');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (8, 23, 2, -100.0, 'SALE', '2026-05-09 15:26:29.114968');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (9, 35, 2, -20.0, 'SALE', '2026-05-09 15:26:29.817455');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (10, 44, 2, -20.0, 'SALE', '2026-05-09 15:26:30.533307');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (11, 1, 3, -1.0, 'SALE', '2026-05-09 20:38:02.026787');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (12, 2, 3, -0.15, 'SALE', '2026-05-09 20:38:03.392867');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (13, 3, 3, -1.0, 'SALE', '2026-05-09 20:38:03.933878');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (14, 4, 3, -0.02, 'SALE', '2026-05-09 20:38:04.464405');
INSERT INTO `stock_movement` (`id`, `ingredient_id`, `sale_id`, `quantity`, `type`, `created_at`) VALUES (15, 5, 3, -0.03, 'SALE', '2026-05-09 20:38:05.021385');

-- Estructura: users
DROP TABLE IF EXISTS `users`;
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

INSERT INTO `users` (`id`, `name`, `password`, `role`, `enabled`, `register_at`, `profile_photo`) VALUES (1, 'admin', '$2a$10$I4/tOWcdGDUm4JI2d0tPX.4d0QjxM.XB0c.7TnJZaB1w4seHM8bZq', 'ADMIN', true, '2026-05-07 19:46:56.254358', NULL);
INSERT INTO `users` (`id`, `name`, `password`, `role`, `enabled`, `register_at`, `profile_photo`) VALUES (2, 'yeray', '$2a$10$B2o4UnCMS8MXv72nZOJWee5YYM8S5OtRFoU/su2OeNNbl3lCMyl3u', 'CAMARERO', true, '2026-05-07 19:46:56.416286', NULL);
INSERT INTO `users` (`id`, `name`, `password`, `role`, `enabled`, `register_at`, `profile_photo`) VALUES (3, 'gerente', '$2a$10$LbgSu1VRlHLRLrMxQLf9j.J.T96gyanjnKR3AVnrF0W081/aXQmxm', 'GERENTE', true, '2026-05-07 19:46:56.544679', NULL);

