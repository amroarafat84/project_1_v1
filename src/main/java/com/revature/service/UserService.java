package com.revature.service;

import com.revature.dto.User;
import com.revature.impDao.ImpUser;

public class UserService {
	
	private ImpUser userImp = new ImpUser();
	
	public User checkAuth(String userName, String password) {
		User user =  userImp.getUserByUserName(userName);
		if(user.getUsername().equalsIgnoreCase(userName) && user.getPassword().equals(password)){
			return user;
		}
		return null;
		
	}
	
	

}
