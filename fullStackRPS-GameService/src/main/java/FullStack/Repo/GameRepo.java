package FullStack.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import FullStack.Models.Game;

@Repository
public interface GameRepo extends CrudRepository <Game , Long>{

	List<Game> findAll();
	
	Game findById(long id);
	
	List<Game> findAllByUser(long id);
	
}
