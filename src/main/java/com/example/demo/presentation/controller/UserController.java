package com.example.demo.presentation.controller;

import com.example.demo.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public String index(Model model,
                        Pageable pageable) {
        model.addAttribute("users", service.getUsers(pageable));
        return "users/list";
    }
}
