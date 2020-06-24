package com.siuk.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.siuk.vo.Board;

@Service
public class BoardSrv {

	public static final String ns = "board";
	
	@Autowired
	private SqlSession sqlSession;

	public void insertBoard(Board board) {
		sqlSession.insert(ns + ".insertBoard", board);
	}

	public Board selectBoard(Integer no) {
		return sqlSession.selectOne(ns + ".selectBoard", no);
	}
	
	public void deleteBoard(Integer no) {
		sqlSession.delete(ns + ".deleteBoard", no);
	}
	
	public List<Board> selectBoards() {
		return sqlSession.selectList(ns + ".selectBoards");
	}
}
