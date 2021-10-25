package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MUser;

@Mapper
public interface UserMapper {

	// ユーザー登録
	public int insertOne(MUser mUser);

	// ログインユーザー取得
	public MUser findLoginUser(String userId);
}
