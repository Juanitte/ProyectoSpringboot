package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.User;

import java.util.List;

public interface InterfacesUser {

    public List<User> findAll();

    public List<User> findById(int id);

    public List<User> filterByName(String name);

    public List<User> filterByEmail(String email);

    public User insert(String name, int age, String email);

    public User update(String name, int age, String email, int id);

    public User remove(int id);

}
