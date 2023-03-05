package com.test.servicefactory;

import com.test.service.IPlayerService;
import com.test.service.PlayerServiceImpl;

public class PlayerServiceFactory {
	private PlayerServiceFactory() {};
	
	private static IPlayerService playerService=null;
	
	public static IPlayerService getPlayerService() {
		if(playerService==null)
			playerService=new PlayerServiceImpl();
		return playerService;
	}
	
}
