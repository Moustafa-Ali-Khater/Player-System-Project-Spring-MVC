package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Player;
import com.spring.service.PlaryerService;
import com.spring.service.PlayerServiceImp;

@Controller
@RequestMapping("/fifa")
public class PlayerController {

	@Autowired
	private PlaryerService playerService;
	

	public PlayerController() {
	}


	@GetMapping("/players")
	public String Players(Model model) {
		List<Player> players = playerService.allPlayers();
		model.addAttribute("players" ,players);
		return "fifa-players";
	}
	
	@GetMapping("/add")
	public String savePage(Model model) {
		model.addAttribute("player",new Player());
		return "addPlayer";
	}
	
	@PostMapping("/saveplayer")
	public String addUser(@ModelAttribute("player") Player player) {
		playerService.savePlayer(player);
		return "redirect:/fifa/players";
	}
	
	@GetMapping("/showplayer")
	public String getPlayerById(@RequestParam("playerId") int id, Model model) {
		Player player = playerService.getPlayerById(id);
		model.addAttribute("player", player);
		return "addPlayer";
	}
	
	@GetMapping("/removeplayer")
	public String removePlayer(@RequestParam("playerId") int id) {
		playerService.deletePlayerById(id);
		return "redirect:/fifa/players";
	}
}
