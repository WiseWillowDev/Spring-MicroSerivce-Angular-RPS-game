package com.tts.RPS.Services;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.RPS.Models.Game;
import com.tts.RPS.Models.User;
import com.tts.RPS.Repositories.GameRepo;

@Service
public class GameService {

	@Autowired
	private GameRepo gameRepo;
	
	static String[] result = { "Rock", "Paper", "Scissors" };


	public void save(Game game) {
		gameRepo.save(game);
	}

	public void GenerateComputerAnswer(Game game) {
		Random rand = new Random();

		game.setCompChoice(result[rand.nextInt(3)]);

	}

	public Set<Game> findGameByUser(Long id) {
		Set<Game> games = gameRepo.findByUserId(id);
		return games;
	}

	public String GameLogic(Game game) {
		String answer = "";
		int comp = 0;
		int user = 0;
		for(int i = 0; i < result.length; i++) {
			if(game.getCompChoice().equalsIgnoreCase(result[i])) {
				comp = i;
			}
			if(game.getHumanChoice().equalsIgnoreCase(result[i])) {
				user = i;
			}
		}
		
		String decisions[][] = 
			{		//(second number)
	//(firstNum)	//rock,Paper,Scissor
		/*rock */	{ "Tie","Lose","Win"},
		/*paper */	{ "Win","Tie", "Lose"},
		/*scissor*/ { "Lose", "Win","Tie"},
			};
		if(decisions[user][comp].equalsIgnoreCase("Win")) {
			game.setHumanWin(game.getHumanWin()+1);
		}
		if(decisions[user][comp].equalsIgnoreCase("Lose")) {
			game.setCompWin(game.getCompWin()+1);
		}
		answer = "You " + decisions[user][comp];
		
		return answer;
	}
	
	public int totalWins(User user) {
		List<Game> games = gameRepo.findAll();
		int total = 0;
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getUser() == user) {
				total = total + games.get(i).getHumanWin();
			}
		}
		
		return total;
	}
	
	public int totalLoses(User user) {
		List<Game> games = gameRepo.findAll();
		int total = 0;
		for(int i = 0; i < games.size(); i++) {
			if(games.get(i).getUser() == user) {
				total = total + games.get(i).getCompWin();
			}
		}
		return total;
	}
}
