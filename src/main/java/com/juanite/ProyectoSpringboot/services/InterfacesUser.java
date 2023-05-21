package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.User;

import java.util.List;

public interface InterfacesUser {

    public List<User> findAll();

    public User findById(int id);

    public User findByEmail(String email);

    public List<User> filterByName(String name);

    public List<User> filterByEmail(String email);

    public void insert(User user);

    public void update(String name, int age, String email, int id);

    public void remove(int id);

    public void insertGame(int userId, int gameCode);

}
