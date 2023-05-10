package com.juanite.ProyectoSpringboot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BoaredController {

    @GetMapping("/boared/{name}")
    public String home(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/boared/{name}/{game}")
    public String game(Model model, @PathVariable String name, @PathVariable String game) {
        model.addAttribute("name", name);
        model.addAttribute("game", game);
        return "index";
    }

    @GetMapping("/boared/{name}/cart")
    public String cart(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        return "index";
    }

}
