package com.juanite.ProyectoSpringboot.controller;

import com.juanite.ProyectoSpringboot.model.Game;
import com.juanite.ProyectoSpringboot.model.User;
import com.juanite.ProyectoSpringboot.services.ServicesGame;
import com.juanite.ProyectoSpringboot.services.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoaredController {

    @Autowired
    private final ServicesGame servicesGame;

    @Autowired
    private final ServicesUser servicesUser;

    private User loggedUser = new User();

    public BoaredController(ServicesGame servicesGame, ServicesUser servicesUser) {
        this.servicesGame = servicesGame;
        this.servicesUser = servicesUser;
    }

    @GetMapping("/boared")
    public String home(Model model) {
        model.addAttribute("name", loggedUser.getName());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        List<Game> games = servicesGame.findAll();
        System.out.println(games.get(0).getName());
        return "index";
    }

    @GetMapping("/boared/{game}")
    public String game(Model model, @PathVariable String game) {
        model.addAttribute("game", game);
        model.addAttribute("name", loggedUser.getName());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        return "game";
    }

    @GetMapping("/boared/cart")
    public String cart(Model model) {
        model.addAttribute("name", loggedUser.getName());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        return "cart";
    }

}
