package com.siuk.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.siuk.service.BoardSrv;
import com.siuk.vo.Board;

@WebMvcTest
public class BoardControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BoardSrv boardSrv;
	
	@Test
	public void 단순조회() throws Exception {
		
				mockMvc.perform(
						get("/")
						).andExpect(status().isOk());
	}
	
	@Test
	public void 글등록() throws Exception {
		
		String title = "12345678901234567890";
		String content = null;
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		mockMvc.perform(
				post("/board/write", board)
			).andExpect(status().is4xxClientError());
	}
	
}
