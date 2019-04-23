package com.rayturner.horsetrading.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SignUP {
    @GetMapping
    public String getInfo() {
        return "sign-up";
    }

    @PostMapping
    public String saveInfo() {
        return "sign-up";
    }
}
