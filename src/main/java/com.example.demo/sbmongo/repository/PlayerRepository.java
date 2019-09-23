package com.example.demo.sbmongo.repository;

import java.util.List;

import com.example.demo.sbmongo.entities.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {


    List<Player> findByName(String name);

    List<Player> findByNameLike(String name);

}
