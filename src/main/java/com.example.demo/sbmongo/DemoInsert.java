package com.example.demo.sbmongo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import stackjava.com.sbmongo.entities.Player;
import stackjava.com.sbmongo.repository.PlayerRepository;

@SpringBootApplication
public class DemoInsert {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoInsert.class, args);
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);

		System.out.println("--------------- Insert -----------------");
		Player player1 = new Player();
		player1.setName("Ronaldo");
		player1.setAge(33);
		player1.setFootballClub("Juventus");
		player1.setPosition("Striker");

		//System.out.println(playerRepository.findByName(player1.getName()).size());
		List<Player> findPlayer = playerRepository.findByName(player1.getName());
		if(playerRepository.findByName(player1.getName()).size()==0){
			playerRepository.save(player1);
		}
		else{
			System.out.println("Name existed. Please try again");
		}
		Player player2 = new Player();
		player2.setId("1");
		player2.setName("Ramos");
		player2.setAge(19);
		player2.setFootballClub("Real Madrid");
		player2.setPosition("Midfielder");

		if(playerRepository.findByName(player2.getName())==null){
			playerRepository.save(player2);
		}
		else{
			System.out.println("Name existed. Please try again");
		}
		
		System.out.println("--------------- FindAll -----------------");
		List<Player> allPlayers = playerRepository.findAll();
		for(Player player: allPlayers) {
			System.out.println(player);
		}
		
	}
}
