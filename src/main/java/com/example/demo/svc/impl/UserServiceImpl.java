package com.example.demo.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.svc.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao dao;
	
	@Override
	public void createUser(UserDto userDto) {
		dao.createUser(userDto);
		

	}
	@Override
	public List<UserDto> getUserList() {
		return dao.getUserList();
	}
	
	@Override
	public UserDto getUserDetail(Integer userSeq){
		return dao.getUserDetail(userSeq);
	}
	
	@Override
	public void updateUser(UserDto user) {
	 dao.updateUser(user);
		
	}
	@Override
	public void deleteUser(Integer userSeq) {
	 dao.deleteUser(userSeq);
	}
	

}
