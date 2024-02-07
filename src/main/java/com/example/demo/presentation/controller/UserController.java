package com.example.demo.presentation.controller;

import com.example.demo.application.dto.CreateUserDto;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.model.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public String index(Model model,
                        @SortDefault("lastname")
                        @SortDefault("firstname")
                        Pageable pageable) {
        model.addAttribute("users", service.getUsers(pageable));
        return "users/list";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) { //<.>
        model.addAttribute("user", CreateUserDto.builder().build());
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER, Gender.UNKNOWN));
        return "users/edit";
    }
}
