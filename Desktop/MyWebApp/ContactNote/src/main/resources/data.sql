INSERT INTO note(name, date, content, user_id)
	VALUES('テスト', '2021-10-28','サンプルです。削除して構いません。', 'user'),
		  ('テスト', '2021-10-28','サンプルです。削除して構いません。', 'tanaka');
	
INSERT INTO m_user (user_id, password, role)
	VALUES('user', '$2a$10$sASu3M4jSGuO80Q9yBKI4ugTCWCOnbvXSZets1wfqkBGnGKJgG.jy', 'ROLE_ADMIN'),
		  ('tanaka', '$2a$10$sASu3M4jSGuO80Q9yBKI4ugTCWCOnbvXSZets1wfqkBGnGKJgG.jy', 'ROLE_GENERAL');