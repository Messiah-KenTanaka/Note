package com.beit_and_pear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.Authentication;

import com.beit_and_pear.model.Note;

@Mapper
public interface NoteMapper {

	// ユーザーごとの日記を全件取得
	List<Note> selectAll(Authentication loginUser, String userId);

	// 一件取得
	Note selectByPrimaryKey(Long id);

	// 新規追加
	int insert(Note note);

	// 更新
	int updateByPrimaryKey(Note note);

	// 削除
	int deleteByPrimaryKey(Long id);
}
