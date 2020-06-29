package com.siuk.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siuk.exception.NotOnwerException;
import com.siuk.mapper.BoardMapper;
import com.siuk.vo.Board;
import com.siuk.vo.Paging;

@Service
public class BoardSrv {

	@Autowired
	BoardMapper boardMapper;

	SqlSession session;
	
	public void ownerCheck(Integer bno, Integer uno) throws NotOnwerException{
		Board board = boardMapper.selectBoard(bno);
		if(board == null || uno != board.getUno()) {
			throw new NotOnwerException();
		}
	}
	
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
	}

	public Board selectBoard(Integer no) {
		return boardMapper.selectBoard(no);
	}
	
	public int deleteBoard(Integer no) {
		return boardMapper.deleteBoard(no);
	}
	
	public List<Board> selectBoards(Paging paging) {
		paging.setTotalRows(count(paging));
		return boardMapper.selectBoards(paging);
	}

	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}
	
	public Integer count(Paging paging) {
		return boardMapper.count(paging);
	}
}
