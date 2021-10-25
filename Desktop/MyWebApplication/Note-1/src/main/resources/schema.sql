CREATE TABLE note (
	id int(5) NOT NULL AUTO_INCREMENT,
	dateTime datetime,
	name varchar(20),
	title varchar(30),
	contents varchar(500) NOT NULL,
	PRIMARY KEY (id)
	);

CREATE TABLE IF NOT EXISTS user (
	user_id VARCHAR(50) PRIMARY KEY,
	password VARCHAR(100),
	role VARCHAR(50)
);