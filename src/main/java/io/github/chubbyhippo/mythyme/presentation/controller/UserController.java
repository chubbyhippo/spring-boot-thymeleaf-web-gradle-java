package io.github.chubbyhippo.mythyme.presentation.controller;

import io.github.chubbyhippo.mythyme.application.dto.RequestUserDto;
import io.github.chubbyhippo.mythyme.application.service.UserService;
import io.github.chubbyhippo.mythyme.domain.model.Gender;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model,
                        @SortDefault("lastname")
                        @SortDefault("firstname")
                        Pageable pageable) {
        model.addAttribute("users", service.getUsers(pageable));
        return "users/list";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", RequestUserDto.RequestUserDtoBuilder.aRequestUserDto().build());
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER, Gender.UNKNOWN));
        return "users/edit";
    }

    @PostMapping("/create")
    public String doCreateUser(@Validated @ModelAttribute("user") RequestUserDto requestUserDto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", List.of(Gender.MALE,
                    Gender.FEMALE,
                    Gender.OTHER,
                    Gender.UNKNOWN));
            return "users/edit";
        }

        service.createUser(requestUserDto);

        return "redirect:/users";
    }
}
