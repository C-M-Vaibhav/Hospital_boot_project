package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.Exception.NoFoundByIdException;
import com.ty.hospital.hospitalappboot.dao.UserDao;
import com.ty.hospital.hospitalappboot.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public User getUserById(int id) {
		User user = dao.getUserById(id);
		if(user==null) {
			throw new NoFoundByIdException();
		}
		return user; 
	}
	
	public List<User> getAllUser(){
		return dao.getalluser();
	}
	
	public boolean deleteUserById(int id) {
		return dao.deletebyId(id);
	}
	
	public User updateUserById(int id,User user) {
		User u  = dao.updateUser(id, user);
		if(u==null) {
			throw new NoFoundByIdException();
		}
		return u;
	}
	

}
