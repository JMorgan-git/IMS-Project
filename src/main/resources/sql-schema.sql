drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`id` int NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `ims`.`customers`(`id`),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`item_name` char(50) NOT NULL,
    `item_value` DOUBLE NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES `ims`.`orders`(`id`),
    FOREIGN KEY (`item_id`) REFERENCES `ims`.`items`(`id`),
    PRIMARY KEY (`id`)
);