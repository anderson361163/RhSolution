package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("jesus", "Olá Mundo, Anderson");
        return "inicio.html";
    }

}
