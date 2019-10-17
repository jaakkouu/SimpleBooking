CREATE TABLE IF NOT EXISTS users(
  id SERIAL PRIMARY KEY,
  username varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  enabled INTEGER DEFAULT 0,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
); 

CREATE TABLE IF NOT EXISTS authorities(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  username varchar(255) NOT NULL,
  authority varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS places(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  large_description varchar(1024) NOT NULL,
  small_description varchar(100) NOT NULL,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
);

CREATE TABLE IF NOT EXISTS place_urls(
  id SERIAL PRIMARY KEY,
  place_id INTEGER REFERENCES places(id),
  url varchar(255) NOT NULL,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
);

CREATE TABLE IF NOT EXISTS bookings(
  id SERIAL PRIMARY KEY,
  place_id INTEGER REFERENCES places(id),
  name varchar(255) NOT NULL,
  phonenumber varchar(255) NOT NULL,
  reservation_date date NOT NULL,
  receipt_number varchar(25) NOT NULL,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
);

CREATE TABLE IF NOT EXISTS companies(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  name varchar(255),
  address varchar(255),
  modified_at timestamp
);

CREATE TABLE IF NOT EXISTS contacts(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  first_name varchar(255),
  last_name varchar(255),
  address varchar(255),
  phonenumber varchar(255),
  modified_at timestamp
);

-- users
insert into users (username, email, password, enabled) VALUES ('admin', 'admin@simplebooking.com', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 1) ON CONFLICT DO NOTHING;
insert into users (username, email, password, enabled) VALUES ('user', 'user@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1) ON CONFLICT DO NOTHING;
insert into users (username, email, password, enabled) VALUES ('user2', 'user2@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1) ON CONFLICT DO NOTHING;
insert into users (username, email, password, enabled) VALUES ('user3', 'user3@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 0) ON CONFLICT DO NOTHING;
insert into users (username, email, password, enabled, removed_at) VALUES ('kovaluu', 'kovaluu@tulinpelleilee.fi', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 0, '2019-10-10 18:16:08') ON CONFLICT DO NOTHING;

-- authorities
insert into authorities (user_id, username, authority) VALUES (1, 'admin', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
insert into authorities (user_id, username, authority) VALUES (2, 'user', 'ROLE_USER') ON CONFLICT DO NOTHING;
insert into authorities (user_id, username, authority) VALUES (3, 'user2', 'ROLE_USER') ON CONFLICT DO NOTHING;
insert into authorities (user_id, username, authority) VALUES (4, 'user3', 'ROLE_USER') ON CONFLICT DO NOTHING;
insert into authorities (user_id, username, authority) VALUES (5, 'kovaluu', 'ROLE_USER') ON CONFLICT DO NOTHING;

-- places
insert into places (name, large_description, small_description, address, user_id) VALUES ('Sea Hotel', 'Bacon ipsum dolor amet sirloin pork belly short loin shoulder rump bresaola t-bone beef pig leberkas strip steak. Corned beef pork belly strip steak turducken prosciutto cupim cow. Doner salami buffalo shankle pancetta biltong, sirloin fatback short loin burgdoggen ball tip tongue. Doner kevin picanha beef turducken corned beef, kielbasa pork frankfurter jerky pork belly tail boudin ribeye salami. T-bone boudin ham hock burgdoggen. Turkey burgdoggen corned beef, spare ribs pastrami fatback biltong doner ribeye meatball sirloin. Pancetta chicken beef ribs shoulder sausage drumstick shankle rump pork belly capicola cupim turkey tri-tip bacon.', 'Pig corned beef ball tip, turkey pork sirloin fatback capicola.', 'Random Road 32', 2) ON CONFLICT DO NOTHING;
insert into places (name, large_description, small_description, address, user_id) VALUES ('Tower Hotel', 'Bacon ipsum dolor amet sirloin pork belly short loin shoulder rump bresaola t-bone beef pig leberkas strip steak. Corned beef pork belly strip steak turducken prosciutto cupim cow. Doner salami buffalo shankle pancetta biltong, sirloin fatback short loin burgdoggen ball tip tongue. Doner kevin picanha beef turducken corned beef, kielbasa pork frankfurter jerky pork belly tail boudin ribeye salami. T-bone boudin ham hock burgdoggen. Turkey burgdoggen corned beef, spare ribs pastrami fatback biltong doner ribeye meatball sirloin. Pancetta chicken beef ribs shoulder sausage drumstick shankle rump pork belly capicola cupim turkey tri-tip bacon.', 'Pork pork chop sirloin, burgdoggen pancetta ham venison bresaola.', 'Random Road 16', 2) ON CONFLICT DO NOTHING;
insert into places (name, large_description, small_description, address, user_id) VALUES ('Downtown Hotel', 'Bacon ipsum dolor amet sirloin pork belly short loin shoulder rump bresaola t-bone beef pig leberkas strip steak. Corned beef pork belly strip steak turducken prosciutto cupim cow. Doner salami buffalo shankle pancetta biltong, sirloin fatback short loin burgdoggen ball tip tongue. Doner kevin picanha beef turducken corned beef, kielbasa pork frankfurter jerky pork belly tail boudin ribeye salami. T-bone boudin ham hock burgdoggen. Turkey burgdoggen corned beef, spare ribs pastrami fatback biltong doner ribeye meatball sirloin. Pancetta chicken beef ribs shoulder sausage drumstick shankle rump pork belly capicola cupim turkey tri-tip bacon.', 'Chicken jerky biltong kielbasa.', 'Random Road 79', 3) ON CONFLICT DO NOTHING;

insert into place_urls (place_id, url) VALUES (1, 'sea-hotel') ON CONFLICT DO NOTHING;
insert into place_urls (place_id, url) VALUES (2, 'tower-hotel') ON CONFLICT DO NOTHING;
insert into place_urls (place_id, url) VALUES (3, 'downtown-hotel') ON CONFLICT DO NOTHING;

-- Bookings
insert into bookings (place_id, name, phonenumber, reservation_date, receipt_number) VALUES (1, 'Matti Näsä', '0403934577', '2019-10-20', '5266894187637345544959825') ON CONFLICT DO NOTHING;
insert into bookings (place_id, name, phonenumber, reservation_date, receipt_number) VALUES (2, 'Jaakko Parantainen', '0501215281', '2019-10-04', '5466894787637345544959825') ON CONFLICT DO NOTHING;
insert into bookings (place_id, name, phonenumber, reservation_date, receipt_number) VALUES (2, 'Iso Pebe', '0505136369', '2019-10-11', '5236894787617345544959825') ON CONFLICT DO NOTHING;

-- Profile
insert into contacts (user_id, first_name, last_name, address, phonenumber) VALUES (2, 'Fabio', 'Fibonacci', 'Pasilankatu', '0551241234') ON CONFLICT DO NOTHING;

-- Company info
insert into companies (user_id, name, address) VALUES (2, 'Amazing Company Oy', 'StreetStreet 12nd Avenue') ON CONFLICT DO NOTHING;
