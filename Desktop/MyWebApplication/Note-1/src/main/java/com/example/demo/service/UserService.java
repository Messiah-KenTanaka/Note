package com.example.demo.service;

import com.example.demo.entity.MUser;

public interface UserService {

	// ユーザー登録
	public void signup(MUser mUser);

	// ログインユーザー情報取得
	public MUser getLoginUser(String userId);
}
