package com.example.demo.sbmongo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import stackjava.com.sbmongo.entities.Player;
import stackjava.com.sbmongo.repository.PlayerRepository;

@SpringBootApplication
public class DemoUpdate {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoUpdate.class, args);
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);

		System.out.println("--------------- FindAll -----------------");
		List<Player> allPlayers = playerRepository.findAll();
		for(Player player: allPlayers) {
			System.out.println(player);
		}
		
		System.out.println("--------------- Update -----------------");
		Player result = playerRepository.findById("1").orElse(null);
		if(result == null) {
			System.out.println("Not found player with id = 1");
		} else {
			result.setName("Marcelo");
			playerRepository.save(result);
			System.out.println("Updated!");
		}
		
		System.out.println("--------------- FindAll After Update -----------------");
		allPlayers = playerRepository.findAll();
		for(Player player: allPlayers) {
			System.out.println(player);
		}
		
	}
}
