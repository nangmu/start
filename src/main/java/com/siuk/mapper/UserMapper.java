package com.siuk.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.siuk.vo.User;

@Mapper
public interface UserMapper {

	void insertUser(User user);
	User selectUser(Integer no);
	User selectUserById(String id);
	User selectUserByNickname(String nickname);
	void deleteUser(Integer no);
}
