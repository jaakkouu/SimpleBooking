CREATE TABLE IF NOT EXISTS users(
  id SERIAL PRIMARY KEY,
  username varchar(255) UNIQUE NOT NULL,
  email varchar(255) UNIQUE NOT NULL,
  password varchar(255) NOT NULL,
  enabled INTEGER DEFAULT 0,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
); 

CREATE TABLE IF NOT EXISTS authorities(
  id SERIAL PRIMARY KEY,
  user_id INTEGER UNIQUE REFERENCES users(id),
  username varchar(255) UNIQUE NOT NULL,
  authority varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS places(
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  name varchar(255) UNIQUE NOT NULL,
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
  url varchar(255) UNIQUE NOT NULL,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
);

CREATE TABLE IF NOT EXISTS bookings(
  id SERIAL PRIMARY KEY,
  place_id INTEGER REFERENCES places(id),
  name varchar(255) NOT NULL,
  phonenumber varchar(255) UNIQUE NOT NULL,
  reservation_date date NOT NULL,
  receipt_number varchar(25) UNIQUE NOT NULL,
  created_at timestamp,
  modified_at timestamp,
  removed_at timestamp
);

CREATE TABLE IF NOT EXISTS companies(
  id SERIAL PRIMARY KEY,
  user_id INTEGER UNIQUE REFERENCES users(id),
  name varchar(255),
  address varchar(255),
  modified_at timestamp
);

CREATE TABLE IF NOT EXISTS contacts(
  id SERIAL PRIMARY KEY,
  user_id INTEGER UNIQUE REFERENCES users(id),
  first_name varchar(255),
  last_name varchar(255),
  address varchar(255),
  phonenumber varchar(255),
  modified_at timestamp
);
