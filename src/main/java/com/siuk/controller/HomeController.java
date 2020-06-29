package com.siuk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.siuk.service.BoardSrv;
import com.siuk.vo.Board;
import com.siuk.vo.Paging;

@Controller
public class HomeController {

	@Autowired
	private BoardSrv boardSrv;
	
	@GetMapping("/")
	public String home(Paging paging, Model model) {
		List<Board> boards = boardSrv.selectBoards(paging);
		
		model.addAttribute("boards", boards);
		model.addAttribute("paging", paging);
		
		return "main";
	}
}
