-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BDB
-- -----------------------------------------------------
-- 	
DROP SCHEMA IF EXISTS `BDB` ;

-- -----------------------------------------------------
-- Schema BDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BDB` DEFAULT CHARACTER SET utf8 ;
USE `BDB` ;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `image` VARCHAR(1000) NULL,
  `join_date` DATETIME NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `post` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `body` VARCHAR(3000) NOT NULL,
  `image` VARCHAR(100) NULL,
  `post_date` DATETIME NULL,
  `title` VARCHAR(200) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `body` VARCHAR(3000) NOT NULL,
  `post_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `comment_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_post_idx` (`post_id` ASC),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_comment_post`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_sent` DATETIME NOT NULL,
  `body` VARCHAR(3000) NOT NULL,
  `is_read` TINYINT NOT NULL,
  `sender_id` INT NOT NULL,
  `reciver_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_user1_idx` (`sender_id` ASC),
  INDEX `fk_message_user2_idx` (`reciver_id` ASC),
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`sender_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user2`
    FOREIGN KEY (`reciver_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `category_has_post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category_has_post` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `category_has_post` (
  `category_id` INT NOT NULL,
  `post_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `post_id`),
  INDEX `fk_category_has_post_post1_idx` (`post_id` ASC),
  INDEX `fk_category_has_post_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_category_has_post_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_has_post_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
SET SQL_MODE = '';
DROP USER IF EXISTS admin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SHOW WARNINGS;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'RiotFest1131';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'admin'@'localhost';
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `role`, `enabled`, `image`, `join_date`, `username`) VALUES (1, 'Brittany', 'Piacente', 'piacenteb@gmail.com', '$2a$10$nShOi5/f0bKNvHB8x0u3qOpeivazbuN0NE4TO0LGvQiTMafaBxLJS', 'admin', true, 'https://media.licdn.com/dms/image/C5603AQHGxYlr_ErBjw/profile-displayphoto-shrink_200_200/0/1571160567251?e=1696464000&v=beta&t=FM3kVxgJd9GBgqPkaEWam-52IzMznA5UXe96imexrQg', '2023-08-03', 'boss');
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `role`, `enabled`, `image`, `join_date`, `username`) VALUES (2, 'David', 'Dunlevy', 'david.dunlevy@gmiil.com', '$2a$10$nShOi5/f0bKNvHB8x0u3qOpeivazbuN0NE4TO0LGvQiTMafaBxLJS', 'user', true, 'https://media.licdn.com/dms/image/D5635AQFlkWN_YHG_xg/profile-framedphoto-shrink_200_200/0/1686011438207?e=1691647200&v=beta&t=X8qwm5VoRVoyN6fpZkH40i9AGj2n88Xc3gfJ4hUDDXM', '2023-08-03', 'ekoostik');

COMMIT;


-- -----------------------------------------------------
-- Data for table `post`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `post` (`id`, `body`, `image`, `post_date`, `title`, `user_id`) VALUES (1, 'Welcome to The Spot, the future of FX.', NULL, '2023-08-03', 'Welcome post', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `comment` (`id`, `body`, `post_id`, `user_id`, `comment_date`) VALUES (1, 'first comment!', 1, 2, '2023-08-03');

COMMIT;


-- -----------------------------------------------------
-- Data for table `message`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `message` (`id`, `date_sent`, `body`, `is_read`, `sender_id`, `reciver_id`) VALUES (1, '2023-08-03', 'test message 1', false, 1, 2);
INSERT INTO `message` (`id`, `date_sent`, `body`, `is_read`, `sender_id`, `reciver_id`) VALUES (2, '2023-08-03', 'test message 2', true, 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `category` (`id`, `type`) VALUES (1, 'General');

COMMIT;


-- -----------------------------------------------------
-- Data for table `category_has_post`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `category_has_post` (`category_id`, `post_id`) VALUES (1, 1);

COMMIT;

