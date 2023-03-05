package com.test.dto;

import java.io.Serializable;

public class Player implements Serializable{
	private static final long serialVersionUID=1L;
	private Integer jersyNo;
	private Integer age;
	private String name;
	private String team;
	
	
	public Integer getJersyNo() {
		return jersyNo;
	}
	public void setJersyNo(Integer id) {
		this.jersyNo = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "Player [id=" + jersyNo + ", age=" + age + ", name=" + name + ", team=" + team + "]";
	}

	
	
	

}
