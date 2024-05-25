package com.spring.service;

import java.util.List;

import com.spring.model.Player;

public interface PlaryerService {

	public List<Player> allPlayers();
	
	public void savePlayer(Player player);

	public Player getPlayerById(int id);

	public void deletePlayerById(int id);
}
