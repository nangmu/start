package com.siuk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.siuk.vo.Board;
import com.siuk.vo.Paging;

@Mapper
public interface BoardMapper {
	void insertBoard(Board board);
	Board selectBoard(Integer no);
	int deleteBoard(Integer no);
	List<Board> selectBoards(Paging paging);
	void updateBoard(Board board);
	Integer count(Paging paging);
}
