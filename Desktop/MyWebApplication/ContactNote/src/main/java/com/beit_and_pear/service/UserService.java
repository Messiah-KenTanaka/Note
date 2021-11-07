package com.beit_and_pear.service;

import com.beit_and_pear.model.MUser;

public interface UserService {

	// ユーザー登録
	public void signup(MUser user);

	// ログインユーザー情報取得
	public MUser getLoginUser(String userId);
}
