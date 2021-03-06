package FullStack.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int totalGames;
	private int wins;
	private int losses;
	private int winPercent;
	
	public User() {}
	
	public User(String name, int total, int win, int lose, int percent) {
		this.name = name;
		this.totalGames = total;
		this.wins = win;
		this.losses = lose;
		this.winPercent = percent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getWinPercent() {
		return winPercent;
	}

	public void setWinPercent(int winPercent) {
		this.winPercent = winPercent;
	}
	
	
}
