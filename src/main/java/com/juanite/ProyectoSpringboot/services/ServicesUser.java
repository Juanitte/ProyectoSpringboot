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
    public List<User> findById(int id) {
        return repositoryUser.findById(id);
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
    public User insert(String name, int age, String email) {
        return repositoryUser.insert(name,age,email);
    }

    @Override
    public User update(String name, int age, String email, int id) {
        return repositoryUser.update(name,age,email,id);
    }

    @Override
    public User remove(int id) {
        return repositoryUser.remove(id);
    }
}
