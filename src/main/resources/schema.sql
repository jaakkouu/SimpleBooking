DROP TABLE IF EXISTS simplebooking.authorities;
DROP TABLE IF EXISTS simplebooking.users;
DROP TABLE IF EXISTS simplebooking.places;
DROP TABLE IF EXISTS simplebooking.booking;

CREATE DATABASE IF NOT EXISTS `simplebooking`;
USE `simplebooking`;

CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placeId` int(11) NOT NULL,
  `date` date NOT NULL,
  `createdAt` date,
  `modifiedAt` date,
  `removeAt` date,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `places` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` int(255) NOT NULL,
  `address` int(255) NOT NULL,
  `userId` int(11) NOT NULL,
  `createdAt` date,
  `modifiedAt` date,
  `removedAt` date,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin,
  `enabled` int(11) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `createdAt` date,
  `removedAt` date,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE UNIQUE INDEX `ix_username` ON users (`username`);

insert into users (username, password, enabled) VALUES ('admin', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 1);
insert into users (username, password, enabled) VALUES ('user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1);

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) COLLATE utf8_bin NOT NULL,
  `authority` VARCHAR(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) VALUES ('user', 'ROLE_USER');

CREATE UNIQUE INDEX `ix_auth_username` ON authorities (`username`, `authority`);


