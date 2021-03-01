package com.example.demo.svc;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {
	
	public void createUser(UserDto userDto);
	
	public List<UserDto> getUserList();
	
	public UserDto getUserDetail(Integer userSeq);
	
	public void updateUser(UserDto user);
	
	public void deleteUser(Integer userSeq);
}
