package com.tts.RPS.Controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.RPS.Models.Game;
import com.tts.RPS.Models.User;
import com.tts.RPS.Services.GameService;
import com.tts.RPS.Services.UserService;

@Controller
public class HomePageController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public String HomePage(Model model) {
		model.addAttribute("users", userService.findAll());
		
		return "WebPages/HomePage";
	}
	
	@GetMapping("/CreateNewUser")
	public String CreateNewUserPage(User user) {
		
		return "WebPages/NewUser";
	}
	
	@GetMapping("/playGame/{id}")
	public String GoToGame(@PathVariable Long id , Model model, Game game) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "/WebPages/Game";
	}
	
	@PostMapping("/CreateNewUser")
	public String createANewUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "WebPages/NewUser";
		}
		
		userService.save(user);
		model.addAttribute(user.getName());
		
		model.addAttribute("users", userService.findAll());

		
		return "WebPages/HomePage";
	}
	
	@PostMapping("/result/{id}")
	public String SubmittedAGame(@PathVariable Long id, Model model, Game game) {
//		check to see if the userName is taken
//		add validation for notEmtpy on the user	
		
		User user = userService.findById(id);
		gameService.GenerateComputerAnswer(game);
		game.setUser(user);
		model.addAttribute("result", gameService.GameLogic(game));
		model.addAttribute("user", user);
		model.addAttribute("game",game);
		gameService.save(game);
		model.addAttribute("totalWins", gameService.totalWins(user));
		model.addAttribute("totalLose", gameService.totalLoses(user));


		
		return "WebPages/Result";
	}
	
}