package FullStack.Models;

import java.util.List;

public class UserGames {
	
	private long user;
	private List<Game> games;
	
	public UserGames() {}

	public UserGames(long user, List<Game> games) {
		this.user = user;
		this.games = games;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	
}
