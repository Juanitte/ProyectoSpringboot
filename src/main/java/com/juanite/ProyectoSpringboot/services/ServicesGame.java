package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.Game;
import com.juanite.ProyectoSpringboot.repositories.RepositoryGame;
import org.springframework.stereotype.Service;

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
    public List<Game> findByCode(int code) {
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
    public Game insert(String name, double price) {
        return repositoryGame.insert(name,price);
    }

    @Override
    public Game update(String name, double price, int code) {
        return repositoryGame.update(name,price,code);
    }

    @Override
    public Game remove(int code) {
        return repositoryGame.remove(code);
    }
}
