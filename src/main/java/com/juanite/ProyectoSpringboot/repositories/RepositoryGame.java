package com.juanite.ProyectoSpringboot.repositories;

import com.juanite.ProyectoSpringboot.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryGame extends JpaRepository<Game,Long> {

    @Query(value = "SELECT * FROM games" , nativeQuery = true)
    public List<Game> findAll();

    @Query(value = "SELECT * FROM games WHERE code=?1" , nativeQuery = true)
    public List<Game> findByCode(@Param("code")int code);

    @Query(value = "SELECT * FROM games WHERE name LIKE ?1" , nativeQuery = true)
    public List<Game> filterByName(@Param("name")String name);

    @Query(value = "SELECT * FROM games WHERE category=?1" , nativeQuery = true)
    public List<Game> filterByCategory(@Param("category")String category);

    @Query(value = "SELECT games.* FROM games JOIN user_games ON games.code = user_games.game_code AND user_games.user_id=?1" , nativeQuery = true)
    public List<Game> findUserGames(@Param("user_id")int user_id);

    @Query(value = "INSERT INTO games(name,price) VALUES (?1,?2)" , nativeQuery = true)
    public Game insert(@Param("name")String name, @Param("price")double price);

    @Query(value = "UPDATE games SET name=?1, price=?2 WHERE code=?3" , nativeQuery = true)
    public Game update(@Param("name")String name, @Param("price")double price, @Param("code")int code);

    @Query(value = "DELETE FROM games WHERE code=?1", nativeQuery = true)
    public Game remove(@Param("code")int code);

}
