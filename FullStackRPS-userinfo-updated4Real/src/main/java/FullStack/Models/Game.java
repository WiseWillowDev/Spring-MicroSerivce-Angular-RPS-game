package FullStack.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Game {

	private long id;
	private String userChoice;
	private String compChoice;
	private boolean compWin;
	private boolean userWin;
	private long user;
	
	public Game() {}
	
	public Game(String userChoice, String comChoice, boolean compWin, boolean userWin, long userid) {
		this.userChoice = userChoice;
		this.compChoice = comChoice;
		this.compWin = compWin;
		this.userWin = userWin;
		this.user = userid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserChoice() {
		return userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	public String getCompChoice() {
		return compChoice;
	}

	public void setCompChoice(String compChoice) {
		this.compChoice = compChoice;
	}

	public boolean isCompWin() {
		return compWin;
	}

	public void setCompWin(boolean compWin) {
		this.compWin = compWin;
	}

	public boolean isUserWin() {
		return userWin;
	}

	public void setUserWin(boolean userWin) {
		this.userWin = userWin;
	}

	public long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}
	
}
