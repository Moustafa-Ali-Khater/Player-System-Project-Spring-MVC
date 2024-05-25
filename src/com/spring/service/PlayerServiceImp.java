package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.PlayerDAO;
import com.spring.model.Player;

@Service
public class PlayerServiceImp implements PlaryerService {

	private PlayerDAO playerDAO;
	
	@Autowired
	public PlayerServiceImp(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	@Transactional
	@Override
	public List<Player> allPlayers() {
		return playerDAO.getPlayers();
	}

	@Transactional
	@Override
	public void savePlayer(Player player) {
		playerDAO.addPlayer(player);
	
	}
	
	@Transactional
	@Override
	public Player getPlayerById(int id) {
		return playerDAO.getPlayerById(id);
	}
	
	@Transactional
	@Override
	public void deletePlayerById(int id) {
		playerDAO.deletePlayerById(id);;
	}
}
