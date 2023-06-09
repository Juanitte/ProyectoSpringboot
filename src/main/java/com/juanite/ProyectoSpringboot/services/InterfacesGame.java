package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.Game;

import java.util.List;

public interface InterfacesGame {

    public List<Game> findAll();

    public Game findByCode(int code);

    public List<Game> filterByName(String name);

    public List<Game> filterByCategory(String category);

    public List<Game> findUserGames(int user_id);

    public void save(Game game);

    public void remove(int code);

    public List<Game> getUserGames(int userId);

}
