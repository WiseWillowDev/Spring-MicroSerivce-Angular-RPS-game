package com.tts.RPS.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.RPS.Models.User;

public interface UserRepo extends CrudRepository<User , Long> {

	List<User> findAll();
	
}
