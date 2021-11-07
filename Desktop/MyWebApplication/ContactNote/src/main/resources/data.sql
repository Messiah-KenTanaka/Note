INSERT INTO note(name, date, content)
	VALUES('テスト', '2021-10-28','サンプルです。削除して構いません。');
	
INSERT INTO m_user (user_id, password, role)
	VALUES('tanakaken', '$2a$10$sASu3M4jSGuO80Q9yBKI4ugTCWCOnbvXSZets1wfqkBGnGKJgG.jy', 'ROLE_ADMIN'),
		  ('user', '$2a$10$sASu3M4jSGuO80Q9yBKI4ugTCWCOnbvXSZets1wfqkBGnGKJgG.jy', 'ROLE_GENERAL');