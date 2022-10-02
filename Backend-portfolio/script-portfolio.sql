-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfolio` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema Usuarios
-- -----------------------------------------------------
USE `portfolio` ;

-- -----------------------------------------------------
-- Table `portfolio`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`persona` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `sobremi` LONGTEXT NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `img` VARCHAR(100) NOT NULL,
  `banner` VARCHAR(45) NOT NULL,
  `e-mail` VARCHAR(45) NOT NULL,
  `fortaleza` VARCHAR(45) NULL,
  `debilidad` VARCHAR(45) NULL,
  `estcivil` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `portfolio`.`experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`experiencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(45) NOT NULL,
  `inicio` DATE NOT NULL,
  `fin` VARCHAR(45) NULL,
  `descripcion` LONGTEXT NOT NULL,
  `img` VARCHAR(45) NULL,
  `empresa` VARCHAR(45) NOT NULL,
  `persona_id` INT UNSIGNED NOT NULL,
  `estrabajoactual` TINYINT NULL,
  `tipo_empleo` ENUM('formal', 'freelance', 'monotributo', 'informal') NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`certificado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`certificado` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `img` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`estudio` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `inicio` DATE NOT NULL,
  `fin` DATE NULL,
  `institucion` VARCHAR(45) NOT NULL,
  `img` VARCHAR(45) NULL,
  `curso` ENUM('formal', 'curso', 'bootcamp') NOT NULL,
  `persona_id` INT UNSIGNED NOT NULL,
  `certificado_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`proyecto` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `urlproyecto` VARCHAR(45) NULL,
  `img` VARCHAR(45) NULL,
  `tecnologia` VARCHAR(45) NULL,
  `persona_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`habilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`habilidad` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `porcentaje` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`redes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`redes` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `icono` VARCHAR(45) NULL,
  `enlace` VARCHAR(45) NULL,
  `persona_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`habilidad_has_proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`habilidad_has_proyecto` (
  `habilidad_id` INT NOT NULL,
  `proyecto_id` INT NOT NULL,
  PRIMARY KEY (`habilidad_id`, `proyecto_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
