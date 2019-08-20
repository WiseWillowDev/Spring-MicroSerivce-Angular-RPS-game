package FullStack.Repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import FullStack.Models.User;

@Repository
public interface UserRepo extends CrudRepository <User , Long>{

	List<User> findAll();
	
	User findById(long id);
	
}
