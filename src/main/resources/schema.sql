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
  created_at datetime,
  modified_at datetime,
  removed_at datetime,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `authorities` (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  username varchar(255) NOT NULL,
  authority varchar(50) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `places` (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  large_description varchar(1024) NOT NULL,
  small_description varchar(100) NOT NULL,
  created_at datetime,
  modified_at datetime,
  removed_at datetime,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `place_urls` (
  id int(11) NOT NULL AUTO_INCREMENT,
  place_id int(11) NOT NULL,
  url varchar(255) NOT NULL,
  created_at datetime,
  modified_at datetime,
  removed_at datetime,
  PRIMARY KEY (id),
  FOREIGN KEY (place_id) REFERENCES places(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `bookings` (
  id int(11) NOT NULL AUTO_INCREMENT,
  place_id int(11) NOT NULL,
  name varchar(255) NOT NULL,
  phonenumber varchar(255) NOT NULL,
  reservation_date date NOT NULL,
  receipt_number varchar(25) NOT NULL,
  created_at datetime,
  modified_at datetime,
  removed_at datetime,
  PRIMARY KEY (id),
  FOREIGN KEY (place_id) REFERENCES places(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `companies` (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  name varchar(255),
  address varchar(255),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `contacts` (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  first_name varchar(255),
  last_name varchar(255),
  address varchar(255),
  phonenumber varchar(255),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- users
insert into users (username, email, password, enabled) VALUES ('admin', 'admin@simplebooking.com', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 1);
insert into users (username, email, password, enabled) VALUES ('user', 'user@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1);
insert into users (username, email, password, enabled) VALUES ('user2', 'user2@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1);
insert into users (username, email, password, enabled) VALUES ('user3', 'user3@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 0);
insert into users (username, email, password, enabled, removed_at) VALUES ('kovaluu', 'kovaluu@tulinpelleilee.fi', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 0, '2019-10-10 18:16:08');

-- authorities
insert into authorities (user_id, username, authority) VALUES (0, 'admin', 'ROLE_ADMIN');
insert into authorities (user_id, username, authority) VALUES (1, 'user', 'ROLE_USER');
insert into authorities (user_id, username, authority) VALUES (2, 'user2', 'ROLE_USER');
insert into authorities (user_id, username, authority) VALUES (3, 'user3', 'ROLE_USER');

-- places
insert into places (name, large_description, small_description, address, user_id) VALUES ('Sea Hotel', 'Bacon ipsum dolor amet sirloin pork belly short loin shoulder rump bresaola t-bone beef pig leberkas strip steak. Corned beef pork belly strip steak turducken prosciutto cupim cow. Doner salami buffalo shankle pancetta biltong, sirloin fatback short loin burgdoggen ball tip tongue. Doner kevin picanha beef turducken corned beef, kielbasa pork frankfurter jerky pork belly tail boudin ribeye salami. T-bone boudin ham hock burgdoggen. Turkey burgdoggen corned beef, spare ribs pastrami fatback biltong doner ribeye meatball sirloin. Pancetta chicken beef ribs shoulder sausage drumstick shankle rump pork belly capicola cupim turkey tri-tip bacon.', 'Pig corned beef ball tip, turkey pork sirloin fatback capicola.', 'Random Road 32', 2);
insert into places (name, large_description, small_description, address, user_id) VALUES ('Tower Hotel', 'Bacon ipsum dolor amet sirloin pork belly short loin shoulder rump bresaola t-bone beef pig leberkas strip steak. Corned beef pork belly strip steak turducken prosciutto cupim cow. Doner salami buffalo shankle pancetta biltong, sirloin fatback short loin burgdoggen ball tip tongue. Doner kevin picanha beef turducken corned beef, kielbasa pork frankfurter jerky pork belly tail boudin ribeye salami. T-bone boudin ham hock burgdoggen. Turkey burgdoggen corned beef, spare ribs pastrami fatback biltong doner ribeye meatball sirloin. Pancetta chicken beef ribs shoulder sausage drumstick shankle rump pork belly capicola cupim turkey tri-tip bacon.', 'Pork pork chop sirloin, burgdoggen pancetta ham venison bresaola.', 'Random Road 16', 2);
insert into places (name, large_description, small_description, address, user_id) VALUES ('Downtown Hotel', 'Bacon ipsum dolor amet sirloin pork belly short loin shoulder rump bresaola t-bone beef pig leberkas strip steak. Corned beef pork belly strip steak turducken prosciutto cupim cow. Doner salami buffalo shankle pancetta biltong, sirloin fatback short loin burgdoggen ball tip tongue. Doner kevin picanha beef turducken corned beef, kielbasa pork frankfurter jerky pork belly tail boudin ribeye salami. T-bone boudin ham hock burgdoggen. Turkey burgdoggen corned beef, spare ribs pastrami fatback biltong doner ribeye meatball sirloin. Pancetta chicken beef ribs shoulder sausage drumstick shankle rump pork belly capicola cupim turkey tri-tip bacon.', 'Chicken jerky biltong kielbasa.', 'Random Road 79', 3);

insert into place_urls (place_id, url) VALUES (1, "sea-hotel");
insert into place_urls (place_id, url) VALUES (2, "tower-hotel");
insert into place_urls (place_id, url) VALUES (3, "downtown-hotel");

-- Bookings
insert into bookings (place_id, name, phonenumber, reservation_date, receipt_number) VALUES (1, "Matti Näsä", "0403934577", "2019-10-20", "5266894187637345544959825");
insert into bookings (place_id, name, phonenumber, reservation_date, receipt_number) VALUES (2, "Jaakko Parantainen", "0501215281", "2019-10-04", "5466894787637345544959825");
insert into bookings (place_id, name, phonenumber, reservation_date, receipt_number) VALUES (2, "Iso Pebe", "0505136369", "2019-10-11", "5236894787617345544959825");

SET FOREIGN_KEY_CHECKS=1;