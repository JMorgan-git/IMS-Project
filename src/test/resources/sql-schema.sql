DROP TABLE IF EXISTS `order_items`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`item_name` char(50) NOT NULL,
    `item_value` DOUBLE NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `order_items`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`),
    FOREIGN KEY (`item_id`) REFERENCES `items`(`id`)
    PRIMARY KEY (`id`)
);