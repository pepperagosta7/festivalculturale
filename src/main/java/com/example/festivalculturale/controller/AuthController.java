package com.example.festivalculturale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.festivalculturale.model.Utente;
import com.example.festivalculturale.service.UtenteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UtenteService utenteService;

    @GetMapping("/registrazione")
    public String showFormRegstrazione(Model model) {
        model.addAttribute("utente", new Utente());
        return "registrazione";
    }

    @PostMapping("/registrazione")
    public String registrazione(@ModelAttribute Utente utente) {
        utenteService.registrazione(utente);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String showFormLogin() {
        return "login";
    }
}
