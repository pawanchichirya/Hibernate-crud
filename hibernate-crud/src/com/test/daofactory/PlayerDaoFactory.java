package com.test.daofactory;

import com.test.persistance.IPlayerDao;
import com.test.persistance.PlayerDaoImpl;

public class PlayerDaoFactory {

	private PlayerDaoFactory() {};
	
	private static IPlayerDao playerDao=null;
	
	public static IPlayerDao getPlayerDao() {
		if(playerDao==null)
			playerDao=new PlayerDaoImpl();
		return playerDao;
	}
	
}
