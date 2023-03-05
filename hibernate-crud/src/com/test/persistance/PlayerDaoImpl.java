package com.test.persistance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.dto.Player;
import com.test.util.HibernateUtil;

public class PlayerDaoImpl implements IPlayerDao {

	Session session=HibernateUtil.getSession();
	@Override
	public String addPlayer(String name, Integer age, String team) {
		Transaction transaction=session.beginTransaction();
		boolean flag=false;
		String status="";
		try {
			if(transaction!=null) {
				Player player=new Player();
				player.setName(name);
				player.setAge(age);
				player.setTeam(team);
				session.save(player);
				flag=true;
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				status="success";
			} else {
				transaction.rollback();
				status="failure";
			}
		}
		return status;
	}
	@Override
	public Player searchPlayer(Integer jersyNo) {
		return null;
	}
	@Override
	public String updatePlayer(Integer jersyNo, String name, Integer age, String team) {
		return "";
	}
	@Override
	public String deletePlayer(Integer jersyNo) {
		
		return "failure";
	}
}
