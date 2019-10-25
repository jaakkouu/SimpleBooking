CREATE TABLE users(
  id SERIAL PRIMARY KEY,
  username varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  enabled INTEGER DEFAULT 0,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
); 

CREATE TABLE authorities(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  username varchar(255) NOT NULL,
  authority varchar(50) NOT NULL
);

CREATE TABLE places(
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

CREATE TABLE place_urls(
  id SERIAL PRIMARY KEY,
  place_id INTEGER REFERENCES places(id),
  url varchar(255) NOT NULL,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
);

CREATE TABLE bookings(
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

CREATE TABLE companies(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  name varchar(255),
  address varchar(255),
  modified_at timestamp
);

CREATE TABLE contacts(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  first_name varchar(255),
  last_name varchar(255),
  address varchar(255),
  phonenumber varchar(255),
  modified_at timestamp
);

insert into users (username, email, password, enabled) VALUES ('admin', 'admin@simplebooking.com', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 1);
insert into users (username, email, password, enabled) VALUES ('user1', 'user1@simplebooking.com', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 1);
