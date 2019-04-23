package com.rayturner.horsetrading.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create-post")
public class NewPost {
    @GetMapping
    public String getPage(){
        return "newPost";
    }
    @PostMapping
    public String createNewPost(){
        return "newPost";
    }
}
