package com.study.mf.services;

import com.study.mf.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    public List<Game> findAll(){
        return new ArrayList<>(List.of(
                new Game(1L, "Super Mario World", "SNES", 1991)
        ));
    }

    public Game findById(Long id){
        return new Game(id, "Mario kart", "SNES", 1992);
    }

    public Game create(Game game){
        game.setId(2L);
        return game;
    }

    public Game update(Long id, Game game){
        game.setName(game.getName() +" Updated");
        return game;
    }

    public void delete(Long id){}
}
