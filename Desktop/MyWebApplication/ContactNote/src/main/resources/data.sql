INSERT INTO note(name, date, content)
	VALUES('テスト', '2021-10-28','サンプルです。削除して構いません。');
	
INSERT INTO m_user (user_id, password, role)
	VALUES('tanakaken', 'password', 'ROLE_ADMIN'),
		  ('user', 'password', 'ROLE_GENERAL');