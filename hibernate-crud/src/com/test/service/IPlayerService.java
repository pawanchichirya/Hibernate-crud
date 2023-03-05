package com.test.service;

import com.test.dto.Player;

public interface IPlayerService {

	public String addPlayer(String name, Integer age, String team);
	public Player searchPlayer(Integer jersyNo);
	public String updatePlayer(Integer jersyNo, String name, Integer age, String team);
	public String deletePlayer(Integer jersyNo);
	
}
