package com.beit_and_pear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.beit_and_pear.model.Note;

@Mapper
public interface NoteMapper {

	// 合計を取得
	Long count();

	// ページイング情報
	List<Note> selectAll(RowBounds rowBounds);

	// 全件取得
	List<Note> selectAll();

	// 一件取得
	Note selectByPrimaryKey(Long id);

	// 新規追加
	int insert(Note note);

	// 更新
	int updateByPrimaryKey(Note note);

	// 削除
	int deleteByPrimaryKey(Long id);
}
