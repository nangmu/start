package com.siuk.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siuk.service.BoardSrv;
import com.siuk.vo.Board;

@SpringBootTest
public class BoardTests {
	
	@Autowired
	private BoardSrv boardSrv;
	
	@Test
	public void insertTest() {
		String title = "제목 1";
		String content = "내용 1";
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		boardSrv.insertBoard(board);
		Integer bno = board.getNo();
		
		Board getBoard = boardSrv.selectBoard(bno);
		assertEquals(board, getBoard);
		
		boardSrv.deleteBoard(bno);
		
		getBoard = boardSrv.selectBoard(bno);
		assertNull(getBoard);
		
	}
	
}
