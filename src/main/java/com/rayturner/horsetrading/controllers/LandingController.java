package com.rayturner.horsetrading.controllers;

import com.rayturner.horsetrading.repositories.PostgresHorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class LandingController {
    private PostgresHorseRepository repo;

    @Autowired
    public LandingController(PostgresHorseRepository repository){
        repo = repository;
    }

    @GetMapping
    public String getPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
            model.addAttribute("horses", repo.findAll());
        }
        return "landing";
    }

    @GetMapping("/{id}")
    public String getHorse(@PathVariable(value = "id") Integer id, Model model){
        var horse = repo.findById(id);
        if (horse.isPresent()) {
            model.addAttribute("horse", horse.get());
            return "horse";
        }
        return "horse";
    }
}
