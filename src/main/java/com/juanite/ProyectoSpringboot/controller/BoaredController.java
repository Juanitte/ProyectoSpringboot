package com.juanite.ProyectoSpringboot.controller;

import com.juanite.ProyectoSpringboot.model.Game;
import com.juanite.ProyectoSpringboot.model.User;
import com.juanite.ProyectoSpringboot.services.ServicesGame;
import com.juanite.ProyectoSpringboot.services.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoaredController {

    @Autowired
    private final ServicesGame servicesGame;

    @Autowired
    private final ServicesUser servicesUser;

    private User loggedUser = new User();

    private Game focusedGame = null;

    private List<Game> cartGames = new ArrayList<Game>();

    public BoaredController(ServicesGame servicesGame, ServicesUser servicesUser) {
        this.servicesGame = servicesGame;
        this.servicesUser = servicesUser;
    }

    @GetMapping("/boared")
    public String home(Model model) {
        model.addAttribute("name", loggedUser.getName());
        model.addAttribute("game", new Game());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        List<Game> games = servicesGame.findAll();
        model.addAttribute("games", games);
        return "index";
    }

    @GetMapping("/boared/user")
    public String user(Model model) {
        model.addAttribute("name", loggedUser.getName());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        List<Game> games = servicesGame.findAll();
        model.addAttribute("games", games);
        return "index";
    }

    @GetMapping("/boared/game")
    public String game(Model model) {
        model.addAttribute("game", focusedGame);
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
        model.addAttribute("games", cartGames);
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        double totalPrice = 0;
        for(Game game : cartGames){
            totalPrice += game.getPrice();
        }
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @GetMapping("/boared/login")
    public String login(Model model) {
        model.addAttribute("name", loggedUser.getName());
        model.addAttribute("user", new User());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        return "login";
    }

    @GetMapping("/boared/signup")
    public String signup(Model model) {
        model.addAttribute("name", loggedUser.getName());
        model.addAttribute("user", new User());
        if(loggedUser.getName().equals("Guest")) {
            model.addAttribute("log", "Log in");
        }else{
            model.addAttribute("log", "Log out");
        }
        return "signup";
    }

    @PostMapping("/boared/new")
    public RedirectView saveUser(@ModelAttribute("user") User user, Model model){
        if(servicesUser.findByEmail(user.getEmail()) == null) {
            servicesUser.insert(user);
        }
        return new RedirectView("/boared");
    }

    @PostMapping("/boared/logUser")
    public RedirectView logUser(@ModelAttribute("user") User user, Model model){
        if(servicesUser.findByEmail(user.getEmail()) != null) {
            user = servicesUser.findByEmail(user.getEmail());
            loggedUser = user;
        }
        return new RedirectView("/boared");
    }

    @PostMapping("/boared/logout")
    public RedirectView logout(Model model){
        loggedUser = new User();
        focusedGame = null;
        cartGames = new ArrayList<Game>();
        return new RedirectView("/boared");
    }

    @PostMapping("/boared/addGame")
    public RedirectView addGame(@ModelAttribute("game") int gameCode, Model model){
        if(servicesGame.findByCode(gameCode) != null) {
            Game game = servicesGame.findByCode(gameCode);
            cartGames.add(game);
        }
        return new RedirectView("/boared");
    }

    @PostMapping("/boared/purchase")
    public RedirectView purchase(Model model){
        loggedUser.getUser_games().addAll(cartGames);
        for(Game game : cartGames){
            servicesUser.insertGame(loggedUser.getId(), game.getCode());
        }
        cartGames.clear();
        return new RedirectView("/boared");
    }

}
