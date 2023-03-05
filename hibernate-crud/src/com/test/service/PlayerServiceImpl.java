package com.test.service;

import com.test.daofactory.PlayerDaoFactory;
import com.test.dto.Player;
import com.test.persistance.IPlayerDao;

public class PlayerServiceImpl implements IPlayerService{

	private IPlayerDao playerDao;
	@Override
	public String addPlayer(Integer jersyNo, String name, Integer age, String team) {
		playerDao=PlayerDaoFactory.getPlayerDao();
		return playerDao.addPlayer(jersyNo, name, age, team);
	}

	@Override
	public Player searchPlayer(Integer jersyNo) {
		playerDao=PlayerDaoFactory.getPlayerDao();
		return playerDao.searchPlayer(jersyNo);
	}

	@Override
	public String updatePlayer(Integer jersyNo, String name, Integer age, String team) {
		playerDao=PlayerDaoFactory.getPlayerDao();
		return playerDao.updatePlayer(jersyNo, name, age, team);
	}

	@Override
	public String deletePlayer(Integer jersyNo) {
		playerDao=PlayerDaoFactory.getPlayerDao();
		return playerDao.deletePlayer(jersyNo);
	}

}
