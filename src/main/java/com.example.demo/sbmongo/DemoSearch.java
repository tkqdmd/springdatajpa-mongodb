package com.example.demo.sbmongo;

import java.util.List;

import com.example.demo.sbmongo.entities.Player;
import com.example.demo.sbmongo.repository.PlayerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoSearch {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoSearch.class, args);
        PlayerRepository playerRepository = context.getBean(PlayerRepository.class);

        System.out.println("--------------- Find Player Where name = 'Ronaldo' -----------------");
        List<Player> list1 = playerRepository.findByName("Ronaldo");
        for (Player player : list1) {
            System.out.println(player);
        }

        System.out.println("--------------- Find Player Where name contains 'Ra' -----------------");
        List<Player> list2 = playerRepository.findByNameLike("Ra");
        for (Player player : list2) {
            System.out.println(player);
        }

    }
}
