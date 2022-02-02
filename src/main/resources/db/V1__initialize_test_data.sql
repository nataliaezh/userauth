DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
  id                    bigserial,
  name                  VARCHAR(50),
  password              VARCHAR(80),
  email                 VARCHAR(50) NOT NULL UNIQUE,
PRIMARY KEY (id)
);

DROP TABLE IF EXISTS profiles CASCADE;
CREATE TABLE profiles (
id bigserial PRIMARY KEY,
cash numeric(8, 2),
user_id bigint,
FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS phones CASCADE;
CREATE TABLE phones (
  id                    serial,
  value                 VARCHAR(50) NOT NULL UNIQUE,
user_id bigint,
FOREIGN KEY (user_id) REFERENCES users (id)
PRIMARY KEY (id)
);





