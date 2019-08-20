package FullStack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import FullStack.Models.Game;
import FullStack.Models.User;
import FullStack.Services.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin(value = "http://localhost:4200")
public class RPSUserController {
	
	private UserService userService;
	
	@Autowired
	public RPSUserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {

		return userService.findAllByNewest();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") long id) {
		return userService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public void saveRealUser(@RequestBody User user) {
		userService.save(user);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}
	
	@RequestMapping(value = "total", method = RequestMethod.PUT)
	public void updateFakeUser(@RequestBody int totalGames) {
		User user = userService.findById(1);
		user.setTotalGames(totalGames);
		userService.save(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT) 
	public void updateUserByGame(@RequestBody Game game) {
		System.out.println("userController, updating the user By game");
		System.out.println("the game user id is " + game.getUser());
		User user = userService.findById(game.getUser());
		System.out.println("the user id is " + user.getId());
		user.setTotalGames(user.getTotalGames() + 1);
		if(game.isCompWin()) {
			user.setLosses(user.getLosses() + 1);
		} else if(game.isUserWin()) {
			user.setWins(user.getWins() + 1);
		}
		
		userService.save(user);
	}

}
