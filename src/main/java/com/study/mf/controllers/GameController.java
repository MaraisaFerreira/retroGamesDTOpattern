package com.study.mf.controllers;

import com.study.mf.model.Game;
import com.study.mf.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> findAll(){
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.create(game));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(
            @PathVariable Long id,
            @RequestBody Game game
    ){
        return ResponseEntity.ok(gameService.update(id, game));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
