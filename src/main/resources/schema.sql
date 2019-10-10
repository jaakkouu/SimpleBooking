DROP DATABASE simplebooking;
CREATE DATABASE IF NOT EXISTS `simplebooking`;

USE `simplebooking`;

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `users` (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  enabled int(11) DEFAULT 0,
  createdAt datetime,
  modifiedAt datetime,
  removedAt datetime,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `authorities` (
  id int(11) NOT NULL AUTO_INCREMENT,
  userId int(11) NOT NULL,
  username varchar(255) NOT NULL,
  authority varchar(50) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (userId) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `places` (
  id int(11) NOT NULL AUTO_INCREMENT,
  userId int(11) NOT NULL,
  name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  largeDescription varchar(255) NOT NULL,
  smallDescription varchar(50) NOT NULL,
  createdAt datetime,
  modifiedAt datetime,
  removedAt datetime,
  PRIMARY KEY (id),
  FOREIGN KEY (userId) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `place_urls` (
  id int(11) NOT NULL AUTO_INCREMENT,
  placeId int(11) NOT NULL,
  url varchar(255) NOT NULL,
  createdAt datetime,
  modifiedAt datetime,
  removedAt datetime,
  PRIMARY KEY (id),
  FOREIGN KEY (placeId) REFERENCES places(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `bookings` (
  id int(11) NOT NULL AUTO_INCREMENT,
  placeId int(11) NOT NULL,
  name varchar(255) NOT NULL,
  phonenumber varchar(255) NOT NULL,
  reservationDate date NOT NULL,
  createdAt datetime,
  modifiedAt datetime,
  removedAt datetime,
  PRIMARY KEY (id),
  FOREIGN KEY (placeId) REFERENCES places(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/* users */
insert into users (username, email, password, enabled) VALUES ('admin', 'admin@simplebooking.com', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 1);
insert into users (username, email, password, enabled) VALUES ('user', 'user@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1);
insert into users (username, email, password, enabled) VALUES ('user2', 'user2@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1);
insert into users (username, email, password, enabled) VALUES ('user3', 'user3@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 0);
insert into users (username, email, password, enabled, removedAt) VALUES ('kovaluu', 'kovaluu@tulinpelleilee.fi', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 0, '2019-10-10 18:16:08');


/* authorities */
insert into authorities (userId, username, authority) VALUES (0, 'admin', 'ROLE_ADMIN');
insert into authorities (userId, username, authority) VALUES (1, 'user', 'ROLE_USER');
insert into authorities (userId, username, authority) VALUES (2, 'user2', 'ROLE_USER');
insert into authorities (userId, username, authority) VALUES (3, 'user3', 'ROLE_USER');

/* places */
insert into places (name, largeDescription, smallDescription, address, userId) VALUES ('Sea Food Restaurant', 'Lorem ipsum dolor sit amet', 'Lorem ipsum', 'Random Road 32', 2);
insert into places (name, largeDescription, smallDescription, address, userId) VALUES ('Tower Restaurant', 'Lorem ipsum dolor sit amet', 'Lorem ipsum', 'Random Road 16', 2);
insert into places (name, largeDescription, smallDescription, address, userId) VALUES ('Downtown Chinese', 'Lorem ipsum dolor sit amet', 'Lorem ipsum', 'Random Road 79', 3);

insert into place_urls (placeId, url) VALUES (1, "sea-food-restaurant");
insert into place_urls (placeId, url) VALUES (2, "tower-restaurant");
insert into place_urls (placeId, url) VALUES (3, "downtown-chinese");

insert into bookings (placeId, name, phonenumber, reservationDate) VALUES (1, "Matti Näsä", "0403934577", "2019-10-01 09:30:11");
insert into bookings (placeId, name, phonenumber, reservationDate) VALUES (2, "Jaakko Parantainen", "0501215281", "2019-10-04 12:33:11");
insert into bookings (placeId, name, phonenumber, reservationDate) VALUES (2, "Iso Pebe", "0505136369", "2019-10-11 14:21:23");

SET FOREIGN_KEY_CHECKS=1;