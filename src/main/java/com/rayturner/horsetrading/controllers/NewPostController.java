package com.rayturner.horsetrading.controllers;

import com.rayturner.horsetrading.forms.HorseForm;
import com.rayturner.horsetrading.repositories.PostgresHorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/create-post")

public class NewPostController {
    private PostgresHorseRepository repository;

    @Autowired
    public NewPostController(PostgresHorseRepository horseRepository){
        repository = horseRepository;
    }

    @GetMapping
    public String getPage(){
        return "newPost";
    }


    @PostMapping()
    public String createNewPost(HorseForm form, Principal principal){
        String owner = principal.getName();
        form.owner = owner;
        if(form.is_valid()){
            repository.save(form);
            return "redirect:/";
        }
        return "newPost";
    }
}
