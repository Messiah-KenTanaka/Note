CREATE TABLE IF NOT EXISTS note (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date datetime,
	name VARCHAR(20),
	content VARCHAR(250) NOT NULL
	);