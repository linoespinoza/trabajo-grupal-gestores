SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `gestioninnovacion` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gestioninnovacion` ;

-- -----------------------------------------------------
-- Table `gestioninnovacion`.`PLAN_TARIFARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`PLAN_TARIFARIO` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`PLAN_TARIFARIO` (
  `Co_Plan_Tarifario` INT NOT NULL AUTO_INCREMENT COMMENT 'Código de Plan Tarifario. Es Correlativo.',
  `No_Plan_Tarifario` VARCHAR(45) NOT NULL COMMENT 'Nombre de Plan Tarifario.',
  `Ss_Precio_Servicio` DECIMAL(5,2) NOT NULL COMMENT 'Precio Fijo del Servicio.',
  `Ss_Precio_Tarifa` DECIMAL(4,2) NOT NULL COMMENT 'Precio de Tarifa por Idea.',
  PRIMARY KEY (`Co_Plan_Tarifario`),
  UNIQUE INDEX `No_Plan_Tarifario_UNIQUE` (`No_Plan_Tarifario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`CENTRO_FORMACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`CENTRO_FORMACION` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`CENTRO_FORMACION` (
  `Co_Centro_Formacion` VARCHAR(11) NOT NULL COMMENT 'Código de Centro de Formación (Número de Ruc).',
  `No_Centro_Formacion` VARCHAR(45) NOT NULL COMMENT 'Nombre de Centro de Formación.',
  `Co_Tipo_Centro_Formacion` CHAR(3) NOT NULL COMMENT 'Código de Tipo de Centro de Formación.\nValores:\nUNI: Universida' /* comment truncated */ /*.
INS: Instituto.*/,
  `Tx_Url` VARCHAR(45) NOT NULL COMMENT 'Url de Centro de Formación.',
  `Tx_Logo` VARCHAR(45) NOT NULL COMMENT 'Ruta de Logo de Centro de Formación.',
  `Co_Plan_Tarifario` INT NOT NULL COMMENT 'Código de Plan Tarifario.',
  PRIMARY KEY (`Co_Centro_Formacion`),
  UNIQUE INDEX `No_Centro_Formacion_UNIQUE` (`No_Centro_Formacion` ASC),
  UNIQUE INDEX `Tx_Url_UNIQUE` (`Tx_Url` ASC),
  INDEX `fk_CENTRO_FORMACION_PLAN_TARIFARIO1_idx` (`Co_Plan_Tarifario` ASC),
  CONSTRAINT `fk_CENTRO_FORMACION_PLAN_TARIFARIO1`
    FOREIGN KEY (`Co_Plan_Tarifario`)
    REFERENCES `gestioninnovacion`.`PLAN_TARIFARIO` (`Co_Plan_Tarifario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`USUARIO` (
  `Co_Usuario` INT NOT NULL AUTO_INCREMENT COMMENT 'Código de Usuario. Es correlativo.',
  `No_Usuario` VARCHAR(20) NOT NULL COMMENT 'Nombre de Usuario.',
  `No_Ape_Paterno` VARCHAR(20) NOT NULL COMMENT 'Apellido Paterno de Usuario.',
  `No_Ape_Materno` VARCHAR(20) NOT NULL COMMENT 'Apellido Materno de Usuario.',
  `Fl_Sexo` CHAR(1) NOT NULL COMMENT 'Sexo de Usuario.\nValores:\nF: Femenino.' /* comment truncated */ /*M: Masculino.*/,
  `Co_Tipo_Documento` CHAR(3) NOT NULL COMMENT 'Código de Tipo de Documento.\nValores:\nDNI: DNI. Longitud: 8. Tipo: Numérico.\nCEX: Carnet de Extranjería. Longitud: 12. Tipo: Alfanumérico.\nRUC: RUC. Longitud: 11. Tipo: Numérico.\nPAS: Pasaporte' /* comment truncated */ /*. Longitud: 12. Tipo: Alfanumérico.
PNA: Partida de Nacimiento. Longitud: 15. Tipo: Numérico.*/,
  `Nu_Documento` VARCHAR(15) NOT NULL COMMENT 'Número de Documento de Usuario.',
  `Tx_Email` VARCHAR(45) NOT NULL COMMENT 'E-mail de Usuario.',
  `Nu_Celular` VARCHAR(9) NOT NULL COMMENT 'Número de Celular de Usuario.',
  `Tx_Contrasenia` VARCHAR(12) NOT NULL COMMENT 'Contraseña de Usuario.',
  `Co_Tipo_Usuario` CHAR(3) NOT NULL COMMENT 'Código de Tipo de Usuario.\nValores:\nEST: Estudiante.\nDOC: Docente.\nEVA: Evaluador' /* comment truncated */ /*
ADM: Administrador.*/,
  `Co_Centro_Formacion` VARCHAR(11) NULL COMMENT 'Código de Centro de Formación (Número de Ruc).',
  PRIMARY KEY (`Co_Usuario`),
  UNIQUE INDEX `Tx_Email_UNIQUE` (`Tx_Email` ASC),
  UNIQUE INDEX `Nu_Documento_UNIQUE` (`Nu_Documento` ASC),
  INDEX `fk_USUARIO_CENTRO_FORMACION1_idx` (`Co_Centro_Formacion` ASC),
  CONSTRAINT `fk_USUARIO_CENTRO_FORMACION1`
    FOREIGN KEY (`Co_Centro_Formacion`)
    REFERENCES `gestioninnovacion`.`CENTRO_FORMACION` (`Co_Centro_Formacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`IDEA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`IDEA` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`IDEA` (
  `Co_Idea` INT NOT NULL AUTO_INCREMENT COMMENT 'Código de Idea. Es correlativo.',
  `No_Titulo` VARCHAR(45) NOT NULL COMMENT 'Título de Idea.',
  `Tx_Descripcion` VARCHAR(200) NOT NULL COMMENT 'Descripción de Idea.',
  `Tx_Palabras_Clave` VARCHAR(83) NOT NULL COMMENT 'Palabras Clave de Idea.\nValores:' /* comment truncated */ /*Siempre son cuatro palabras clave separadas por comas.*/,
  `Tx_Archivo` VARCHAR(45) NULL COMMENT 'Ruta de Archivo de Idea.',
  `Co_Estudiante` INT NOT NULL COMMENT 'Código de Usuario Estudiante.',
  `Co_Estado` CHAR(3) NOT NULL COMMENT 'Código de Estado de Idea.\nValores:\nCRE: Creada.\nPUB: Publicada.\nAPR: Aprobada' /* comment truncated */ /*
REC: Rechazada.*/,
  `Fe_Creacion` DATETIME NOT NULL COMMENT 'Fecha de Creación de Idea.\nValores' /* comment truncated */ /*
Debe estar en formato fecha y hora (dd/MM/yyyy HH:mm:ss).*/,
  `Fe_Publicacion` DATETIME NULL COMMENT 'Fecha de Publicación de Idea.\nValores' /* comment truncated */ /*
Debe estar en formato fecha y hora (dd/MM/yyyy HH:mm:ss).*/,
  `Co_Asesor` INT NULL COMMENT 'Código de Usuario Asesor.',
  PRIMARY KEY (`Co_Idea`),
  INDEX `fk_IDEA_USUARIO1_idx` (`Co_Estudiante` ASC),
  INDEX `fk_IDEA_USUARIO2_idx` (`Co_Asesor` ASC),
  CONSTRAINT `fk_IDEA_USUARIO1`
    FOREIGN KEY (`Co_Estudiante`)
    REFERENCES `gestioninnovacion`.`USUARIO` (`Co_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDEA_USUARIO2`
    FOREIGN KEY (`Co_Asesor`)
    REFERENCES `gestioninnovacion`.`USUARIO` (`Co_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`USUARIO_PERMITIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`USUARIO_PERMITIDO` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`USUARIO_PERMITIDO` (
  `Co_Usuario` INT NOT NULL COMMENT 'Código de Usuario.',
  `Co_Idea` INT NOT NULL COMMENT 'Código de Idea.',
  `Qt_Puntaje` INT NOT NULL COMMENT 'Puntaje de Idea.\nValores:' /* comment truncated */ /*Del 1 al 5. Por defecto debe ser 0.*/,
  PRIMARY KEY (`Co_Usuario`, `Co_Idea`),
  INDEX `fk_USUARIO_PERMITIDO_IDEA1_idx` (`Co_Idea` ASC),
  CONSTRAINT `fk_USUARIO_PERMITIDO_USUARIO1`
    FOREIGN KEY (`Co_Usuario`)
    REFERENCES `gestioninnovacion`.`USUARIO` (`Co_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_PERMITIDO_IDEA1`
    FOREIGN KEY (`Co_Idea`)
    REFERENCES `gestioninnovacion`.`IDEA` (`Co_Idea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`REUNION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`REUNION` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`REUNION` (
  `Co_Reunion` INT NOT NULL AUTO_INCREMENT COMMENT 'Código de Reunión. Es correlativo.',
  `Co_Idea` INT NOT NULL COMMENT 'Código de Idea.',
  `Fe_Reunion` DATETIME NOT NULL COMMENT 'Fecha de Reunión.\nValores:' /* comment truncated */ /*Debe estar en formato fecha (dd/MM/yyyy HH:mm:ss).*/,
  `Tx_Observacion` VARCHAR(200) NOT NULL COMMENT 'Observación de Reunión.',
  `Co_Tipo_Calificacion` CHAR(3) NOT NULL COMMENT 'Código de Tipo de Calificación.\nValores:\nBUE: Bueno.\nMED: Medi' /* comment truncated */ /*.
MEJ: Mejorar.*/,
  PRIMARY KEY (`Co_Reunion`),
  INDEX `fk_REUNION_IDEA1_idx` (`Co_Idea` ASC),
  CONSTRAINT `fk_REUNION_IDEA1`
    FOREIGN KEY (`Co_Idea`)
    REFERENCES `gestioninnovacion`.`IDEA` (`Co_Idea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`REPORTE_PAGO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`REPORTE_PAGO` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`REPORTE_PAGO` (
  `Fe_Anio_Pago` INT NOT NULL COMMENT 'Año de Pago.',
  `Fe_Mes_Pago` VARCHAR(10) NOT NULL COMMENT 'Mes de Pago.',
  `Co_Centro_Formacion` VARCHAR(11) NOT NULL COMMENT 'Código de Centro de Formación (Número de Ruc).',
  `Co_Plan_Tarifario` INT NOT NULL COMMENT 'Código de Plan Tarifario.',
  `Qt_Ideas` INT NOT NULL COMMENT 'Cantidad de Ideas por Mes.',
  `Ss_Monto_Mensual` DECIMAL(7,2) NOT NULL COMMENT 'Monto Mensual de Pago.',
  INDEX `fk_REPORTE_PAGO_PLAN_TARIFARIO1_idx` (`Co_Plan_Tarifario` ASC),
  INDEX `fk_REPORTE_PAGO_CENTRO_FORMACION1_idx` (`Co_Centro_Formacion` ASC),
  PRIMARY KEY (`Fe_Anio_Pago`, `Fe_Mes_Pago`, `Co_Centro_Formacion`),
  CONSTRAINT `fk_REPORTE_PAGO_PLAN_TARIFARIO1`
    FOREIGN KEY (`Co_Plan_Tarifario`)
    REFERENCES `gestioninnovacion`.`PLAN_TARIFARIO` (`Co_Plan_Tarifario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REPORTE_PAGO_CENTRO_FORMACION1`
    FOREIGN KEY (`Co_Centro_Formacion`)
    REFERENCES `gestioninnovacion`.`CENTRO_FORMACION` (`Co_Centro_Formacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestioninnovacion`.`DISCUCION_IDEA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestioninnovacion`.`DISCUCION_IDEA` ;

CREATE TABLE IF NOT EXISTS `gestioninnovacion`.`DISCUCION_IDEA` (
  `Co_Discucion` INT NOT NULL AUTO_INCREMENT COMMENT 'Código de Discución de Idea. Es correlativo.',
  `Co_Idea` INT NOT NULL COMMENT 'Código de Idea.',
  `Co_Usuario` INT NOT NULL COMMENT 'Código de Usuario.',
  `Tx_Comentario` VARCHAR(200) NOT NULL COMMENT 'Comentario acerca de la Idea.',
  PRIMARY KEY (`Co_Discucion`),
  INDEX `fk_DISCUCION_IDEA_USUARIO_PERMITIDO_idx` (`Co_Idea` ASC, `Co_Usuario` ASC),
  CONSTRAINT `fk_DISCUCION_IDEA_USUARIO_PERMITIDO`
    FOREIGN KEY (`Co_Idea` , `Co_Usuario`)
    REFERENCES `gestioninnovacion`.`USUARIO_PERMITIDO` (`Co_Idea` , `Co_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;