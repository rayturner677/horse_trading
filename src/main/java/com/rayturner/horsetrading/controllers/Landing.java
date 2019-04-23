package com.rayturner.horsetrading.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class Landing {
    @GetMapping
    public String getPage(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "landing";
    }
}
