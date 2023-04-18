-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 18-04-2023 a las 23:59:23
-- Versión del servidor: 10.9.3-MariaDB-log
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `transportecarga`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_aceptar_registro` (`xid_registro` INT(11))  begin
  update registroenvio
  set estaregistro=1
  where id_registro=xid_registro;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_anular_registro` (`xid_registro` INT(11))  begin
  update registroenvio
  set estaregistro=-1
  where id_registro=xid_registro;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_anularenvio` (`xidenvio` INT)  begin
 update enviocarga
set estadoEnvio =0
where idenvio=xidenvio;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_cliente` (IN `xid_cliente` INT)  begin
update cliente
set esta_cliente=0
where id_cliente=xid_cliente;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_conductor` (IN `xid_conductor` INT)  begin
update conductor
set estado=0
where id_conductor=xid_conductor;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_tipov` (`xid_tipo` INT(11))  begin
  update tipo_vehiculo
  set estatipo=0
  where id_tipo=xid_tipo;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_vehiculo` (`xid_vehiculo` INT)  begin
  update vehiculo
  set estavehi=0
  where id_vehiculo=xid_vehiculo;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_cliente` (`xdni_cliente` INT, `xnomb_cliente` VARCHAR(50), `xappa_cliente` VARCHAR(50), `xapma_cliente` VARCHAR(50), `xruc_cliente` VARCHAR(11), `xdire_cliente` VARCHAR(50), `xtelef_cliente` INT, `xcel_cliente` INT)  begin
