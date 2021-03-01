package com.example.demo.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;


@Mapper
public interface UserDao {
	
	public void createUser(UserDto user);
	
	public List<UserDto> getUserList();
	
	public UserDto getUserDetail(Integer userSeq);
	
	public void updateUser(UserDto user);
	
	public void deleteUser(Integer userSeq);
}
