package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.Game;
import com.juanite.ProyectoSpringboot.repositories.RepositoryGame;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ServicesGame implements InterfacesGame {

    RepositoryGame repositoryGame;

    public ServicesGame(RepositoryGame repositoryGame){
        this.repositoryGame = repositoryGame;
    }

    @Override
    public List<Game> findAll() {
        return repositoryGame.findAll();
    }

    @Override
    public Game findByCode(int code) {
        return repositoryGame.findByCode(code);
    }

    @Override
    public List<Game> filterByName(String name) {
        return repositoryGame.filterByName(name);
    }

    @Override
    public List<Game> filterByCategory(String category) {
        return repositoryGame.filterByCategory(category);
    }

    @Override
    public List<Game> findUserGames(int user_id) {
        return repositoryGame.findUserGames(user_id);
    }

    @Override
    public void save(Game game){
        repositoryGame.save(game);
    }

    @Override
    public void remove(int code) {
        repositoryGame.remove(code);
    }

    @Override
    public List<Game> getUserGames(int userId) {
        List<Game> games = new LinkedList<>();
        List<Integer> codes = repositoryGame.getUserGames(userId);
        for(Integer code : codes){
            games.add(repositoryGame.findByCode(code));
        }

        return games;
    }
}
