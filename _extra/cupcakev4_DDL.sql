DROP SCHEMA IF EXISTS `cupcake`;
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8mb4 ;
USE `cupcake` ;

CREATE TABLE IF NOT EXISTS `cupcake`.`User` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `balance` DOUBLE NULL DEFAULT 0.00,
  `email` VARCHAR(45) NOT NULL,
  `role` ENUM('admin', 'user') NULL DEFAULT 'user',
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `cupcake`.`Cupcake_top` (
  `id_top` INT NOT NULL,
  `top_name` VARCHAR(45) NOT NULL UNIQUE,
  `top_price` DOUBLE NOT NULL,
  PRIMARY KEY (`id_top`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `cupcake`.`Cupcake_bottom` (
  `id_bottom` INT NOT NULL,
  `bottom_name` VARCHAR(45) NOT NULL UNIQUE,
  `bottom_price` DOUBLE NOT NULL,
  PRIMARY KEY (`id_bottom`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `cupcake`.`Invoice` (
  `id_invoice` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NULL,
  `totalprice` DOUBLE NULL,
  PRIMARY KEY (`id_invoice`),
  INDEX `id_invoice_UserID_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `id_invoice_UserID`
    FOREIGN KEY (`id_user`)
    REFERENCES `cupcake`.`User` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `cupcake`.`Invoice_Details` (
  `id_invoice_details` INT NOT NULL AUTO_INCREMENT,
  `id_invoice` INT NOT NULL,
  `id_top` INT NOT NULL,
  `id_bottom` INT NOT NULL,
  `quantity` INT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id_invoice_details`),
  INDEX `InvoiceD_invoiceID_fk_idx` (`id_invoice` ASC) VISIBLE,
  CONSTRAINT `InvoiceID_fk`
    FOREIGN KEY (`id_invoice`)
    REFERENCES `cupcake`.`Invoice` (`id_invoice`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,	
  CONSTRAINT `InvoiceD_topID_fk`
    FOREIGN KEY (`id_top`)
    REFERENCES `cupcake`.`Cupcake_top` (`id_top`)	
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `InvoiceD_bottomID_fk`
    FOREIGN KEY (`id_bottom`)
    REFERENCES `cupcake`.`Cupcake_bottom` (`id_bottom`)	
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

