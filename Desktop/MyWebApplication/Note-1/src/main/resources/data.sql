INSERT INTO note(id, dateTime, name, title,　contents)
VALUES(NULL, '2021-10-15', 'name', 'title',　'これはサンプルです');

INSERT INTO user (user_id, password, role) 
VALUES('tanakaken', '$2a$10$HBHXzXFHrrKvC9SFpboBu.4dP562KVVd0DgRAe/Lcq0RYTKjNjUAm', 'ROLE_ADMIN'),
	  ('bass', '$2a$10$HBHXzXFHrrKvC9SFpboBu.4dP562KVVd0DgRAe/Lcq0RYTKjNjUAm', 'ROLE_GENERAL');