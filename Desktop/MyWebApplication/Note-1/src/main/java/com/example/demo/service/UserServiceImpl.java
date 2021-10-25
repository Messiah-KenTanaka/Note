package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MUser;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	// ユーザー登録
	@Override
	public void signup(MUser mUser) {
		mUser.setRole("ROLE_GENERAL"); // ロール

		// パスワードの暗号化
		String rawPassword = mUser.getPassword();
		mUser.setPassword(encoder.encode(rawPassword));

		mapper.insertOne(mUser);
	}

	// ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}

}
