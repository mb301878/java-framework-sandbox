--https://www.postgresqltutorial.com/postgresql-tutorial/postgresql-create-table/
CREATE TABLE accounts (
	user_id INT PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
    last_login TIMESTAMP
);

--https://www.postgresqltutorial.com/postgresql-tutorial/postgresql-create-table/
--CREATE TABLE accounts (
--	user_id INT PRIMARY KEY,
--	username VARCHAR ( 50 )
--);