insert into cliente(dni_cliente, nomb_cliente, appa_cliente, apma_cliente, ruc_cliente, dire_cliente, telef_cliente, cel_cliente, esta_cliente)
values(xdni_cliente, xnomb_cliente, xappa_cliente, xapma_cliente, xruc_cliente, xdire_cliente, xtelef_cliente, xcel_cliente,1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_conductor` (IN `xdni_conductor` INT(8), IN `xnomb_conductor` VARCHAR(50), IN `xapat_conductor` VARCHAR(50), IN `xamat_conductor` VARCHAR(50), IN `xnro_registro` INT(10), IN `xid_vehiculo` INT(10), IN `xbrevete` VARCHAR(11), IN `xsoat` BOOLEAN, IN `xrevision_tecnica` VARCHAR(11))  begin
  insert into conductor(dni_conductor,nomb_conductor,apat_conductor,amat_conductor,nro_registro,id_vehiculo,brevete,soat,revision_tecnica,estado)
  values(xdni_conductor,xnomb_conductor,xapat_conductor,xamat_conductor,xnro_registro,xid_vehiculo,xbrevete,xsoat,xrevision_tecnica,1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_envio` (`xid_cliente` INT, `xid_conductor` INT, `xid_vehiculo` INT, `xOrigen` VARCHAR(100), `xDestino` VARCHAR(100), `xPeso` DECIMAL(10,2), `xDescripcion` VARCHAR(100))  begin
  insert into enviocarga(fechaEnvio,id_cliente,id_conductor,id_vehiculo,origen,destino,Peso,Descripcion,estadoEnvio)
  values(now(),xid_cliente,xid_conductor,xid_vehiculo,xOrigen,xDestino,xPeso,xDescripcion,1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_registro` (`xid_cliente` INT(11), `xdni_cliente` INT(11), `xnomb_cliente` VARCHAR(50), `xappa_cliente` VARCHAR(50), `xapma_cliente` VARCHAR(50), `xcel_cliente` INT(11), `xpeso` DECIMAL(12,2), `xnumero_paquetes` INT(4), `xdescripcion` VARCHAR(150), `xdpto_partida` VARCHAR(20), `xprovincia_partida` VARCHAR(20), `xdistrito_partida` VARCHAR(20), `xdireccion_partida` VARCHAR(20), `xdpto_llegada` VARCHAR(20), `xprovincia_llegada` VARCHAR(20), `xdistrito_llegada` VARCHAR(20), `xdireccion_llegada` VARCHAR(20))  begin
  insert into registroenvio(id_cliente,dni_cliente,nomb_cliente,appa_cliente,apma_cliente,cel_cliente,peso,numero_paquetes,descripcion,dpto_partida,provincia_partida,distrito_partida,direccion_partida,dpto_llegada,provincia_llegada,distrito_llegada,direccion_llegada,estaregistro)
  values(xid_cliente,xdni_cliente,xnomb_cliente,xappa_cliente,xapma_cliente,xcel_cliente,xpeso,xnumero_paquetes,xdescripcion,xdpto_partida,xprovincia_partida,xdistrito_partida,xdireccion_partida,xdpto_llegada,xprovincia_llegada,xdistrito_llegada,xdireccion_llegada,0);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_registroenvio_asig` (`xid_registro` INT(11), `xid_conductor` INT(11), `xfecha_partida` DATETIME)  begin
  insert into registroenvio_asig
  values(xid_registro,xid_conductor,xfecha_partida);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_registronull` (IN `xid_registro` INT(11))  begin
  insert into registroenvio_asig
  values(xid_registro,NULL,NULL,NULL);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_tipov` (`xnomb_tipo` VARCHAR(50))  begin
  insert into tipo_vehiculo(nomb_tipo,estatipo)
  values(xnomb_tipo,1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_vehiculo` (`xplaca` VARCHAR(10), `xnro_serie` VARCHAR(20), `xid_marca` INT(3), `xid_color` INT(3), `xid_tipo` INT(3), `xnro_llantas` INT(2), `xpeso_bruto` DECIMAL(12,2), `xpeso_neto` DECIMAL(12,2), `xpeso_util` DECIMAL(12,2))  begin
  insert into vehiculo(placa,nro_serie,id_marca,id_color,id_tipo,nro_llantas,peso_bruto,peso_neto,peso_util,estavehi)
  values(xplaca,xnro_serie,xid_marca,xid_color,xid_tipo,xnro_llantas,xpeso_bruto,xpeso_neto,xpeso_util,1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_cliente` (`xid_cliente` INT(11), `xdni_cliente` VARCHAR(11), `xnomb_cliente` VARCHAR(50), `xappa_cliente` VARCHAR(50), `xapma_cliente` VARCHAR(50), `xruc_cliente` VARCHAR(11), `xdire_cliente` VARCHAR(50), `xtelef_cliente` INT(11), `xcel_cliente` INT(11))  begin
  update cliente
  set dni_cliente=xdni_cliente,nomb_cliente=xnomb_cliente,appa_cliente=xappa_cliente,apma_cliente=xapma_cliente,ruc_cliente=xruc_cliente,dire_cliente=xdire_cliente,telef_cliente=xtelef_cliente,cel_cliente=xcel_cliente
  where id_cliente=xid_cliente;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_conductor` (IN `xid_conductor` INT(11), IN `xdni_conductor` INT(8), IN `xnomb_conductor` VARCHAR(50), IN `xapat_conductor` VARCHAR(50), IN `xamat_conductor` VARCHAR(50), IN `xnro_registro` INT(10), IN `xid_vehiculo` INT(10), IN `xbrevete` VARCHAR(11), IN `xsoat` TINYINT(4), IN `xrevision_tecnica` VARCHAR(11))  begin
  update conductor
  set dni_conductor=xdni_conductor,nomb_conductor=xnomb_conductor,apat_conductor=xapat_conductor,amat_conductor=xamat_conductor,nro_registro=xnro_registro,id_vehiculo=xid_vehiculo,soat=xsoat,revision_tecnica=xrevision_tecnica
  where id_conductor=xid_conductor;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_registroenvio_asig` (IN `xid_registro` INT(11), IN `xid_conductor` INT(11), IN `xfecha_partida` DATETIME)  begin
  update registroenvio_asig
  set id_conductor=xid_conductor, fecha_partida=xfecha_partida
  where id_registro=xid_registro;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_tipov` (`xid_tipo` INT(11), `xnomb_tipo` VARCHAR(50))  begin
  update tipo_vehiculo
  set nomb_tipo=xnomb_tipo
  where id_tipo=xid_tipo;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_vehiculo` (`xid_vehiculo` INT(11), `xplaca` VARCHAR(10), `xnro_serie` VARCHAR(20), `xid_marca` INT(3), `xid_color` INT(3), `xid_tipo` INT(3), `xnro_llantas` INT(2), `xpeso_bruto` DECIMAL(12,2), `xpeso_neto` DECIMAL(12,2), `xpeso_util` DECIMAL(12,2))  begin
  update vehiculo
  set placa=xplaca,nro_serie=xnro_serie,id_marca=xid_marca,id_color=xid_color,id_tipo=xid_tipo,nro_llantas=xnro_llantas,peso_bruto=xpeso_bruto,peso_neto=xpeso_neto,peso_util=xpeso_util
  where id_vehiculo=xid_vehiculo;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `dni_cliente` int(11) NOT NULL,
  `nomb_cliente` varchar(50) DEFAULT NULL,
  `appa_cliente` varchar(50) DEFAULT NULL,
  `apma_cliente` varchar(50) DEFAULT NULL,
  `ruc_cliente` varchar(11) DEFAULT NULL,
  `dire_cliente` varchar(50) DEFAULT NULL,
  `telef_cliente` int(11) DEFAULT NULL,
  `cel_cliente` int(11) DEFAULT NULL,
  `esta_cliente` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `dni_cliente`, `nomb_cliente`, `appa_cliente`, `apma_cliente`, `ruc_cliente`, `dire_cliente`, `telef_cliente`, `cel_cliente`, `esta_cliente`) VALUES
(1, 32565412, 'Ana', 'Rivera', 'Palacios', 'NO CUENTA', 'Jr Galvez #168', 2358745, 989564662, 0),
(2, 62565412, 'Pedro', 'Vera', 'Solis', '20158963741', 'Grau #155', 2358745, 999321554, 1),
(3, 63552238, 'Alonso', 'Ayala', 'Perez', '12365841235', 'Las Flores #218', 2358745, 989564662, 1),
(4, 66325158, 'Fernanda', 'Caycho', 'Morales', 'NO CUENTA', 'Psj 8 de Julio #125', 2381567, 953687421, 1),
(5, 78960054, 'Maria', 'Diaz', 'Ruiz', 'NO CUENTA', 'Jr Lima #223', 2358745, 989564662, 1),
(6, 96325785, 'Gabriela', 'Lira', 'Lagos', 'NO CUENTA', 'Buena Vista #144', 2358745, 989564662, 1),
(7, 96581287, 'Juan', 'Ramos', 'Sigueñas', '23698745562', 'Enrique Palacios #101', 2358745, 989564662, 0),
(8, 7156545, 'Hugo', 'Grados', 'Grados', '12345678', 'Lima', 945165748, 945781564, 1),
(9, 71563651, 'Darlene', 'Gonzales', 'Quispe', '321321', 'Calle Arias 321', 3772314, 945321145, 1),
(10, 74322341, 'Coneja', 'Torres', 'Colan', '1420', 'Calle Las Orquideas', 923961930, 923961930, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `color_vehiculo`
--

CREATE TABLE `color_vehiculo` (
  `id_color` int(3) NOT NULL,
  `nomb_color` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `color_vehiculo`
--

INSERT INTO `color_vehiculo` (`id_color`, `nomb_color`) VALUES
(1, 'SELECCIONAR'),
(2, 'GRIS'),
(3, 'NEGRO'),
(4, 'VERDE'),
(5, 'AZUL'),
(6, 'BLANCO'),
(7, 'ANARANJADO'),
(8, 'PLATA'),
(9, 'AMARILLO'),
(10, 'BEIGE'),
(11, 'MATIZADO'),
(12, 'MARRÓN'),
(13, 'ROSA'),
(14, 'PÚRPURA'),
(15, 'TURQUESA'),
(16, 'CIAN'),
(17, 'OCRE'),
(18, 'AMBAR'),
(19, 'RUBY'),
(20, 'PERLA'),
(21, 'ESMERALDA'),
(22, 'CAFE'),
(23, 'ROJO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductor`
--

CREATE TABLE `conductor` (
  `id_conductor` int(11) NOT NULL,
  `dni_conductor` int(8) NOT NULL,
  `nomb_conductor` varchar(50) DEFAULT NULL,
  `apat_conductor` varchar(50) DEFAULT NULL,
  `amat_conductor` varchar(50) DEFAULT NULL,
  `nro_registro` int(10) DEFAULT NULL,
  `id_vehiculo` int(10) DEFAULT NULL,
  `brevete` varchar(11) DEFAULT NULL,
  `soat` tinyint(4) DEFAULT NULL,
  `revision_tecnica` varchar(11) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `conductor`
--

INSERT INTO `conductor` (`id_conductor`, `dni_conductor`, `nomb_conductor`, `apat_conductor`, `amat_conductor`, `nro_registro`, `id_vehiculo`, `brevete`, `soat`, `revision_tecnica`, `estado`) VALUES
(11, 64531231, 'Juan', 'Changanaqui', 'Ramirez', 123453, 4, '1235968', -1, 'Bien', 1),
(12, 53726587, 'Jose', 'Jimenez', 'Diaz', 54553, 1, '32323', -1, 'Bien', 1),
(13, 75634257, 'Jose', 'Quispe', 'Toyco', 67, 11, 'C-987654-24', -1, 'Bien', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca_vehiculo`
--

CREATE TABLE `marca_vehiculo` (
  `id_marca` int(11) NOT NULL,
  `nomb_marca` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marca_vehiculo`
--

INSERT INTO `marca_vehiculo` (`id_marca`, `nomb_marca`) VALUES
(1, 'SELECCIONAR'),
(2, 'VOLKSWAGEN'),
(3, 'NISSAN'),
(4, 'JAC'),
(5, 'MATE'),
(6, 'TOYOTA'),
(7, 'ABARTH'),
(8, 'MERCEDES'),
(9, 'ALPINE'),
(10, 'MITSUBISHI'),
(11, 'AUDI'),
(12, 'BENTLEY'),
(13, 'BMW'),
(14, 'BUGATTI'),
(15, 'ISUZU'),
(16, 'CADILLAC'),
(17, 'CATERHAM'),
(18, 'CHEVROLET'),
(19, 'CITROËN'),
(20, 'CUPRA'),
(21, 'DACIA'),
(22, 'DFSK'),
(23, 'VOLVO'),
(24, 'FERRARI'),
(25, 'FIAT'),
(26, 'FORD'),
(27, 'HISPANO SUIZA'),
(28, 'HONDA'),
(29, 'HUMMER'),
(30, 'HYUNDAI'),
(31, 'INEOS'),
(32, 'INFINITI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registroenvio`
--

CREATE TABLE `registroenvio` (
  `id_registro` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `dni_cliente` int(11) DEFAULT NULL,
  `nomb_cliente` varchar(50) DEFAULT NULL,
  `appa_cliente` varchar(50) DEFAULT NULL,
  `apma_cliente` varchar(50) DEFAULT NULL,
  `cel_cliente` int(11) DEFAULT NULL,
  `peso` decimal(12,2) DEFAULT NULL,
  `numero_paquetes` int(4) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `dpto_partida` varchar(20) DEFAULT NULL,
  `provincia_partida` varchar(20) DEFAULT NULL,
  `distrito_partida` varchar(20) DEFAULT NULL,
  `direccion_partida` varchar(20) DEFAULT NULL,
  `dpto_llegada` varchar(20) DEFAULT NULL,
  `provincia_llegada` varchar(20) DEFAULT NULL,
  `distrito_llegada` varchar(20) DEFAULT NULL,
  `direccion_llegada` varchar(20) DEFAULT NULL,
  `estaregistro` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `registroenvio`
--

INSERT INTO `registroenvio` (`id_registro`, `id_cliente`, `dni_cliente`, `nomb_cliente`, `appa_cliente`, `apma_cliente`, `cel_cliente`, `peso`, `numero_paquetes`, `descripcion`, `dpto_partida`, `provincia_partida`, `distrito_partida`, `direccion_partida`, `dpto_llegada`, `provincia_llegada`, `distrito_llegada`, `direccion_llegada`, `estaregistro`) VALUES
(3, 6, 96325785, 'Gabriela', 'Lira', 'Lagos', 989564662, '14224.00', 57, 'Fierros', 'AMAZONAS', 'BAGUA', 'ARAMANGO', 'CALLE ZUÑIGA 321', 'ANCASH', 'ASUNCION', 'CHACAS', 'CALLE ARIAS 452', 1),
(4, 5, 78960054, 'Maria', 'Diaz', 'Ruiz', 989564662, '1300.60', 40, 'Balones de Gas', 'ANCASH', 'AIJA', 'ASD', 'ASDASD', 'AREQUIPA', 'CASTILLA', 'ASD', 'ASDASD', 1),
(5, 3, 63552238, 'Alonso', 'Ayala', 'Perez', 989564662, '4005.60', 22, 'Balones de Gas', 'PUNO', 'ABANCAY', 'DSADSA', 'ASASD', 'APURIMAC', 'ANTABAMBA', 'SDASD', 'ASDDWD', 1),
(6, 2, 62565412, 'Pedro', 'Vera', 'Solis', 999321554, '300.00', 4, 'Fierros', 'ANCASH', 'ASUNCION', 'DSADAS', 'DSADAS', 'APURIMAC', 'ANTABAMBA', 'DAS', 'ASASDASD', 1),
(7, 2, 62565412, 'Pedro', 'Vera', 'Solis', 999321554, '10000.00', 30, 'Fierros', 'ANCASH', 'ASUNCION', 'asd', 'asdasd', 'PIURA', 'PAITA', 'asd', 'asdasd', 1),
(13, 4, 66325158, 'Fernanda', 'Caycho', 'Morales', 953687421, '12000.00', 400, 'Sacos de Harina', 'APURIMAC', 'COTABAMBAS', 'asd', 'asd', 'LA LIBERTAD', 'TRUJILLO', 'asd', 'asd', 1),
(14, 9, 71563651, 'Darlene', 'Gonzales', 'Quispe', 945321145, '24000.00', 500, 'Sacos de Arroz', 'APURIMAC', 'ANTABAMBA', 'ASDA', 'ASD', 'CAJAMARCA', 'HUALGAYOC', 'ASDASD', 'ASDASD', 1),
(15, 8, 7156545, 'hugo', 'grados', 'gradoss', 945781564, '300.00', 12, 'aaaaaaaaaaaaaaaa', 'AYACUCHO', 'PARINACOCHAS', 'aaa', 'aaaaaa', 'LIMA', 'HUAURA', 'HUACHO', 'aaaaaaaaaaaa', 1),
(16, 9, 71563651, 'Darlene', 'Gonzales', 'Quispe', 945321145, '20000.00', 400, 'Sacos de Harina', 'AMAZONAS', 'CONDORCANQUI', 'CONDORCANQUI', 'asd', 'CAJAMARCA', 'HUALGAYOC', 'HUALGAYOC', 'asd', 1),
(17, 2, 62565412, 'Pedro', 'Vera', 'Solis', 999321554, '15000.00', 244, 'Balones de Gas', 'ANCASH', 'BOLOGNESI', 'asd', 'asd', 'AYACUCHO', 'LA MAR', 'asd', 'asd', -1),
(18, 8, 7156545, 'hugo', 'grados', 'gradoss', 945781564, '10000.00', 100, 'Harina de pescado', 'LIMA', 'HUARAL', 'CHANCAY', 'Tu vieja', 'JUNIN', 'CHUPACA', 'asd', 'asd', 1),
(19, 8, 7156545, 'hugo', 'grados', 'gradoss', 945781564, '1000.00', 30, 'Sacos de harina', 'LA LIBERTAD', 'CHEPEN', 'asd', 'asdasdasd', 'AYACUCHO', 'LUCANAS', 'asdsd', 'sdsdsd', 1),
(20, 10, 74322341, 'Coneja', 'Torres', 'Colan', 923961930, '20000.00', 100, 'Sacos de Papa', 'LIMA', 'HUARAL', 'HUARAL', 'Calle las orquideas', 'SAN MARTIN', 'HUALLAGA', 'Lui', 'Calle lui torres', 1),
(21, 9, 71563651, 'Darlene', 'Gonzales', 'Quispe', 945321145, '10000.00', 30, 'Sacos de arroz', 'ANCASH', 'ANTONIO RAIMONDI', 'as', 'asdsd', 'AMAZONAS', 'CONDORCANQUI', 'asdds', 'sdsd', 1),
(22, 5, 78960054, 'Maria', 'Diaz', 'Ruiz', 989564662, '11.00', 32, 'asdasdasdsda', 'APURIMAC', 'ANTABAMBA', 'sdsd', 'sdsdsd', 'ANCASH', 'ANTONIO RAIMONDI', 'sdsd', 'sdds', 1),
(23, 9, 71563651, 'Darlene', 'Gonzales', 'Quispe', 945321145, '20.00', 10, 'asdasdasd', 'AMAZONAS', 'RODRIGUEZ DE MENDOZA', 'sdsd', 'qweqweqwe', 'CAJAMARCA', 'JAEN', 'sdsdds', 'sdsqwe', 1),
(24, 6, 96325785, 'Gabriela', 'Lira', 'Lagos', 989564662, '30000.00', 188, 'asdasda', 'AMAZONAS', 'BONGARA', 'asdssd', 'ssdsdsdsd', 'AREQUIPA', 'CONDESUYOS', 'sdsdsdds', 'sdsdsdsd', 1),
(25, 8, 7156545, 'hugo', 'grados', 'gradoss', 945781564, '4009.00', 233, '	assadsda', 'ANCASH', 'ASUNCION', 'sdsd', 'sdds', 'AYACUCHO', 'PAUCAR DEL SARA SARA', 'sd', 'dsd', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registroenvio_asig`
--

CREATE TABLE `registroenvio_asig` (
  `id_registro` int(11) DEFAULT NULL,
  `id_conductor` int(11) DEFAULT NULL,
  `fecha_partida` datetime DEFAULT NULL,
  `fecha_llegada` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `registroenvio_asig`
--

INSERT INTO `registroenvio_asig` (`id_registro`, `id_conductor`, `fecha_partida`, `fecha_llegada`) VALUES
(3, 10, '2021-06-13 00:00:00', '2023-04-12 00:00:00'),
(4, 5, '2021-06-14 00:00:00', NULL),
(5, 4, '2021-06-19 00:00:00', '2023-04-06 00:00:00'),
(7, 5, '2021-06-10 00:00:00', NULL),
(6, 6, '2021-06-07 00:00:00', '2021-06-01 00:00:00'),
(13, 8, '2021-06-14 00:00:00', NULL),
(14, 0, '2023-04-18 00:00:00', NULL),
(15, 10, '2021-06-01 00:00:00', '2021-06-15 00:00:00'),
(16, NULL, NULL, '2023-04-22 00:00:00'),
(17, NULL, NULL, NULL),
(18, 0, '2021-10-04 00:00:00', '2021-10-06 00:00:00'),
(19, 0, '2022-02-17 00:00:00', '2022-02-20 00:00:00'),
(20, 0, '2022-05-20 00:00:00', '2022-05-21 00:00:00'),
(21, 11, '2023-04-05 00:00:00', NULL),
(22, 0, '2023-04-06 00:00:00', '2023-04-04 00:00:00'),
(23, 0, '2023-04-03 00:00:00', '2023-04-28 00:00:00'),
(24, NULL, NULL, '2023-04-06 00:00:00'),
(25, 12, '2023-04-03 00:00:00', '2023-04-22 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculo`
--

CREATE TABLE `tipo_vehiculo` (
  `id_tipo` int(11) NOT NULL,
  `nomb_tipo` varchar(50) DEFAULT NULL,
  `estatipo` tinyint(3) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_vehiculo`
--

INSERT INTO `tipo_vehiculo` (`id_tipo`, `nomb_tipo`, `estatipo`) VALUES
(1, 'SELECCIONAR', 1),
(2, 'SEMI REMOLQUE', 1),
(3, 'CILINDRA DE GAS', 1),
(4, 'CAMION RIGIDO', 1),
(5, 'REMOLQUE CARGA ANCHA', 1),
(6, 'REMOLQUE LOWBOY', 1),
(7, 'REMOLQUE REFRIGERADO', 1),
(8, 'CAMION ELEVADOR', 1),
(9, 'CAMION PLATAFORMA', 1),
(10, 'REMOLQUE', 1),
(11, 'PRUEBA123', 0),
(12, 'PRUEBAA', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `clave`) VALUES
(1, 'admin', '123'),
(2, 'hugo', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id_vehiculo` int(11) NOT NULL,
  `placa` varchar(10) DEFAULT NULL,
  `nro_serie` varchar(20) DEFAULT NULL,
  `id_marca` int(3) DEFAULT NULL,
  `id_color` int(3) DEFAULT NULL,
  `id_tipo` int(3) DEFAULT NULL,
  `nro_llantas` int(2) DEFAULT NULL,
  `peso_bruto` decimal(12,2) DEFAULT NULL,
  `peso_neto` decimal(12,2) DEFAULT NULL,
  `peso_util` decimal(12,2) DEFAULT NULL,
  `estavehi` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id_vehiculo`, `placa`, `nro_serie`, `id_marca`, `id_color`, `id_tipo`, `nro_llantas`, `peso_bruto`, `peso_neto`, `peso_util`, `estavehi`) VALUES
(1, 'ABC-321', '1HGBH31JXMN109186', 21, 6, 6, 10, '10200.00', '9200.00', '9000.00', 1),
(2, 'GBA-241', '2ASG312CVQL149164', 27, 12, 8, 6, '6500.00', '5800.00', '5100.00', 1),
(4, 'G2A-3R1', '4BFG313CVQL149154', 2, 4, 8, 22, '14000.00', '13500.00', '13000.00', 1),
(6, 'A2A-4F3', '32SAFT5467YIU2145', 3, 2, 4, 22, '14000.00', '13000.00', '12000.00', 1),
(7, 'A2A-4F3', '32SAFT5467YIU2145', 3, 2, 4, 22, '14000.00', '13000.00', '12000.00', 0),
(8, 'A2A-4FS', '32SAFT5467YIU2143', 3, 2, 4, 22, '14000.00', '13000.00', '12000.00', 0),
(9, 'A4A-325', '1234351231', 2, 4, 4, 22, '1000.00', '900.00', '100.00', 0),
(10, 'A6B-321', '1AB53D6TYU14ER5T6', 16, 10, 9, 12, '15000.00', '14700.00', '14100.00', 1),
(11, 'ERT-421', '34RT5Y75FGRE2463', 4, 5, 5, 12, '29000.00', '28200.00', '30000.00', 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_cliente`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_cliente` (
`id_cliente` int(11)
,`dni_cliente` int(11)
,`nomb_cliente` varchar(50)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`ruc_cliente` varchar(11)
,`dire_cliente` varchar(50)
,`telef_cliente` int(11)
,`cel_cliente` int(11)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_conductor`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_conductor` (
`ID_CONDUCTOR` int(11)
,`DNI_CONDUCTOR` int(8)
,`NOMBRE_CONDUCTOR` varchar(50)
,`APAT_CONDUCTOR` varchar(50)
,`AMAT_CONDUCTOR` varchar(50)
,`NRO_REGISTRO` int(10)
,`VEHICULO_ASIGNADO` varchar(10)
,`BREVETE` varchar(11)
,`SOAT` tinyint(4)
,`REVISION_TECNICA` varchar(11)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_conductor_activo`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_conductor_activo` (
`id_conductor` int(11)
,`dni_conductor` int(8)
,`nomb_conductor` varchar(50)
,`apat_conductor` varchar(50)
,`amat_conductor` varchar(50)
,`nro_registro` int(10)
,`id_vehiculo` int(10)
,`brevete` varchar(11)
,`soat` tinyint(4)
,`revision_tecnica` varchar(11)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_conductor_inactivo`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_conductor_inactivo` (
`id_conductor` int(11)
,`dni_conductor` int(8)
,`nomb_conductor` varchar(50)
,`apat_conductor` varchar(50)
,`amat_conductor` varchar(50)
,`nro_registro` int(10)
,`id_vehiculo` int(10)
,`brevete` varchar(11)
,`soat` tinyint(4)
,`revision_tecnica` varchar(11)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_conductor_nombre`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_conductor_nombre` (
`id_conductor` int(11)
,`concat(nomb_conductor,' ',apat_conductor,' ',amat_conductor)` varchar(152)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_envio_final`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_envio_final` (
`id_registro` int(11)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`peso` decimal(12,2)
,`numero_paquetes` int(4)
,`descripcion` varchar(150)
,`dpto_partida` varchar(20)
,`dpto_llegada` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_registros_aceptados`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_registros_aceptados` (
`id_registro` int(11)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`peso` decimal(12,2)
,`numero_paquetes` int(4)
,`descripcion` varchar(150)
,`dpto_partida` varchar(20)
,`dpto_llegada` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_registros_aceptados_conductor`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_registros_aceptados_conductor` (
`id_registro` int(11)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`peso` decimal(12,2)
,`numero_paquetes` int(4)
,`descripcion` varchar(150)
,`dpto_partida` varchar(20)
,`dpto_llegada` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_registros_aceptados_general`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_registros_aceptados_general` (
`id_registro` int(11)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`peso` decimal(12,2)
,`numero_paquetes` int(4)
,`descripcion` varchar(150)
,`dpto_partida` varchar(20)
,`dpto_llegada` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_registros_anulados`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_registros_anulados` (
`id_registro` int(11)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`peso` decimal(12,2)
,`numero_paquetes` int(4)
,`descripcion` varchar(150)
,`dpto_partida` varchar(20)
,`dpto_llegada` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_registros_pendientes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_registros_pendientes` (
`id_registro` int(11)
,`appa_cliente` varchar(50)
,`apma_cliente` varchar(50)
,`peso` decimal(12,2)
,`numero_paquetes` int(4)
,`descripcion` varchar(150)
,`dpto_partida` varchar(20)
,`dpto_llegada` varchar(20)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_tipovehiculo`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_tipovehiculo` (
`id_tipo` int(11)
,`nomb_tipo` varchar(50)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_vehiculo`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_vehiculo` (
`id_vehiculo` int(11)
,`placa` varchar(10)
,`nro_serie` varchar(20)
,`nomb_marca` varchar(50)
,`nomb_color` varchar(20)
,`nomb_tipo` varchar(50)
,`nro_llantas` int(2)
,`peso_bruto` decimal(12,2)
,`peso_neto` decimal(12,2)
,`peso_util` decimal(12,2)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `v_cliente`
--
DROP TABLE IF EXISTS `v_cliente`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_cliente`  AS  select `cliente`.`id_cliente` AS `id_cliente`,`cliente`.`dni_cliente` AS `dni_cliente`,`cliente`.`nomb_cliente` AS `nomb_cliente`,`cliente`.`appa_cliente` AS `appa_cliente`,`cliente`.`apma_cliente` AS `apma_cliente`,`cliente`.`ruc_cliente` AS `ruc_cliente`,`cliente`.`dire_cliente` AS `dire_cliente`,`cliente`.`telef_cliente` AS `telef_cliente`,`cliente`.`cel_cliente` AS `cel_cliente` from `cliente` where `cliente`.`esta_cliente` = 1 order by 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_conductor`
--
DROP TABLE IF EXISTS `v_conductor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_conductor`  AS  select `c`.`id_conductor` AS `ID_CONDUCTOR`,`c`.`dni_conductor` AS `DNI_CONDUCTOR`,`c`.`nomb_conductor` AS `NOMBRE_CONDUCTOR`,`c`.`apat_conductor` AS `APAT_CONDUCTOR`,`c`.`amat_conductor` AS `AMAT_CONDUCTOR`,`c`.`nro_registro` AS `NRO_REGISTRO`,`v`.`placa` AS `VEHICULO_ASIGNADO`,`c`.`brevete` AS `BREVETE`,`c`.`soat` AS `SOAT`,`c`.`revision_tecnica` AS `REVISION_TECNICA` from (`conductor` `c` join `vehiculo` `v` on(`c`.`id_vehiculo` = `v`.`id_vehiculo`)) where `c`.`estado` = 1 order by '' ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_conductor_activo`
--
DROP TABLE IF EXISTS `v_conductor_activo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_conductor_activo`  AS  select `conductor`.`id_conductor` AS `id_conductor`,`conductor`.`dni_conductor` AS `dni_conductor`,`conductor`.`nomb_conductor` AS `nomb_conductor`,`conductor`.`apat_conductor` AS `apat_conductor`,`conductor`.`amat_conductor` AS `amat_conductor`,`conductor`.`nro_registro` AS `nro_registro`,`conductor`.`id_vehiculo` AS `id_vehiculo`,`conductor`.`brevete` AS `brevete`,`conductor`.`soat` AS `soat`,`conductor`.`revision_tecnica` AS `revision_tecnica` from `conductor` where `conductor`.`estado` = 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_conductor_inactivo`
--
DROP TABLE IF EXISTS `v_conductor_inactivo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_conductor_inactivo`  AS  select `conductor`.`id_conductor` AS `id_conductor`,`conductor`.`dni_conductor` AS `dni_conductor`,`conductor`.`nomb_conductor` AS `nomb_conductor`,`conductor`.`apat_conductor` AS `apat_conductor`,`conductor`.`amat_conductor` AS `amat_conductor`,`conductor`.`nro_registro` AS `nro_registro`,`conductor`.`id_vehiculo` AS `id_vehiculo`,`conductor`.`brevete` AS `brevete`,`conductor`.`soat` AS `soat`,`conductor`.`revision_tecnica` AS `revision_tecnica` from `conductor` where `conductor`.`estado` = 0 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_conductor_nombre`
--
DROP TABLE IF EXISTS `v_conductor_nombre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_conductor_nombre`  AS  select `conductor`.`id_conductor` AS `id_conductor`,concat(`conductor`.`nomb_conductor`,' ',`conductor`.`apat_conductor`,' ',`conductor`.`amat_conductor`) AS `concat(nomb_conductor,' ',apat_conductor,' ',amat_conductor)` from `conductor` where `conductor`.`estado` = 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_envio_final`
--
DROP TABLE IF EXISTS `v_envio_final`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_envio_final`  AS  select `r`.`id_registro` AS `id_registro`,`r`.`appa_cliente` AS `appa_cliente`,`r`.`apma_cliente` AS `apma_cliente`,`r`.`peso` AS `peso`,`r`.`numero_paquetes` AS `numero_paquetes`,`r`.`descripcion` AS `descripcion`,`r`.`dpto_partida` AS `dpto_partida`,`r`.`dpto_llegada` AS `dpto_llegada` from (`registroenvio` `r` join `registroenvio_asig` `a` on(`r`.`id_registro` = `a`.`id_registro`)) where `r`.`estaregistro` = 1 and `a`.`fecha_llegada` is null ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_registros_aceptados`
--
DROP TABLE IF EXISTS `v_registros_aceptados`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_registros_aceptados`  AS  select `r`.`id_registro` AS `id_registro`,`r`.`appa_cliente` AS `appa_cliente`,`r`.`apma_cliente` AS `apma_cliente`,`r`.`peso` AS `peso`,`r`.`numero_paquetes` AS `numero_paquetes`,`r`.`descripcion` AS `descripcion`,`r`.`dpto_partida` AS `dpto_partida`,`r`.`dpto_llegada` AS `dpto_llegada` from (`registroenvio` `r` join `registroenvio_asig` `a` on(`r`.`id_registro` = `a`.`id_registro`)) where `r`.`estaregistro` = 1 and `a`.`id_conductor` is null order by 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_registros_aceptados_conductor`
--
DROP TABLE IF EXISTS `v_registros_aceptados_conductor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_registros_aceptados_conductor`  AS  select `r`.`id_registro` AS `id_registro`,`r`.`appa_cliente` AS `appa_cliente`,`r`.`apma_cliente` AS `apma_cliente`,`r`.`peso` AS `peso`,`r`.`numero_paquetes` AS `numero_paquetes`,`r`.`descripcion` AS `descripcion`,`r`.`dpto_partida` AS `dpto_partida`,`r`.`dpto_llegada` AS `dpto_llegada` from (`registroenvio` `r` join `registroenvio_asig` `a` on(`r`.`id_registro` = `a`.`id_registro`)) where `r`.`estaregistro` = 1 and `a`.`id_conductor` is not null order by 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_registros_aceptados_general`
--
DROP TABLE IF EXISTS `v_registros_aceptados_general`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_registros_aceptados_general`  AS  select `registroenvio`.`id_registro` AS `id_registro`,`registroenvio`.`appa_cliente` AS `appa_cliente`,`registroenvio`.`apma_cliente` AS `apma_cliente`,`registroenvio`.`peso` AS `peso`,`registroenvio`.`numero_paquetes` AS `numero_paquetes`,`registroenvio`.`descripcion` AS `descripcion`,`registroenvio`.`dpto_partida` AS `dpto_partida`,`registroenvio`.`dpto_llegada` AS `dpto_llegada` from `registroenvio` where `registroenvio`.`estaregistro` = 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_registros_anulados`
--
DROP TABLE IF EXISTS `v_registros_anulados`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_registros_anulados`  AS  select `registroenvio`.`id_registro` AS `id_registro`,`registroenvio`.`appa_cliente` AS `appa_cliente`,`registroenvio`.`apma_cliente` AS `apma_cliente`,`registroenvio`.`peso` AS `peso`,`registroenvio`.`numero_paquetes` AS `numero_paquetes`,`registroenvio`.`descripcion` AS `descripcion`,`registroenvio`.`dpto_partida` AS `dpto_partida`,`registroenvio`.`dpto_llegada` AS `dpto_llegada` from `registroenvio` where `registroenvio`.`estaregistro` = -1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_registros_pendientes`
--
DROP TABLE IF EXISTS `v_registros_pendientes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_registros_pendientes`  AS  select `registroenvio`.`id_registro` AS `id_registro`,`registroenvio`.`appa_cliente` AS `appa_cliente`,`registroenvio`.`apma_cliente` AS `apma_cliente`,`registroenvio`.`peso` AS `peso`,`registroenvio`.`numero_paquetes` AS `numero_paquetes`,`registroenvio`.`descripcion` AS `descripcion`,`registroenvio`.`dpto_partida` AS `dpto_partida`,`registroenvio`.`dpto_llegada` AS `dpto_llegada` from `registroenvio` where `registroenvio`.`estaregistro` = 0 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_tipovehiculo`
--
DROP TABLE IF EXISTS `v_tipovehiculo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_tipovehiculo`  AS  select `v`.`id_tipo` AS `id_tipo`,`v`.`nomb_tipo` AS `nomb_tipo` from `tipo_vehiculo` `v` where `v`.`estatipo` = 1 order by 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_vehiculo`
--
DROP TABLE IF EXISTS `v_vehiculo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_vehiculo`  AS  select `v`.`id_vehiculo` AS `id_vehiculo`,`v`.`placa` AS `placa`,`v`.`nro_serie` AS `nro_serie`,`m`.`nomb_marca` AS `nomb_marca`,`c`.`nomb_color` AS `nomb_color`,`t`.`nomb_tipo` AS `nomb_tipo`,`v`.`nro_llantas` AS `nro_llantas`,`v`.`peso_bruto` AS `peso_bruto`,`v`.`peso_neto` AS `peso_neto`,`v`.`peso_util` AS `peso_util` from (((`vehiculo` `v` join `marca_vehiculo` `m` on(`v`.`id_marca` = `m`.`id_marca`)) join `color_vehiculo` `c` on(`v`.`id_color` = `c`.`id_color`)) join `tipo_vehiculo` `t` on(`v`.`id_tipo` = `t`.`id_tipo`)) where `v`.`estavehi` = 1 order by 1 ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `color_vehiculo`
--
ALTER TABLE `color_vehiculo`
  ADD PRIMARY KEY (`id_color`);

--
-- Indices de la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD PRIMARY KEY (`id_conductor`);

--
-- Indices de la tabla `marca_vehiculo`
--
ALTER TABLE `marca_vehiculo`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indices de la tabla `registroenvio`
--
ALTER TABLE `registroenvio`
  ADD PRIMARY KEY (`id_registro`),
  ADD KEY `fk_cliente` (`id_cliente`);

--
-- Indices de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id_vehiculo`),
  ADD KEY `fk_placa` (`placa`),
  ADD KEY `fk_marca` (`id_marca`) USING BTREE,
  ADD KEY `fk_tipo` (`id_tipo`),
  ADD KEY `fk_color` (`id_color`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `color_vehiculo`
--
ALTER TABLE `color_vehiculo`
  MODIFY `id_color` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `conductor`
--
ALTER TABLE `conductor`
  MODIFY `id_conductor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `marca_vehiculo`
--
ALTER TABLE `marca_vehiculo`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `registroenvio`
--
ALTER TABLE `registroenvio`
  MODIFY `id_registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `fk_color` FOREIGN KEY (`id_color`) REFERENCES `color_vehiculo` (`id_color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca_vehiculo` (`id_marca`),
  ADD CONSTRAINT `fk_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_vehiculo` (`id_tipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
