package com.beit_and_pear.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.beit_and_pear.model.MUser;

@Mapper
public interface UserMapper {

	// ユーザー登録
	public int insertOne(MUser user);
}
