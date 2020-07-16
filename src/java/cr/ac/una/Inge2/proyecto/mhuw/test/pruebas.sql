/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Axel
 * Created: 10-sep-2018
 */               


 
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydbInge
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydbInge` ;

-- -----------------------------------------------------
-- Schema mydbInge
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydbInge` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema inge2
-- -----------------------------------------------------
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
-- Table `mydbInge`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Cliente` (
  `Pk_IdCliente` INT NOT NULL AUTO_INCREMENT,
  `Fk_IdUsuario` INT NOT NULL,
  `Cedula` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(20) NOT NULL,
  `Apellidos` VARCHAR(25) NOT NULL,
  `Telefono` VARCHAR(8) NOT NULL,
  `Direccion` VARCHAR(200) NULL,
  `Nacionalidad` VARCHAR(30) NOT NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`Pk_IdCliente`),
  INDEX `Fk_IdUsuario_idx` (`Fk_IdUsuario` ASC),
  CONSTRAINT `Fk_IdUsuarioCliente`
    FOREIGN KEY (`Fk_IdUsuario`)
    REFERENCES `mydbInge`.`Usuario` (`Pk_IdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`Servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Servicios` (
  `Pk_IdServicio` INT NOT NULL AUTO_INCREMENT,
  `Nombre` INT NOT NULL,
  `TipoServicio` INT NOT NULL,
  `Horario` DATETIME NULL,
  `Descripcion` VARCHAR(255) NOT NULL,
  `Cupos` INT NULL,
  `Precio` DOUBLE NULL,
  `FechaCreacion` DATE NULL,
  `I_Ultimo_Usuario` INT NULL,
  `D_Fecha_modificacion` DATE NULL,
  PRIMARY KEY (`Pk_IdServicio`))
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
-- Table `mydbInge`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`Factura` (
  `Pk_IdFactura` INT NOT NULL AUTO_INCREMENT,
  `Fk_IdCliente` INT NOT NULL,
  `Fk_idServicio` INT NOT NULL,
  `Fecha_Creacion` DATE NOT NULL,
  `Descripcion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Pk_IdFactura`),
  INDEX `Fk_IdCliente_idx` (`Fk_IdCliente` ASC),
  INDEX `Fk_IdServicio_idx` (`Fk_idServicio` ASC),
  CONSTRAINT `Fk_IdClienteFactura`
    FOREIGN KEY (`Fk_IdCliente`)
    REFERENCES `mydbInge`.`Cliente` (`Pk_IdCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Fk_IdServicioFactura`
    FOREIGN KEY (`Fk_idServicio`)
    REFERENCES `mydbInge`.`Servicios` (`Pk_IdServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbInge`.`ControlServicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydbInge`.`ControlServicios` (
  `Pk_IdControlServicio` INT NOT NULL AUTO_INCREMENT,
  `Fk_IdCliente` INT NOT NULL,
  `Fk_IdServicio` INT NOT NULL,
  `Fecha_Creacion` DATE NOT NULL,
  `Ultimo_Usuario` INT NULL,
  `Fecha_Modificacion` DATE NULL,
  PRIMARY KEY (`Pk_IdControlServicio`),
  INDEX `Pk_Fk_idServicio_idx` (`Fk_IdServicio` ASC),
  CONSTRAINT `Pk_Fk_idClienteCServicio`
    FOREIGN KEY (`Fk_IdCliente`)
    REFERENCES `mydbInge`.`Cliente` (`Pk_IdCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Pk_Fk_idServicioCServicio`
    FOREIGN KEY (`Fk_IdServicio`)
    REFERENCES `mydbInge`.`Servicios` (`Pk_IdServicio`)
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
