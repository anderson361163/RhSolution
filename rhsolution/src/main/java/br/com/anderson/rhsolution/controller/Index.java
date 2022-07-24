package br.com.anderson.rhsolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
	
    @GetMapping("/")
    public String inicio(Model model) {
        return "inicio.html";
    }

    @GetMapping("/inicio")
    public String inicioIndex(Model model) {
        return "inicio.html";
    }
}
