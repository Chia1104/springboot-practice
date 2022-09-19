CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT uuid_generate_v4();

CREATE TABLE IF NOT EXISTS armors (
  id uuid NOT NULL DEFAULT uuid_generate_v4(),
  name varchar(255) NOT NULL,
  description varchar(255),
  image varchar(255) NOT NULL,
  defense int NOT NULL,
  level int NOT NULL,
  heaviness int NOT NULL,
  CONSTRAINT pk_armors PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
  id uuid NOT NULL DEFAULT uuid_generate_v4(),
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  created_at timestamp NOT NULL DEFAULT now(),
  role varchar(255) NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);