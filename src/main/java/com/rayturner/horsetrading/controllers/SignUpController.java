package com.rayturner.horsetrading.controllers;

import com.rayturner.horsetrading.forms.OwnerForm;
import com.rayturner.horsetrading.repositories.PostgresOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {
    @GetMapping
    public String getInfo() {
        return "sign-up";
    }

    @PostMapping
    public String saveInfo(OwnerForm owner, PostgresOwnerRepository repository) {
        if (owner.is_valid()){
            repository.save(owner);
            return "redirect:/";
        }
        return "sign-up";
    }
}
