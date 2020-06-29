package com.siuk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siuk.service.UserSrv;
import com.siuk.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserSrv userSrv;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/regist")
	public String registView() {
		return "user/regist";
	}
	
	@PostMapping("/regist")
	public String regist(User user) {
		User registUser = userSrv.regist(user);
		registUser.setPw(null);
		session.setAttribute("user", registUser);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String loginView() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(User user) {
		User loginUser = userSrv.login(user);
		loginUser.setPw(null);
		session.setAttribute("user", loginUser);
		log.info("?", loginUser);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
