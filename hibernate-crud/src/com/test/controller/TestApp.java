package com.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.test.dto.Player;
import com.test.service.IPlayerService;
import com.test.servicefactory.PlayerServiceFactory;

public class TestApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			String option = br.readLine();
			
			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateRecord();
				break;
			case "4":
				deleteRecord();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}
		}
	}

	private static void deleteRecord() {
		// TODO Auto-generated method stub
		IPlayerService playerService=PlayerServiceFactory.getPlayerService();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the jersy number of player");
		Integer jersyNo=sc.nextInt();
		String status=playerService.deletePlayer(jersyNo);
		if(status.equalsIgnoreCase("success"))
			System.out.println("Record deleted successfully");
		else if(status.equalsIgnoreCase("notfound"))
			System.out.println("Player with jersy number "+jersyNo+" not found");
		else
			System.out.println("Record deletion failed");
		
	}

	private static void updateRecord() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the player jersy number to be updated:: ");
		String jersyNo = br.readLine();
		IPlayerService playerService=PlayerServiceFactory.getPlayerService();
		Player player=playerService.searchPlayer(Integer.parseInt(jersyNo));
		
		if(player!=null) {
			Player newPlayer=new Player();
			System.out.println("Jersy number is "+player.getJersyNo());
			newPlayer.setJersyNo(player.getJersyNo());
			
			System.out.println("Player old name is "+player.getName()+" Enter new name: ");
			String newName=br.readLine();
			if(newName.equals("") || newName=="") {
				newPlayer.setName(player.getName());
			} else
				newPlayer.setName(newName);
			
			System.out.println("Player old age is "+player.getAge()+" Enter new age: ");
			String newAge=br.readLine();
			if(newAge.equals("") || newAge=="")
				newPlayer.setAge(player.getAge());
			else
				newPlayer.setAge(Integer.parseInt(newAge));
			
			System.out.println("Player old team is "+player.getTeam()+" Enter new team: ");
			String newTeam=br.readLine();
			if(newTeam.equals("") || newTeam=="")
				newPlayer.setTeam(player.getTeam());
			else
				newPlayer.setTeam(newTeam);
			
			System.out.println(newPlayer.getJersyNo()+newPlayer.getName()+newPlayer.getAge()+newPlayer.getTeam());
			
			String status=playerService.updatePlayer(newPlayer.getJersyNo(),newPlayer.getName(),newPlayer.getAge(),newPlayer.getTeam());
			if(status.equalsIgnoreCase("success"))
				System.out.println("Record updated successfully");
			else
				System.out.println("Record updation failed");
		} else 
			System.out.println("Player with jersy number "+jersyNo+" does not exist");
	}

	private static void selectOperation() {
		// TODO Auto-generated method stub
		IPlayerService playerService=PlayerServiceFactory.getPlayerService();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the jersy number of player");
		Integer jersyNo=sc.nextInt();
		Player player=playerService.searchPlayer(jersyNo);
		
		if(player!=null) {
			System.out.println("PLAYER DETAILS");
			System.out.println("--------------------------------------------------------------");
			System.out.println("Jersy number: "+player.getJersyNo());
			System.out.println("Name: "+player.getName());
			System.out.println("Age: "+player.getAge());
			System.out.println("Team: "+player.getTeam());
		} else {
			System.out.println("Player not found for jersy number "+jersyNo);
		}
	}

	private static void insertOperation() {
		// TODO Auto-generated method stub
		IPlayerService playerService=PlayerServiceFactory.getPlayerService();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the jersy number of player");
		Integer jersyNo=sc.nextInt();
		System.out.println("Enter the name of player");
		String name=sc.next();
		System.out.println("Enter the age of player");
		Integer age=sc.nextInt();
		System.out.println("Enter the team of player");
		String team=sc.next();
		
		String status=playerService.addPlayer(jersyNo, name, age, team);
		if(status.equalsIgnoreCase("success"))
			System.out.println("Record inserted successfully");
		else
			System.out.println("Record insertion failed");
		
	}

}
