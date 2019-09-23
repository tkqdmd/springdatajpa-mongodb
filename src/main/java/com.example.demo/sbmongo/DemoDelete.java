package com.example.demo.sbmongo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import stackjava.com.sbmongo.entities.Player;
import stackjava.com.sbmongo.repository.PlayerRepository;

@SpringBootApplication
public class DemoDelete {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoUpdate.class, args);
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);

		System.out.println("--------------- FindAll -----------------");
		List<Player> allPlayers = playerRepository.findAll();
		for(Player player: allPlayers) {
			System.out.println(player);
		}


		System.out.println("--------------- Delete -----------------");
		List<Player> result = playerRepository.findByName("Ronaldo");
		if(result == null) {
			System.out.println("Not found player with name Ronaldo");
		} else {
			for(Player player: result) {
				playerRepository.delete(player);
			}
			System.out.println("Deleted!");
		}
		System.out.println("--------------- FindAll After Delete -----------------");
		allPlayers = playerRepository.findAll();
		for(Player player: allPlayers) {
			System.out.println(player);
		}
		
	}
}
