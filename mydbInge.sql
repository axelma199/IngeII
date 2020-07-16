-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydbInge
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydbInge` ;

-- -----------------------------------------------------
-- Schema mydbInge
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydbInge` DEFAULT CHARACTER SET utf8 ;
USE `mydbInge` ;

-- -----------------------------------------------------
-- Table `mydbInge`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Usuario` (
  `Pk_IdUsuario` INT NOT NULL AUTO_INCREMENT,
  `Usuario` VARCHAR(25) NOT NULL,
  `Uk_Email` VARCHAR(30) NOT NULL,
  `Password_Sha512` VARCHAR(150) NOT NULL,
  `Password_Bcrypt` VARCHAR(150) NOT NULL,
  `Tipo` INT NOT NULL,
  `Fecha_Creacion` DATE NOT NULL,
  `Fecha_Modificacion` DATE NULL,
  `Ultimo_Usuario` INT NULL,
  `estado` INT NOT NULL,
  `codigoConfirmacion` VARCHAR(100) NULL,
  PRIMARY KEY (`Pk_IdUsuario`),
  UNIQUE INDEX `U_Email_UNIQUE` (`Uk_Email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Telefonos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Telefonos` (
  `idTelefonos` INT NOT NULL,
  `Habitacion` VARCHAR(8) NULL,
  `Celular` VARCHAR(8) NULL,
  `Trabajo` VARCHAR(8) NULL,
  PRIMARY KEY (`idTelefonos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `Provincia` VARCHAR(25) NOT NULL,
  `Canton` VARCHAR(25) NOT NULL,
  `Distrito` VARCHAR(30) NOT NULL,
  `tipo` VARCHAR(9) NOT NULL,
  `OtrasSenas` VARCHAR(255) NULL,
  PRIMARY KEY (`idDireccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Salud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Salud` (
  `idSalud` INT NOT NULL,
  `Enfermedades` VARCHAR(255) NULL,
  `Alergias` VARCHAR(255) NULL,
  `Lesiones` VARCHAR(255) NULL,
  `NecesidadEspecial` VARCHAR(255) NULL,
  `TipoSangre` VARCHAR(2) NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`idSalud`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Estudiante` (
  `Pk_IdEstudiante` INT NOT NULL AUTO_INCREMENT,
  `Fk_IdUsuario` INT NOT NULL,
  `Cedula` VARCHAR(15) NOT NULL,
  `Nombre` VARCHAR(20) NOT NULL,
  `Apellidos` VARCHAR(25) NOT NULL,
  `Telefono` INT NOT NULL,
  `Direccion` INT NOT NULL,
  `Nacionalidad` VARCHAR(30) NOT NULL,
  `Carrera` VARCHAR(45) NOT NULL,
  `CodigoCarrera` VARCHAR(45) NOT NULL,
  `NumeroCarnet` VARCHAR(45) NOT NULL,
  `FechaNacimiento` VARCHAR(45) NOT NULL,
  `LugarNacimiento` VARCHAR(45) NOT NULL,
  `InfoSalud` INT NULL,
  `PersonaEmergencia` VARCHAR(45) NOT NULL,
  `TelefonoEmergencia` VARCHAR(8) NOT NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`Pk_IdEstudiante`),
  INDEX `Fk_IdUsuario_idx` (`Fk_IdUsuario` ASC),
  INDEX `Fk_Telefonos_Estudiante_idx` (`Telefono` ASC),
  INDEX `Fk_Direccion_Estudiante_idx` (`Direccion` ASC),
  INDEX `Fk_Salud_Estudiante_idx` (`InfoSalud` ASC),
  CONSTRAINT `Fk_Usuario_Estudiante`
    FOREIGN KEY (`Fk_IdUsuario`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Telefonos_Estudiante`
    FOREIGN KEY (`Telefono`)
    REFERENCES `mydbInge`.`Telefonos` (`idTelefonos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Direccion_Estudiante`
    FOREIGN KEY (`Direccion`)
    REFERENCES `mydbInge`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Salud_Estudiante`
    FOREIGN KEY (`InfoSalud`)
    REFERENCES `mydbInge`.`Salud` (`idSalud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`ControlArticulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`ControlArticulos` (
  `Pk_IdArticulo` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NOT NULL,
  `Descripcion` TEXT(4096) NOT NULL,
  `Autor` VARCHAR(60) NOT NULL,
  `Fecha_Publicacion` DATE NOT NULL,
  `FK_IdUsuario` INT NOT NULL,
  `Enlace` VARCHAR(255) NOT NULL,
  `Enlace_Drive` VARCHAR(255) NULL,
  `Fecha_Modificacion` DATE NULL,
  `Ultimo_Usuario` INT NULL,
  PRIMARY KEY (`Pk_IdArticulo`),
  INDEX `Fk_IdUsuario_idx` (`FK_IdUsuario` ASC),
  CONSTRAINT `Fk_IdUsuarioArticulos`
    FOREIGN KEY (`FK_IdUsuario`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`ControlChats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`ControlChats` (
  `PK_IdControlChats` INT NOT NULL AUTO_INCREMENT,
  `FK_IdUsuarioOrigen` INT NOT NULL,
  `FK_IdUsuarioDestino` INT NOT NULL,
  `Mensaje` TEXT(512) NOT NULL,
  `Asunto` VARCHAR(45) NOT NULL,
  `FechaEnvio` DATETIME NOT NULL,
  PRIMARY KEY (`PK_IdControlChats`),
  INDEX `fk_idUsuarioChat1_idx` (`FK_IdUsuarioOrigen` ASC),
  INDEX `fk_idUsuarioChat2_idx` (`FK_IdUsuarioDestino` ASC),
  CONSTRAINT `fk_idUsuarioChat1`
    FOREIGN KEY (`FK_IdUsuarioOrigen`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idUsuarioChat2`
    FOREIGN KEY (`FK_IdUsuarioDestino`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Funcionario` (
  `Pk_idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `Fk_idUsuario` INT NOT NULL,
  `Cedula` VARCHAR(15) NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Apellidos` VARCHAR(30) NOT NULL,
  `Telefono` INT NOT NULL,
  `Celular` VARCHAR(8) NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`Pk_idFuncionario`),
  INDEX `fk_Usuario_Funcionario_idx` (`Fk_idUsuario` ASC),
  INDEX `fk_Telefonos_Funcionario_idx` (`Telefono` ASC),
  CONSTRAINT `fk_Usuario_Funcionario`
    FOREIGN KEY (`Fk_idUsuario`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Telefonos_Funcionario`
    FOREIGN KEY (`Telefono`)
    REFERENCES `mydbInge`.`Telefonos` (`idTelefonos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Grupo` (
  `idGrupo` INT NOT NULL,
  `NRC` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Numero` INT NOT NULL,
  `Fk_Funcionario` INT NOT NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`idGrupo`),
  INDEX `fk_Fucionario_Grupo_idx` (`Fk_Funcionario` ASC),
  CONSTRAINT `fk_Fucionario_Grupo`
    FOREIGN KEY (`Fk_Funcionario`)
    REFERENCES `mydbInge`.`Funcionario` (`Pk_idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Comentarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Comentarios` (
  `idComentarios` INT NOT NULL AUTO_INCREMENT,
  `Fk_idEstudiante` INT NOT NULL,
  `Fk_idUsuario` INT NOT NULL,
  `Descripcion` VARCHAR(255) NOT NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`idComentarios`),
  INDEX `fk_Estudiante_Comentarios_idx` (`Fk_idEstudiante` ASC),
  INDEX `fk_Usuario_Comentarios_idx` (`Fk_idUsuario` ASC),
  CONSTRAINT `fk_Usuario_Comentarios`
    FOREIGN KEY (`Fk_idUsuario`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estudiante_Comentarios`
    FOREIGN KEY (`Fk_idEstudiante`)
    REFERENCES `mydbInge`.`Estudiante` (`Pk_IdEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydbInge`.`Usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbInge`;
INSERT INTO `mydbInge`.`Usuario` (`Pk_IdUsuario`, `Usuario`, `Uk_Email`, `Password_Sha512`, `Password_Bcrypt`, `Tipo`, `Fecha_Creacion`, `Fecha_Modificacion`, `Ultimo_Usuario`, `estado`, `codigoConfirmacion`) VALUES (1, 'Administrador', 'Administrador', '7be6c43cc95d65b388332655226fb48cf13b5cdbf4c3a6b58b44748e788c9f648c5c5c329625b4fc31f7cac0a663902bcbbda3e90cd3c57987a7382a716313bf', '$2a$10$0mvJ6CgMlj.JX25y0xdNt./NwrTvMbsZWE6godEJfhcWjL3RQAPlu', 2, '2018-10-1', NULL, NULL, 1, NULL);

COMMIT;

