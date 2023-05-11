package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.Game;

import java.util.List;

public interface InterfacesGame {

    public List<Game> findAll();

    public List<Game> findByCode(int code);

    public List<Game> filterByName(String name);

    public List<Game> filterByCategory(String category);

    public List<Game> findUserGames(int user_id);

    public Game insert(String name, double price);

    public Game update(String name, double price, int code);

    public Game remove(int code);

}
