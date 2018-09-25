-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 26, 2018 at 01:26 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `forito`
--

-- --------------------------------------------------------

--
-- Table structure for table `comentarios`
--

CREATE TABLE `comentarios` (
  `com_id` int(11) NOT NULL,
  `com_posteo` int(11) NOT NULL,
  `com_autor` int(30) NOT NULL,
  `com_mensaje` varchar(120) COLLATE utf32_spanish2_ci NOT NULL,
  `com_orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish2_ci;

--
-- Dumping data for table `comentarios`
--

INSERT INTO `comentarios` (`com_id`, `com_posteo`, `com_autor`, `com_mensaje`, `com_orden`) VALUES
(3, 82, 1, 'Aca les mando la fotoss', 1),
(4, 82, 2, 'Muy gracioso... Dónde está mi pack?', 2),
(5, 82, 4, '2pala', 3);

-- --------------------------------------------------------

--
-- Table structure for table `posteos`
--

CREATE TABLE `posteos` (
  `pos_id` int(11) NOT NULL,
  `pos_titulo` varchar(40) COLLATE utf32_spanish2_ci NOT NULL,
  `pos_autor` varchar(30) COLLATE utf32_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish2_ci;

--
-- Dumping data for table `posteos`
--

INSERT INTO `posteos` (`pos_id`, `pos_titulo`, `pos_autor`) VALUES
(82, 'Pack de fotos de pollos desnudos', 'Juan Carlos'),
(83, 'Fechas de examenes finales', 'Eduardo'),
(84, 'Ejemplo CRUD', 'Mariano');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `us_id` int(11) NOT NULL,
  `us_nick` varchar(20) COLLATE utf16_spanish2_ci NOT NULL,
  `us_mail` varchar(50) COLLATE utf16_spanish2_ci NOT NULL,
  `us_foto` varchar(200) COLLATE utf16_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`us_id`, `us_nick`, `us_mail`, `us_foto`) VALUES
(1, 'Diego', 'diego@diego.com', 'https://www.what-dog.net/Images/faces2/scroll0015.jpg'),
(2, 'Bigi', 'bigi@bigi.com', 'https://www.nationalgeographic.com/content/dam/animals/thumbs/rights-exempt/mammals/m/mountain-gorilla_thumb.ngsversion.1485187202412.adapt.1900.1.jpg'),
(3, 'Juan', 'juan@juan.com', 'https://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg'),
(4, 'Roberto', 'roberto@roberto.com', 'https://assets.change.org/photos/5/iz/mb/uDIzmBupCuNsUUX-800x450-noPad.jpg?1519267641');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`com_id`),
  ADD KEY `com_posteo` (`com_posteo`),
  ADD KEY `com_posteo_2` (`com_posteo`),
  ADD KEY `com_autor` (`com_autor`);

--
-- Indexes for table `posteos`
--
ALTER TABLE `posteos`
  ADD PRIMARY KEY (`pos_id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`us_id`),
  ADD KEY `us_nick` (`us_nick`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `com_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `posteos`
--
ALTER TABLE `posteos`
  MODIFY `pos_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `us_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`com_posteo`) REFERENCES `posteos` (`pos_id`),
  ADD CONSTRAINT `comentarios_ibfk_2` FOREIGN KEY (`com_autor`) REFERENCES `usuarios` (`us_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
