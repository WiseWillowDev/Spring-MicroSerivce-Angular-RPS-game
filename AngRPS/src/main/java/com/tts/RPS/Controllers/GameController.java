package com.tts.RPS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tts.RPS.Services.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	
}
