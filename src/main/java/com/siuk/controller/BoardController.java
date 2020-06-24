package com.siuk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.siuk.service.BoardSrv;
import com.siuk.vo.Board;

@Controller
public class BoardController {

	@Autowired
	private BoardSrv boardSrv;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Board> boards = boardSrv.selectBoards();
		model.addAttribute("boards", boards);
		for(Board b : boards) {
			System.out.println(b);
		}
		return "main";
	}
	
	@GetMapping("/board/{no}")
	public String writeView(@PathVariable Integer no, Model model) {
		Board board = boardSrv.selectBoard(no);
		model.addAttribute("board", board);
		return "board/read";
	}
	
	@GetMapping("/board/write")
	public String writeView() {
		return "board/write";
	}
	
	@PostMapping("/board/write")
	public String write(Board board) {
		boardSrv.insertBoard(board);
		return "redirect:/";
	}
	
	@PostMapping("/board/delete")
	public String delete() {
		return "redirect:/";
	}
	
}
