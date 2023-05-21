package com.juanite.ProyectoSpringboot.repositories;

import com.juanite.ProyectoSpringboot.model.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryGame extends JpaRepository<Game,Long> {

    @Query(value = "SELECT * FROM games" , nativeQuery = true)
    public List<Game> findAll();

    @Query(value = "SELECT * FROM games WHERE code=?1" , nativeQuery = true)
    public Game findByCode(@Param("code")int code);

    @Query(value = "SELECT * FROM games WHERE name LIKE ?1" , nativeQuery = true)
    public List<Game> filterByName(@Param("name")String name);

    @Query(value = "SELECT * FROM games WHERE category=?1" , nativeQuery = true)
    public List<Game> filterByCategory(@Param("category")String category);

    @Query(value = "SELECT games.* FROM games JOIN user_games ON games.code = user_games.game_code AND user_games.user_id=?1" , nativeQuery = true)
    public List<Game> findUserGames(@Param("user_id")int user_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM games WHERE code=?1", nativeQuery = true)
    public void remove(@Param("code")int code);

    @Query(value = "SELECT games.code FROM games JOIN users_games ON games.code = users_games.games_code WHERE users_games.user_id = ?1", nativeQuery = true)
    public List<Integer> getUserGames(@Param("user_id")int userId);

}
