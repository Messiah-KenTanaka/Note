package com.beit_and_pear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.beit_and_pear.mapper.UserMapper;
import com.beit_and_pear.model.MUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	// ユーザー登録
	@Override
	public void signup(MUser user) {
		user.setRole("ROLE_GENERAL"); // ロール

		// パスワード暗号化
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));

		mapper.insertOne(user);
	}

	// ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}

}
