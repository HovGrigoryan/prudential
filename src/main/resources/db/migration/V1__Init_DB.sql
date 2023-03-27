CREATE SCHEMA IF NOT EXISTS prudential;
ALTER SCHEMA prudential OWNER TO postgres;

CREATE TABLE IF NOT EXISTS prudential.users (
id bigserial PRIMARY KEY,
name VARCHAR,
surname VARCHAR
);

INSERT INTO prudential.users(name,surname)
VALUES ('Isabella', 'Jones');