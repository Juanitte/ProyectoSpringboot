package com.juanite.ProyectoSpringboot.repositories;

import com.juanite.ProyectoSpringboot.model.Game;
import com.juanite.ProyectoSpringboot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryUser extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM users" , nativeQuery = true)
    public List<User> findAll();

    @Query(value = "SELECT * FROM users WHERE id=?1" , nativeQuery = true)
    public List<User> findById(@Param("id")int id);

    @Query(value = "SELECT * FROM users WHERE name LIKE %?1%" , nativeQuery = true)
    public List<User> filterByName(@Param("name")String name);

    @Query(value = "SELECT * FROM users WHERE email=?1" , nativeQuery = true)
    public List<User> filterByEmail(@Param("email")String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users(name,age,email) VALUES (?1,?2,?3)" , nativeQuery = true)
    public User insert(@Param("name")String name, @Param("age")int age, @Param("email")String email);

    @Query(value = "UPDATE users SET name=?1, age=?2, email=?3 WHERE id=?4" , nativeQuery = true)
    public User update(@Param("name")String name, @Param("age")int age, @Param("email")String email, @Param("id")int id);

    @Query(value = "DELETE FROM users WHERE id=?1", nativeQuery = true)
    public User remove(@Param("id")int id);

}
