-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.4-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando datos para la tabla db_microservicios_examenes.alumnos: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO alumnos (id, apellido, create_at, email, nombre, foto) VALUES
	(1, 'Guzman', '2020-11-01 14:43:35.000000', 'andres@mail.com', 'Andres Jose', NULL),
	(2, 'Doe', '2020-11-01 14:44:02.000000', 'john@gmail.com', 'John', NULL),
	(3, 'Doe', '2020-11-01 15:16:25.000000', 'jose@mail.com', 'Jose', NULL),
	(4, 'Garcia', '2020-11-07 00:09:09.000000', 'pepa@mail.com', 'Pepa', NULL),
	(5, 'Mena', '2020-11-07 00:09:35.000000', 'lalo@mail.com', 'Lalo', NULL),
	(6, 'Fernandez', '2020-11-07 00:09:51.000000', 'pepe@mail.com', 'Pepe', NULL),
	(7, 'Gonzales', '2020-11-07 00:10:10.000000', 'bea@mail.com', 'Bea', NULL),
	(8, 'Martinez', '2020-11-07 00:10:24.000000', 'luci@mail.com', 'Luci', NULL),
	(9, 'Rodriguez', '2020-11-07 00:10:36.000000', 'pato@mail.com', 'Pato', NULL),
    (10, 'Perez', '2020-11-07 00:59:55.000000', 'jano@mail.com', 'Jano', NULL);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
