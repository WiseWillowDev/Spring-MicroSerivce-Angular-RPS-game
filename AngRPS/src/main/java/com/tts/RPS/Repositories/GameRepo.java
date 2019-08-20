package com.tts.RPS.Repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.RPS.Models.Game;

@Repository 
public interface GameRepo extends CrudRepository <Game, Long> {

	Set findByUserId(Long id);
	
	List findAll();
}
