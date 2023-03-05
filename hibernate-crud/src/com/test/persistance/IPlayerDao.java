package com.test.persistance;

import com.test.dto.Player;

public interface IPlayerDao {
	
	public String addPlayer(Integer jersyNo, String name, Integer age, String team);
	public Player searchPlayer(Integer jersyNo);
	public String updatePlayer(Integer jersyNo, String name, Integer age, String team);
	public String deletePlayer(Integer jersyNo);
	
}
