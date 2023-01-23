-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysqlDawes:3306
-- Tiempo de generación: 23-01-2023 a las 01:02:28
-- Versión del servidor: 5.7.22
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE miTiendaSpringRomeroSergio;
--
-- Base de datos: `miTiendaSpringRomeroSergio`
--
USE `miTiendaSpringRomeroSergio`;
--
-- --------------------------------------------------------
 CREATE USER 'romero'@'%' IDENTIFIED BY 'sergio';
 GRANT ALL PRIVILEGES ON miTiendaSpringRomeroSergio.* to 'romero'@'%';
--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `genres` varchar(50) NOT NULL,
  `description_category` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `genres`, `description_category`) VALUES
(1, 'Horror 2', 'fringilla rhoncus mauris2'),
(2, 'Drama', 'praesent blandit lacinia'),
(3, 'Sci-Fi', 'arcu libero rutrum'),
(4, 'Comedy', 'lectus pellentesque at'),
(5, 'Romance', 'sit amet eleifend'),
(6, 'Thriller', 'amet consectetuer adipiscing'),
(7, 'Children', 'placerat ante nulla'),
(8, 'Animation', 'mi nulla ac'),
(9, 'Action', 'faucibus orci luctus'),
(10, 'Documentary', 'ut ultrices vel'),
(11, 'Horror 2', 'si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description_movie` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `category_id` int(11) NOT NULL,
  `img` longblob,
  `stock` int(50) DEFAULT '30'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movies`
--

INSERT INTO `movies` (`id`, `title`, `description_movie`, `price`, `category_id`, `img`, `stock`) VALUES
(1, 'L-Shaped Room, The', 'diam', 3.72, 6, NULL, 30),
(2, 'Sahara', 'odio', 3.49, 4, NULL, 30),
(3, 'Himizu', 'donec odio', 3.87, 4, NULL, 30),
(4, 'Solaris', 'odio', 6.13, 7, NULL, 30),
(5, 'Daydream Nation', 'orci', 5.26, 10, NULL, 30),
(6, 'Siegfried', 'at feugiat', 9.05, 7, NULL, 30),
(7, 'Beau Brummell: This Charming Man', 'eu massa donec', 2.27, 10, NULL, 30),
(8, 'Burn After Reading', 'tellus', 6.63, 8, NULL, 30),
(9, 'Nameless Gangster (Bumchoiwaui junjaeng)', 'curae mauris viverra', 3.85, 4, NULL, 30),
(10, 'Our Folks (Sami swoi)', 'ut', 2.76, 2, NULL, 30),
(11, 'Batman: Assault on Arkham', 'nibh', 5.84, 2, NULL, 30),
(12, 'Persuasion', 'quis turpis eget', 9.62, 8, NULL, 30),
(13, 'Zero 2', 'ut nulla sed', 1.16, 4, NULL, 30),
(14, 'Rum Diary, The', 'erat', 8.74, 9, NULL, 30),
(15, 'Black Bread (Pa Negre)', 'amet', 7.74, 5, NULL, 30),
(16, 'Berlin Express', 'est donec odio', 8.69, 5, NULL, 30),
(17, 'Anything Goes', 'turpis a pede', 3.54, 5, NULL, 30),
(18, 'Fairly Odd Movie: Grow Up, Timmy Turner!, A', 'nulla neque', 2.97, 1, NULL, 30),
(19, 'Zazie dans le métro', 'velit eu est', 2.29, 9, NULL, 30),
(20, 'Blackout, The', 'scelerisque', 9, 3, NULL, 30),
(21, 'Ararat', 'nisi', 8.1, 1, NULL, 30),
(22, 'Midnight Movie', 'massa volutpat convallis', 5.41, 8, NULL, 30),
(23, 'Ice Station Zebra', 'porta volutpat', 8.93, 4, NULL, 30),
(24, 'Dante s Inferno', 'eget vulputate ut', 7.72, 1, NULL, 30),
(25, 'We re No Angels', 'elit', 1.08, 9, NULL, 30),
(26, 'Harry and the Hendersons', 'lectus aliquam', 5.66, 8, NULL, 30),
(27, 'King Solomon s Mines', 'suspendisse', 3.87, 1, NULL, 30),
(28, 'Puddle Cruiser', 'dolor quis odio', 5.04, 4, NULL, 30),
(29, 'Beetlejuice', 'ut', 7.16, 8, NULL, 30),
(30, 'Massacre Canyon', 'in faucibus orci', 5.29, 4, NULL, 30),
(31, 'Blue Crush', 'primis in', 7.53, 7, NULL, 30),
(32, 'Beautiful Life, A', 'nisl duis', 8.29, 4, NULL, 30),
(33, 'Storage', 'in lacus', 2.46, 8, NULL, 30),
(34, 'Oculus', 'morbi vel lectus', 5.83, 3, NULL, 30),
(35, 'Eddie Izzard: Glorious', 'in blandit', 3.6, 7, NULL, 30),
(36, 'Innocent Sleep, The', 'montes nascetur ridiculus', 8.55, 10, NULL, 30),
(37, 'Evelyn Prentice', 'in blandit ultrices', 8.25, 4, NULL, 30),
(38, 'Heartbeats (Les amours imaginaires)', 'ultrices', 7.98, 9, NULL, 30),
(39, '42nd Street', 'faucibus orci', 8.96, 3, NULL, 30),
(40, 'Bigga Than Ben', 'convallis', 1.8, 7, NULL, 30),
(41, 'Pursuit of Happiness, The', 'ipsum primis', 7.44, 8, NULL, 30),
(42, 'Endurance: Shackleton s Legendary Antarctic Expedition, The', 'in sapien', 9.05, 5, NULL, 30),
(43, 'Great White Hype, The', 'pede malesuada in', 4.8, 7, NULL, 30),
(44, 'Perils of the Sentimental Swordsman', 'sapien ut nunc', 8.87, 9, NULL, 30),
(45, 'Day of the Crows, The (Le jour des corneilles)', 'eleifend donec ut', 8.9, 5, NULL, 30),
(46, 'Tigger Movie, The', 'aliquam lacus', 3.5, 1, NULL, 30),
(47, 'His Private Secretary', 'quisque', 2.04, 10, NULL, 30),
(48, 'Pulse', 'dui proin', 7.36, 4, NULL, 30),
(49, 'Chef', 'cum', 2.18, 9, NULL, 30),
(50, 'Monsieur Batignole', 'turpis donec posuere', 6.43, 10, NULL, 30),
(51, 'Beware of Mr. Baker', 'tortor', 7.91, 4, NULL, 30),
(52, 'Stella', 'sed nisl nunc', 7.49, 8, NULL, 30),
(53, 'Pitfall (Otoshiana)', 'quis turpis', 3.14, 1, NULL, 30),
(54, 'Revolt in the Fifth Dimension', 'fusce', 9.91, 2, NULL, 30),
(55, 'Branded to Kill (Koroshi no rakuin)', 'magna', 8.1, 6, NULL, 30),
(56, 'H-Man, The (Bijo to Ekitainingen)', 'mi in porttitor', 8.98, 9, NULL, 30),
(57, 'First Comes Love', 'feugiat non', 8.89, 2, NULL, 30),
(58, 'Horse Whisperer, The', 'hendrerit at', 2.07, 4, NULL, 30),
(59, 'Forger, The', 'lectus suspendisse', 8.81, 7, NULL, 30),
(60, 'Faust', 'purus eu magna', 6.98, 8, NULL, 30),
(61, 'Guns of Fort Petticoat, The', 'tincidunt ante vel', 5.96, 5, NULL, 30),
(62, 'Tarzan, the Ape Man', 'aliquam non', 2.85, 2, NULL, 30),
(63, 'Double Trouble', 'praesent', 5.76, 7, NULL, 30),
(64, 'Hearts of the West', 'amet diam', 8.41, 2, NULL, 30),
(65, 'Alpha and Omega 2: A Howl-iday Adventure (Alpha &amp; Omega 2)', 'suspendisse ornare', 4.68, 6, NULL, 30),
(66, 'Midnight Clear, A', 'libero nullam', 9.49, 8, NULL, 30),
(67, 'Rape of Europa, The', 'at turpis', 4.24, 5, NULL, 30),
(68, 'Double Wedding', 'dui vel nisl', 6.51, 1, NULL, 30),
(69, 'Shakthi: The Power', 'in hac', 8.79, 4, NULL, 30),
(70, 'Carman: The Champion', 'sodales', 1.56, 1, NULL, 30),
(71, 'Genocide (Konchû daisensô)', 'morbi', 7.13, 1, NULL, 30),
(72, 'Salaam Cinema', 'vel lectus', 8.91, 9, NULL, 30),
(73, '100 Girls', 'magnis dis', 8.33, 10, NULL, 30),
(74, 'Shiver of the Vampires, The (Frisson des vampires, Le)', 'mauris', 6.04, 3, NULL, 30),
(75, 'In Between Days', 'sed', 3.67, 8, NULL, 30),
(76, 'Executive Action', 'purus', 9.11, 4, NULL, 30),
(77, 'Colt Comrades', 'aliquam', 6.16, 2, NULL, 30),
(78, 'Tokyo Olympiad', 'vestibulum aliquet', 1.83, 6, NULL, 30),
(79, 'Unreal Dream: The Michael Morton Story, An', 'sollicitudin', 3.01, 3, NULL, 30),
(80, 'Once Upon a Time in the Midlands', 'ipsum dolor', 1.31, 9, NULL, 30),
(81, 'Meet Me at the Fair', 'nisi vulputate nonummy', 1.71, 10, NULL, 30),
(82, 'Virgin Queen, The', 'eget eleifend luctus', 8.46, 8, NULL, 30),
(83, 'Something the Lord Made', 'ultricies eu', 7.49, 7, NULL, 30),
(84, 'Ballad of the Little Soldier (Ballade vom kleinen Soldaten)', 'amet', 5.4, 7, NULL, 30),
(85, 'Final Destination 5', 'posuere cubilia', 9.9, 6, NULL, 30),
(86, 'Kelly s Heroes', 'purus eu magna', 8.39, 7, NULL, 30),
(87, 'Hard Rain', 'mauris laoreet ut', 7.7, 2, NULL, 30),
(88, 'Law Abiding Citizen', 'ante vel', 6.52, 2, NULL, 30),
(89, 'Love Is Colder Than Death (Liebe ist kälter als der Tod)', 'massa quis augue', 8.19, 6, NULL, 30),
(90, 'Painted Veil, The', 'est phasellus sit', 2.08, 8, NULL, 30),
(91, 'One Life', 'libero', 4.68, 2, NULL, 30),
(92, 'Larry the Cable Guy: Health Inspector', 'ac lobortis', 6.16, 5, NULL, 30),
(93, 'Léon Morin, Priest (Léon Morin, prêtre)', 'sem', 1.06, 5, NULL, 30),
(94, 'Wheels on Meals (Kuai can che)', 'in porttitor', 4.04, 4, NULL, 30),
(95, 'Dom Hemingway', 'dis parturient montes', 8.96, 10, NULL, 30),
(96, 'Shed No Tears (Känn ingen sorg)', 'tellus in', 8.06, 8, NULL, 30),
(97, 'New Country, The (Det nya landet)', 'habitasse platea dictumst', 7.14, 1, NULL, 30),
(98, 'Who ll Stop the Rain', 'sollicitudin vitae', 8.22, 10, NULL, 30),
(99, 'Mezzo Forte', 'lectus', 1.41, 8, NULL, 30),
(100, 'Snakehead Terror', 'faucibus', 2.56, 4, NULL, 30),
(101, 'pedros', 'pedros y sus casas', 10, 1, NULL, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `cod` int(11) NOT NULL,
  `date_order` date NOT NULL,
  `iva` int(20) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `purchase`
--

CREATE TABLE `purchase` (
  `cod` int(50) NOT NULL,
  `id_movie` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `verificationCode` varchar(64) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `email` varchar(30) NOT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  `admin` bit(1) NOT NULL,
  `image` varchar(300) DEFAULT 'https://res.cloudinary.com/df7eewfeo/image/upload/v1674464819/png-clipart-user-profile-computer-icons-login-user-avatars-monochrome-black-thumbnail_cnj3wp.png'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`username`, `password`, `first_name`, `role`, `verificationCode`, `enabled`, `email`, `verification_code`, `admin`, `image`) VALUES
('admin', '$2a$10$xDMWmsMMgu4PoKuFqdduFuz2wLzqAJPrwds0qXXjT1tARB7O4RIvy', 'admin', 'ADMIN', NULL, b'1', 'romeroromerosergio@gmail.com', 'lr6RaxkqszesVhlDaiOAUIuFiYKmI1A4eTP1BrzLht4nZYmVgFEiWICHr6L7hIMW', b'0', 'https://res.cloudinary.com/df7eewfeo/image/upload/v1674464819/png-clipart-user-profile-computer-icons-login-user-avatars-monochrome-black-thumbnail_cnj3wp.png'),
('sergio', '$2a$10$fuUASL7nRmIjqhU3zRyXk.TdoQ2ucviNTeHCglADGmzAWpvsttOCy', 'sergio', 'USER', NULL, b'1', 'sergior500@gmail.com', 'DbJQMfxZrOO9iZoVVvsXaAWBvslncPRYsT5lAcdx2n6mTX85K5CtpVabuBLsUFLI', b'0', 'http://res.cloudinary.com/df7eewfeo/image/upload/v1674464189/tcsirlhnquwilbcpownh.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`),
  ADD KEY `FK_movies` (`category_id`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `FK_orders` (`username`);

--
-- Indices de la tabla `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`cod`,`id_movie`),
  ADD KEY `cod` (`cod`),
  ADD KEY `id_movie` (`id_movie`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `FK_movies` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_orders` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`cod`) REFERENCES `orders` (`cod`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`id_movie`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;