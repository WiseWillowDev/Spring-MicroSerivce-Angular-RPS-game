package FullStack.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import FullStack.Models.*;
import FullStack.Repos.UserRepo;


@Service
public class UserService {

	private UserRepo userRepo;
	private RestTemplate restTemplate;
	
	@Autowired
	public UserService(UserRepo userRepo, RestTemplate restTemplate) {
		this.userRepo = userRepo;
		this.restTemplate = restTemplate;
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public User findById(long id) {
		return userRepo.findById(id);
	}
	
	public List<User> findAllByNewest() {
		List<User> reverse = new ArrayList<>();
		for(int i = userRepo.findAll().size(); i > 0; i--) {
			reverse.add(userRepo.findAll().get(i-1));
		}
		return reverse;
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public void updateUser(User user) {
		user.getId();
		System.out.println("User Service: updating User : the Id = " + user.getId());
		System.out.println("This is irrevelent");
	}
	

}
