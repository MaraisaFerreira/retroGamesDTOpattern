package com.study.mf.controllers;

import com.study.mf.model.Game;
import com.study.mf.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game findById(@PathVariable Long id){
        return gameService.findById(id);
    }

    @PostMapping
    public Game create(@RequestBody Game game){
        return gameService.create(game);
    }

    @PutMapping("/{id}")
    public Game update(
            @PathVariable Long id,
            @RequestBody Game game
    ){
        return gameService.update(id, game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){}
}
