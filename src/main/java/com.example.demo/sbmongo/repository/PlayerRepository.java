package com.example.demo.sbmongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import stackjava.com.sbmongo.entities.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String>{
	

	List<Player> findByName(String name);
	
    List<Player> findByNameLike(String name);

}
