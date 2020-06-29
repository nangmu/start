package com.siuk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siuk.service.BoardSrv;
import com.siuk.vo.Board;
import com.siuk.vo.Paging;
import com.siuk.vo.User;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardSrv boardSrv;
	
	@GetMapping("")
	public String home(Paging paging, Model model) {
		List<Board> boards = boardSrv.selectBoards(paging);
		
		model.addAttribute("boards", boards);
		model.addAttribute("paging", paging);
		
		log.debug("?", paging);
		System.out.println(paging);
		
		return "board/main";
	}
	
	@GetMapping("/{no}")
	public String writeView(@PathVariable Integer no, Model model) {
		Board board = boardSrv.selectBoard(no);
		model.addAttribute("board", board);
		return "board/read";
	}
	
	@GetMapping("/update")
	public String updateView(Integer no, Model model) {
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return "redirect:/board";
		}
		boardSrv.ownerCheck(no, user.getNo());
		
		model.addAttribute("board", boardSrv.selectBoard(no));
		return "board/update";
	}
	
	@PostMapping("/update")
	public String update(@Valid Board board, Model model) {
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return "redirect:/board";
		}
		boardSrv.ownerCheck(board.getNo(), user.getNo());
		
		boardSrv.updateBoard(board);
		return "redirect:/board/" + board.getNo();
	}
	
	@GetMapping("/write")
	public String writeView() {
		if(loginCheck() == null) {
			return "redirect:/board";
		}
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@Valid Board board) {
		User user = null;
		if((user = loginCheck()) == null) {
			return "redirect:/board";
		}
		
		board.setUno(user.getNo());
		board.setNickname(user.getNickname());
		
		boardSrv.insertBoard(board);
		return "redirect:/board";
	}
	
	@GetMapping("/delete")
	public String delete(Integer no) {
		if(loginCheck() == null) {
			return "redirect:/";
		}
		
		boardSrv.deleteBoard(no);
		return "redirect:/board";
	}
	
	private User loginCheck() {
		return (User)session.getAttribute("user");
	}
	
}
