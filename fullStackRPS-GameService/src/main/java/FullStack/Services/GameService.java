package FullStack.Services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import FullStack.Models.Game;
import FullStack.Models.User;
import FullStack.Repo.GameRepo;

@Service
public class GameService {

	private GameRepo gameRepo;
	private RestTemplate restTemplate;
	
	@Autowired
	public GameService(GameRepo gameRepo, RestTemplate restTemplate) {
		this.gameRepo = gameRepo;
		this.restTemplate = restTemplate;
	}
	
	public List<Game> findAll() {
		
//		if(gameRepo.findAll().size() == 0) {
//			Game gameOne = new Game("Rock","Paper", true,false,1);
//			gameRepo.save(gameOne);
//		}
		return gameRepo.findAll();
	}
	
	public void save(Game game) {
		gameRepo.save(game);
	}
	
	public Game findById(long id) {
		return gameRepo.findById(id);
	}
	
	public void delete(Game game) {
		gameRepo.delete(game);
	}
	
	public List<Game> findAllGamesByUserId(long id){
		return gameRepo.findAllByUser(id);
	}
	
	public List<Game> findAllGamesByUserIdInReverse(long id){
		List<Game> reverse = new ArrayList<>();
		for(int i = gameRepo.findAll().size(); i > 0; i--) {
			reverse.add(gameRepo.findAll().get(i-1));
		}
		return reverse;
	}
	
	public String getCompChoice() {
		Random rand = new Random();
		String Choices[] = {"Rock" , "Paper" , "Scissors"};
		return Choices[rand.nextInt(3)];
	}
	
	public void decideWinner(Game game) {
		int comp = convertAnswerToInt(game.getCompChoice());
		int user = convertAnswerToInt(game.getUserChoice());
		
		int outCome[][] = {
//		user   |		comp		
				{0, 2, 1},
				{1, 0, 2} ,
				{2, 1, 0}
		};
		
		if(outCome[user][comp] == 1) {
			game.setUserWin(true);
		} else if(outCome[user][comp] == 2) {
			game.setCompWin(true);
		}
		
	}
	
	public static int convertAnswerToInt(String choice) {
		if(choice.equals("Rock")) {
			return 0;
		} else if(choice.equals("Paper")) {
			return 1;
		} else {
			return 2;
		}
	}
	 
	
//	public void updateUser(Game game) {
//		restTemplate.put("http://localhost:8087/api/users/total", 1);
//	}
	public void updateUser(Game game) {
		System.out.println("GameService.UpdateUser is starting");
		System.out.println("The game user is" + game.getUser());
		User user = restTemplate.getForObject("http://localhost:8087/api/users/" + game.getUser(), User.class);
		user.setUserid(game.getUser());
		System.out.println("Got it!");
		System.out.println(user.getUserid());
		System.out.println(user.getName());
		int total = gameRepo.findAllByUser(game.getUser()).size();
		int wins = 0;
		int losses = 0;
		for(int i = 0; i < total; i++) {
			Game currentI = gameRepo.findAllByUser(game.getUser()).get(i);
			if(currentI.isUserWin()) {
				wins++;
			} else if(currentI.isCompWin()) {
				losses++;
			}
		}
		
		user.setTotalGames(total);
		user.setLosses(losses);
		user.setWins(wins);
//		restTemplate.postForObject("http://localhost:8087/api/users", user, User.class);
		restTemplate.put("http://localhost:8087/api/users", user);
		System.out.println("Finished");
	}
	
	public void updateUserByGame(Game game) {
		System.out.println("Starting the thing ");
		restTemplate.put("http://localhost:8087/api/users", game);
	}
	
	public Game findLastGameByUser(long id) {
		List<Game> games = gameRepo.findAllByUser(id);
		int index = 0;
		long lastestGameId = 0;
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getId() > lastestGameId) {
				index = i;
				lastestGameId = games.get(i).getId();
			}
		}
		
		return games.get(index);
		
	}
}
	
