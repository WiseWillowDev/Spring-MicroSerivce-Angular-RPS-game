package FullStack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FullStack.Models.Game;
import FullStack.Services.GameService;

@RestController
@RequestMapping(value = "/api/games")
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {
	
	private GameService gameService;
	
	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Game> getGamesbyUserId(@PathVariable("id") long id) {
		return gameService.findAllGamesByUserIdInReverse(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Game> getAllGames() {
		return gameService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveNewGame(@RequestBody Game game) {
		game.setCompChoice(gameService.getCompChoice());
		gameService.decideWinner(game);
		gameService.save(game);
		gameService.updateUserByGame(game);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteGame(@RequestBody Game game) {
		gameService.delete(game);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateGame(@RequestBody Game game) {
		gameService.save(game);
	}
	
	@RequestMapping(value= "lastGame/{id}", method = RequestMethod.GET)
	public Game getLastPlayedGame(@PathVariable("id") long id) {
		
		
		return gameService.findLastGameByUser(id); 
	}
	 
//	@RequestMapping(method = RequestMethod.POST) 
//	public void saveNewGame(@RequestBody String userChoice) {
//		Game game = new Game();
//		game.setUserChoice(userChoice);
//		game.setCompChoice(gameService.getCompChoice());
//		gameService.decideWinner(game);
//		gameService.save(game);
//	}
	

}
