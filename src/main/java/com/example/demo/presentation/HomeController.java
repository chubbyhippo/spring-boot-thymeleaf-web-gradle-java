package com.example.demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    String index(Model model) {
        model.addAttribute("pageTitle", "Playing Thymeleaf");
        model.addAttribute("scientists", List.of("Albert Einstein",
                "Niels Bohr",
                "James Clerk Maxwell"));

        return "index";
    }
}
