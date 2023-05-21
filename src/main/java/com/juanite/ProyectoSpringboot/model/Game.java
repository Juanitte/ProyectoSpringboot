package com.juanite.ProyectoSpringboot.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name="games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int code;

    @Column(name = "name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "category")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String category;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private double price;

    @ManyToMany(mappedBy = "user_games")
    private Set<User> users = new LinkedHashSet<>();

}
