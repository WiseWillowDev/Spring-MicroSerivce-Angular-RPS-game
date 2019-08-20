package com.tts.RPS.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int humanWin;
	private int compWin;
	private String compChoice;
	private String humanChoice;
	private int roundNumber;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	private User user;
	
	public Game() {}
	
	public Game(int humanWin, int compwin, String compChoice , String humanChoice, int roundNumber) {
		this.humanWin = humanWin;
		this.compWin = compwin;
		this.compChoice = compChoice;
		this.humanChoice = humanChoice;
		this.roundNumber = roundNumber;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getHumanWin() {
		return humanWin;
	}
	public void setHumanWin(int humanWin) {
		this.humanWin = humanWin;
	}
	public int getCompWin() {
		return compWin;
	}
	public void setCompWin(int compWin) {
		this.compWin = compWin;
	}
	public String getCompChoice() {
		return compChoice;
	}
	public void setCompChoice(String compChoice) {
		this.compChoice = compChoice;
	}
	public String getHumanChoice() {
		return humanChoice;
	}
	public void setHumanChoice(String humanChoice) {
		this.humanChoice = humanChoice;
	}
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return this.user;
	}
	
}
