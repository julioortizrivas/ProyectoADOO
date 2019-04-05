-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-04-2019 a las 04:08:45
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE eventos;
USE eventos;

--
-- Base de datos: `eventos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `idEvento` varchar(10) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Descrip` varchar(120) NOT NULL,
  `Duracion` time NOT NULL,
  `Cupo` int(11) NOT NULL,
  `Imagen` blob,
  `idLugar` varchar(10) NOT NULL,
  `idGestor_reg` varchar(10) NOT NULL,
  `Fecha_reg` date NOT NULL,
  `Hora_reg` time NOT NULL,
  `idTipo` varchar(10) NOT NULL,
  `idOrganizador` varchar(10) NOT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `fk_EVENTO_LUGAR1_idx` (`idLugar`),
  KEY `fk_EVENTO_USUARIO_REG_GESTOR1_idx` (`idGestor_reg`),
  KEY `fk_EVENTO_EVENTO_TIPO1_idx` (`idTipo`),
  KEY `fk_EVENTO_EVENTO_ORGANIZADORES1_idx` (`idOrganizador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`idEvento`, `Nombre`, `Fecha`, `Hora`, `Descrip`, `Duracion`, `Cupo`, `Imagen`, `idLugar`, `idGestor_reg`, `Fecha_reg`, `Hora_reg`, `idTipo`, `idOrganizador`) VALUES
('192COnf', 'COnferencia ORACLE', '2019-02-25', '10:00:00', 'Chida.', '02:00:00', 30, NULL, 'Sala14Edu', 'vicleo', '2019-02-21', '13:46:02', 'Academ', 'DepaInv'),
('194Conf', 'Conferenciaaa', '2019-04-17', '09:00:00', '', '00:30:00', 12, NULL, 'Sala14Edu', 'vicleo', '2019-04-01', '14:45:29', 'Academ', 'DepaInv'),
('ConfCom', 'Conferencia sobre computación.', '2019-02-22', '10:00:00', '', '02:00:00', 80, NULL, 'Sala14Edu', 'vicleo', '2019-02-19', '17:12:21', 'Academ', 'DepaInv');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento_cancelado`
--

DROP TABLE IF EXISTS `evento_cancelado`;
CREATE TABLE IF NOT EXISTS `evento_cancelado` (
  `idEventoCancelado` varchar(10) NOT NULL,
  `Motivos` varchar(120) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  PRIMARY KEY (`idEventoCancelado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento_organizadores`
--

DROP TABLE IF EXISTS `evento_organizadores`;
CREATE TABLE IF NOT EXISTS `evento_organizadores` (
  `idOrganizador` varchar(10) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idOrganizador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `evento_organizadores`
--

INSERT INTO `evento_organizadores` (`idOrganizador`, `Nombre`) VALUES
('DepaCS', 'Departamento de Ciencias Sociales'),
('DepaInv', 'Departamento de Investigación');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento_tipo`
--

DROP TABLE IF EXISTS `evento_tipo`;
CREATE TABLE IF NOT EXISTS `evento_tipo` (
  `idTipo` varchar(10) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `evento_tipo`
--

INSERT INTO `evento_tipo` (`idTipo`, `Nombre`) VALUES
('Academ', 'Académico'),
('Cult', 'Cultural'),
('Deport', 'Deportivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar`
--

DROP TABLE IF EXISTS `lugar`;
CREATE TABLE IF NOT EXISTS `lugar` (
  `idLugar` varchar(10) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Ubicación` varchar(45) NOT NULL,
  `Descrip` varchar(45) DEFAULT NULL,
  `Cupo` int(11) NOT NULL,
  `idAdmin_reg` varchar(10) NOT NULL,
  `Fecha_reg` date NOT NULL,
  `Hora_reg` time NOT NULL,
  PRIMARY KEY (`idLugar`),
  KEY `fk_LUGAR_USUARIO_REG_ADMIN1_idx` (`idAdmin_reg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `lugar`
--

INSERT INTO `lugar` (`idLugar`, `Nombre`, `Ubicación`, `Descrip`, `Cupo`, `idAdmin_reg`, `Fecha_reg`, `Hora_reg`) VALUES
('Sala14Edu', 'Sala 14 Eduardo Torríjoz', 'Sala 14 Edificio de laboratorios', '', 100, 'julioortiz', '2019-02-19', '17:09:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizador_contacto`
--

DROP TABLE IF EXISTS `organizador_contacto`;
CREATE TABLE IF NOT EXISTS `organizador_contacto` (
  `idOrganizador` varchar(10) NOT NULL,
  `Contacto` varchar(60) NOT NULL,
  PRIMARY KEY (`idOrganizador`,`Contacto`),
  KEY `fk_EVENTO_CONTACTO_EVENTO_ORGANIZADORES1_idx` (`idOrganizador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `organizador_contacto`
--

INSERT INTO `organizador_contacto` (`idOrganizador`, `Contacto`) VALUES
('DepaCS', '5512348925'),
('DepaInv', '5532561548');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_reg`
--

DROP TABLE IF EXISTS `usuario_reg`;
CREATE TABLE IF NOT EXISTS `usuario_reg` (
  `idUSUARIO_REG` varchar(10) NOT NULL,
  `ApPat` varchar(45) NOT NULL,
  `ApMat` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Contrasenia` varbinary(8000) NOT NULL,
  `FechaReg` date NOT NULL,
  `HoraReg` time NOT NULL,
  PRIMARY KEY (`idUSUARIO_REG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_reg`
--

INSERT INTO `usuario_reg` (`idUSUARIO_REG`, `ApPat`, `ApMat`, `Nombre`, `Correo`, `Telefono`, `Contrasenia`, `FechaReg`, `HoraReg`) VALUES
('celesmel', 'Melo', 'Barranco', 'Celeste', 'celemelo@hotmail.com', '5512478963', 0x0517638f80fe3f1e6bb7f8118682a3d1, '2019-02-19', '17:01:36'),
('enridi', 'Ramos', 'Díaz', 'Enrike', 'enrike@hotmail.com', '5532478915', 0x0517638f80fe3f1e6bb7f8118682a3d1, '2019-02-19', '17:00:34'),
('erneviz', 'Vizcarra', 'Fletes', 'Juan Ernesto', 'vizcajuan@hotmail.com', '6692351645', 0x0517638f80fe3f1e6bb7f8118682a3d1, '2019-02-19', '17:02:36'),
('euler', 'Hernández', 'Contreras', 'Euler', 'euler@hotmail.com', '5120456890', 0x8d0c5b3000a4baa49cc45c2f60c5141f, '2019-02-21', '13:47:42'),
('julioortiz', 'Ortiz', 'Rivas', 'Julio César', 'julio_cesar502@hotmail.com', '6691541466', 0x0517638f80fe3f1e6bb7f8118682a3d1, '2019-02-19', '16:57:42'),
('vicleo', 'Morales', 'Flores', 'Víctor', 'vicleo@hotmail.com', '5531245087', 0x0517638f80fe3f1e6bb7f8118682a3d1, '2019-02-19', '16:59:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_reg_admin`
--

DROP TABLE IF EXISTS `usuario_reg_admin`;
CREATE TABLE IF NOT EXISTS `usuario_reg_admin` (
  `idADMIN` varchar(10) NOT NULL,
  PRIMARY KEY (`idADMIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_reg_admin`
--

INSERT INTO `usuario_reg_admin` (`idADMIN`) VALUES
('julioortiz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_reg_gestor`
--

DROP TABLE IF EXISTS `usuario_reg_gestor`;
CREATE TABLE IF NOT EXISTS `usuario_reg_gestor` (
  `idGESTOR` varchar(10) NOT NULL,
  `idAdmin_reg` varchar(10) NOT NULL,
  `Fecha_reg` date NOT NULL,
  `Hora_reg` time NOT NULL,
  PRIMARY KEY (`idGESTOR`),
  KEY `fk_USUARIO_REG_GESTOR_USUARIO_REG_ADMIN1_idx` (`idAdmin_reg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_reg_gestor`
--

INSERT INTO `usuario_reg_gestor` (`idGESTOR`, `idAdmin_reg`, `Fecha_reg`, `Hora_reg`) VALUES
('vicleo', 'julioortiz', '2019-02-19', '17:03:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_reg_has_evento`
--

DROP TABLE IF EXISTS `usuario_reg_has_evento`;
CREATE TABLE IF NOT EXISTS `usuario_reg_has_evento` (
  `idUsuario_reg` varchar(10) NOT NULL,
  `idEvento` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  PRIMARY KEY (`idUsuario_reg`,`idEvento`),
  KEY `fk_USUARIO_REG_has_EVENTO_EVENTO1_idx` (`idEvento`),
  KEY `fk_USUARIO_REG_has_EVENTO_USUARIO_REG1_idx` (`idUsuario_reg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_reg_has_evento`
--

INSERT INTO `usuario_reg_has_evento` (`idUsuario_reg`, `idEvento`, `Fecha`, `Hora`) VALUES
('euler', '192COnf', '2019-02-21', '13:48:20'),
('euler', 'ConfCom', '2019-02-21', '13:48:24'),
('julioortiz', 'ConfCom', '2019-02-21', '13:44:05');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_lugareseventos`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vista_lugareseventos`;
CREATE TABLE IF NOT EXISTS `vista_lugareseventos` (
`idEvento` varchar(10)
,`Cupo` int(11)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_lugareseventos`
--
DROP TABLE IF EXISTS `vista_lugareseventos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_lugareseventos`  AS  select `evento`.`idEvento` AS `idEvento`,`evento`.`Cupo` AS `Cupo` from `evento` ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `fk_EVENTO_EVENTO_ORGANIZADORES1` FOREIGN KEY (`idOrganizador`) REFERENCES `evento_organizadores` (`idOrganizador`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_EVENTO_EVENTO_TIPO1` FOREIGN KEY (`idTipo`) REFERENCES `evento_tipo` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_EVENTO_LUGAR1` FOREIGN KEY (`idLugar`) REFERENCES `lugar` (`idLugar`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_EVENTO_USUARIO_REG_GESTOR1` FOREIGN KEY (`idGestor_reg`) REFERENCES `usuario_reg_gestor` (`idGESTOR`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `evento_cancelado`
--
ALTER TABLE `evento_cancelado`
  ADD CONSTRAINT `fk_EVENTO_CANCELADO_EVENTO1` FOREIGN KEY (`idEventoCancelado`) REFERENCES `evento` (`idEvento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD CONSTRAINT `fk_LUGAR_USUARIO_REG_ADMIN1` FOREIGN KEY (`idAdmin_reg`) REFERENCES `usuario_reg_admin` (`idADMIN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `organizador_contacto`
--
ALTER TABLE `organizador_contacto`
  ADD CONSTRAINT `fk_EVENTO_CONTACTO_EVENTO_ORGANIZADORES1` FOREIGN KEY (`idOrganizador`) REFERENCES `evento_organizadores` (`idOrganizador`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_reg_admin`
--
ALTER TABLE `usuario_reg_admin`
  ADD CONSTRAINT `fk_USUARIO_REG_ADMIN_USUARIO_REG1` FOREIGN KEY (`idADMIN`) REFERENCES `usuario_reg` (`idUSUARIO_REG`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_reg_gestor`
--
ALTER TABLE `usuario_reg_gestor`
  ADD CONSTRAINT `fk_USUARIO_REG_GESTOR_USUARIO_REG1` FOREIGN KEY (`idGESTOR`) REFERENCES `usuario_reg` (`idUSUARIO_REG`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_USUARIO_REG_GESTOR_USUARIO_REG_ADMIN1` FOREIGN KEY (`idAdmin_reg`) REFERENCES `usuario_reg_admin` (`idADMIN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_reg_has_evento`
--
ALTER TABLE `usuario_reg_has_evento`
  ADD CONSTRAINT `fk_USUARIO_REG_has_EVENTO_EVENTO1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_USUARIO_REG_has_EVENTO_USUARIO_REG1` FOREIGN KEY (`idUsuario_reg`) REFERENCES `usuario_reg` (`idUSUARIO_REG`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
