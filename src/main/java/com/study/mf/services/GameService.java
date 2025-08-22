package com.study.mf.services;

import com.study.mf.exceptions.CustomResourceNotFound;
import com.study.mf.model.Game;
import com.study.mf.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<Game> findAll(){
        return repository.findAll();
    }

    public Game findById(Long id){
        return repository.findById(id).orElseThrow(() -> new CustomResourceNotFound("Game Not Found"));
    }

    public Game create(Game game){
        return repository.save(game);
    }

    public Game update(Long id, Game game){
        Game entity = repository.findById(id).orElseThrow(() -> new CustomResourceNotFound("Game Not Found"));
        entity.setName(game.getName());
        entity.setConsole(game.getConsole());
        entity.setYear(game.getYear());
        return repository.save(entity);
    }

    public void delete(Long id){
        Game game = repository.findById(id).orElseThrow(() -> new CustomResourceNotFound("Game Not Found"));
        repository.delete(game);
    }
}
