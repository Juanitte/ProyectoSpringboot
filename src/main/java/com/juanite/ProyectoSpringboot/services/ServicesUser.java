package com.juanite.ProyectoSpringboot.services;

import com.juanite.ProyectoSpringboot.model.User;
import com.juanite.ProyectoSpringboot.repositories.RepositoryUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesUser implements InterfacesUser {

    RepositoryUser repositoryUser;

    public ServicesUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Override
    public List<User> findAll() {
        return repositoryUser.findAll();
    }

    @Override
    public User findById(int id) {
        return repositoryUser.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return repositoryUser.findByEmail(email);
    }

    @Override
    public List<User> filterByName(String name) {
        return repositoryUser.filterByName(name);
    }

    @Override
    public List<User> filterByEmail(String email) {
        return repositoryUser.filterByEmail(email);
    }

    @Override
    public void insert(User user) {
        repositoryUser.insert(user.getName(), user.getAge(), user.getEmail());
    }

    @Override
    public void update(String name, int age, String email, int id) {
        repositoryUser.update(name,age,email,id);
    }

    @Override
    public void remove(int id) {
        repositoryUser.remove(id);
    }

    @Override
    public void insertGame(int userId, int gameCode) {
        repositoryUser.insertGame(userId,gameCode);
    }
}
