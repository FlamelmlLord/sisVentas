-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2023 a las 04:43:25
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventasdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `UUID` varchar(36) NOT NULL DEFAULT uuid(),
  `Identificacion` varchar(15) DEFAULT NULL,
  `Nombres` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Estado` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`UUID`, `Identificacion`, `Nombres`, `Apellidos`, `Direccion`, `Estado`) VALUES
('3d97969a-f12e-11ed-b4af-80304968d752', '1015998552', 'Jose Pablo', 'Perez Arrieta', 'Tv 96B #21A-70', 1),
('3d97a395-f12e-11ed-b4af-80304968d752', '79570587', 'Juan', 'Martinez Salamanca', 'Calle 57 #30-70', 1),
('3d97a47d-f12e-11ed-b4af-80304968d752', '567813245', 'Juan Pablo', 'Perez Arrieta', 'Carrera 96C #21A-33', 1),
('3d97a4eb-f12e-11ed-b4af-80304968d752', '1010551889', 'Guillermo', 'Santala Mir', 'Calle 32 54-89', 1),
('3d97a54c-f12e-11ed-b4af-80304968d752', '5478921456', 'Pedro Vicente', 'Sanchez Pizjuan', 'Crra 96B #21A-70', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `IdDetalle` int(11) NOT NULL,
  `Venta` varchar(36) NOT NULL,
  `Producto` varchar(36) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `UUID` varchar(36) NOT NULL DEFAULT uuid(),
  `Usuario` varchar(50) DEFAULT NULL,
  `Nombres` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  `Estado` int(1) DEFAULT 1,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`UUID`, `Usuario`, `Nombres`, `Apellidos`, `Telefono`, `Estado`, `password`) VALUES
('74745017-f90f-11ed-9162-d85ed30d9217', 'empleado1', 'Karen Daniela', 'Garzon', '3142101075', 1, 'c91d34234d6f27b926da7563a3720247a88ac492dc44309e7943dbe768180dad106040f37ac9f8209e510706f5e04acb78cdf029abcbd302262fec0357c29306');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID` int(11) NOT NULL,
  `UUID` varchar(36) NOT NULL DEFAULT uuid(),
  `Nombre` varchar(50) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Estado` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID`, `UUID`, `Nombre`, `Precio`, `Stock`, `Estado`) VALUES
(1, '3e165a84-f12e-11ed-b4af-80304968d752', 'Teclado LOGITECH Inalámbrico Bluetooth K380 Rosado', 199900, 99, 1),
(2, '3e167552-f12e-11ed-b4af-80304968d752', 'Mouse LOGITECH Alámbrico Gaming G203 Blanco', 149900, 98, 1),
(3, '3e16786c-f12e-11ed-b4af-80304968d752', 'MacBook Air de 13\" Pulgadas MGN63LA/A Chip M1 RAM ', 4799000, 100, 1),
(4, '3e1679e7-f12e-11ed-b4af-80304968d752', 'Audífonos de Diadema JBL Inalámbricos Bluetooth On', 249900, 98, 1),
(5, '3e167a8f-f12e-11ed-b4af-80304968d752', 'Monitor LG 29\" Pulgadas 29WL500 Negro', 1039000, 35, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `UUID` varchar(36) NOT NULL DEFAULT uuid(),
  `ID` int(11) NOT NULL,
  `Cliente` varchar(36) NOT NULL,
  `Empleado` varchar(36) NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `Fecha` date DEFAULT current_timestamp(),
  `Total` double DEFAULT NULL,
  `Estado` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`UUID`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`IdDetalle`),
  ADD KEY `Venta` (`Venta`),
  ADD KEY `Producto` (`Producto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`UUID`),
  ADD UNIQUE KEY `Usuario` (`Usuario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID`,`UUID`),
  ADD UNIQUE KEY `UUID` (`UUID`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`UUID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `Cliente` (`Cliente`),
  ADD KEY `Empleado` (`Empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `IdDetalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`Venta`) REFERENCES `venta` (`UUID`),
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`Producto`) REFERENCES `producto` (`UUID`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`UUID`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`Empleado`) REFERENCES `empleado` (`UUID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
