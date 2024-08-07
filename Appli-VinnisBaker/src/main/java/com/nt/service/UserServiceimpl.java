package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.UserRepository;

@Service
public class UserServiceimpl implements IUserService {

	 @Autowired
	 private UserRepository userepo;

	@Override
	public void addUser(User user) {
		userepo.save(user);
		
	}

	
}
