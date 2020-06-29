package com.siuk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siuk.exception.LoginFailedException;
import com.siuk.mapper.UserMapper;
import com.siuk.vo.User;

@Service
public class UserSrv {
	
	private static final Logger log = LoggerFactory.getLogger(UserSrv.class);

	@Autowired
	private UserMapper userMapper;
	
	public User regist(User user) {
		userMapper.insertUser(user);
		return getUser(user.getNo());
	}
	
	public User getUser(Integer no) {
		return userMapper.selectUser(no);
	}
	
	public User getUserById(String id) {
		return userMapper.selectUserById(id);
	}
	
	public User getUserByNickname(String nickname) {
		return userMapper.selectUserByNickname(nickname);
	}
	
	public void remove(Integer no) {
		userMapper.deleteUser(no);
	}

	public User login(User user) throws LoginFailedException{
		User maybeUser = getUserById(user.getId());
		if(maybeUser == null || !maybeUser.getPw().equals(user.getPw())) {
			log.info("LOGIN FAILED");
			throw new LoginFailedException();
		}
		return maybeUser;
	}
	
}
