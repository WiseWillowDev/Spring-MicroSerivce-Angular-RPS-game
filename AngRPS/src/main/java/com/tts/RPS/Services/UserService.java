package com.tts.RPS.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.RPS.Models.User;
import com.tts.RPS.Repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public List<User> findAll(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	public User findById(long id) {
		return userRepo.findById(id).orElse(null);
		
	}
}
