package com.test.persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.dto.Player;
import com.test.util.JdbcUtil;

public class PlayerDaoImpl implements IPlayerDao {

	Connection connection=null;
	PreparedStatement pstmnt=null;
	ResultSet resultSet=null;
	@Override
	public String addPlayer(Integer jersyNo, String name, Integer age, String team) {
		String sqlQuery="insert into player(`jersyNo`,`name`,`age`,`team`) values(?,?,?,?)";
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(sqlQuery);
			}
			if(pstmnt!=null) {
				pstmnt.setInt(1,jersyNo);
				pstmnt.setString(2,name);
				pstmnt.setInt(3,age);
				pstmnt.setString(4,team);
				
				int rowAffected=pstmnt.executeUpdate();
				if(rowAffected==1)
					return "success";
			}
		} catch(SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}
	@Override
	public Player searchPlayer(Integer jersyNo) {
		String sqlQuery="select jersyNo,name,age,team from player where jersyNo=?";
		Player player=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(sqlQuery);
			}
			if(pstmnt!=null) {
				pstmnt.setInt(1,jersyNo);
				resultSet=pstmnt.executeQuery();
			}
			if(resultSet!=null) {
				if(resultSet.next()) {
					player=new Player();
					player.setJersyNo(resultSet.getInt(1));
					player.setName(resultSet.getString(2));
					player.setAge(resultSet.getInt(3));
					player.setTeam(resultSet.getString(4));
				}
			}
		} catch(SQLException | IOException e) {
			e.getMessage();
		}
		return player;
	}
	@Override
	public String updatePlayer(Integer jersyNo, String name, Integer age, String team) {
		String sqlQuery="update player set name=?, age=?, team=? where jersyNo=?";
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(sqlQuery);
			}
			if(pstmnt!=null) {
				pstmnt.setString(1,name);
				pstmnt.setInt(2,age);
				pstmnt.setString(3,team);
				pstmnt.setInt(4,jersyNo);
				
				int rowAffected=pstmnt.executeUpdate();
				if(rowAffected==1)
					return "success";
			}
		} catch(SQLException | IOException e) {
			e.getMessage();
		}

		
		return "failure";
	}
	@Override
	public String deletePlayer(Integer jersyNo) {
		String sqlQuery="delete from player where jersyNo=?";
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(sqlQuery);
			}
			if(pstmnt!=null) {
				pstmnt.setInt(1,jersyNo);
				int rowAffected=pstmnt.executeUpdate();
				if(rowAffected==1)
					return "success";
				else 
					return "NotFound";
			}
		} catch(SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}
}
