-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-05-2020 a las 16:18:15
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practicam12`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuaris`
--
CREATE DATABASE IF NOT EXISTS `practicam12`;
USE DATABASE `practicam12`;

CREATE TABLE `usuaris` (
  `nom` varchar(30) NOT NULL,
  `contrassenya` varchar(30) NOT NULL,
  `tipusUsuari` varchar(30) NOT NULL,
  `idUsuari` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuaris`
--

INSERT INTO `usuaris` (`nom`, `contrassenya`, `tipusUsuari`, `idUsuari`) VALUES
('Admin', '1234', 'administrador', 1),
('alumne1', '5678', 'alumne', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuaris`
--
ALTER TABLE `usuaris`
  ADD PRIMARY KEY (`idUsuari`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuaris`
--
ALTER TABLE `usuaris`
  MODIFY `idUsuari` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
