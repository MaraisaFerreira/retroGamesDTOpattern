package com.study.mf.services;

import com.study.mf.data.dto.GameDTO;
import com.study.mf.exceptions.CustomResourceNotFound;
import com.study.mf.model.Game;
import static com.study.mf.mappers.ObjectMapper.parseObject;
import static com.study.mf.mappers.ObjectMapper.parseListObject;
import com.study.mf.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<GameDTO> findAll(){
        List<Game> game = repository.findAll();
        return parseListObject(game, GameDTO.class);
    }

    public GameDTO findById(Long id){
        Game game = repository.findById(id).orElseThrow(() -> new CustomResourceNotFound("Game Not Found"));
        return parseObject(game, GameDTO.class);
    }

    public GameDTO create(GameDTO game){
        Game toSave = parseObject(game, Game.class);
        Game saved = repository.save(toSave);
        return parseObject(saved, GameDTO.class);
    }

    public GameDTO update(Long id, GameDTO game){
        Game entity = repository.findById(id).orElseThrow(() -> new CustomResourceNotFound("Game Not Found"));
        entity.setName(game.getName());
        entity.setConsole(game.getConsole());
        entity.setYear(game.getYear());
        Game saved = repository.save(entity);
        return parseObject(saved, GameDTO.class);
    }

    public void delete(Long id){
        Game game = repository.findById(id).orElseThrow(() -> new CustomResourceNotFound("Game Not Found"));
        repository.delete(game);
    }
}
