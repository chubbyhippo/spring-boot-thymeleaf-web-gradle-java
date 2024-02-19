package com.example.demo.presentation.controller;

import com.example.demo.application.dto.CreateUserDto;
import com.example.demo.application.service.UserService;
import com.example.demo.infrastructure.config.ThymeleafConfig;
import com.example.demo.shared.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserController.class)
@Import(ThymeleafConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("should return user list page")
    void shouldReturnUserListPage() throws Exception {
        when(userService.getUsers(any(Pageable.class)))
                .thenReturn(TestUtils.createPageOfResponseDtos());

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("users/list"));
    }

    @Test
    @DisplayName("should return user edit page")
    void shouldReturnUserEditPage() throws Exception {

        when(userService.getUsers(any(Pageable.class)))
                .thenReturn(TestUtils.createPageOfResponseDtos());

        mockMvc.perform(get("/users/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("users/edit"));
    }

    @Test
    @DisplayName("should redirect to users if valid")
    void shouldRedirectToUsersIfValid() throws Exception {

        doNothing().when(userService).createUser(any(CreateUserDto.class));
        var createUserDto = TestUtils.createCreateUserDto();

        mockMvc.perform(post("/users/create")
                        .flashAttr("user", createUserDto)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"));

    }

    @Test
    @DisplayName("should return to edit page if invalid")
    void shouldReturnToEditPageIfInvalid() throws Exception {

        doNothing().when(userService).createUser(any(CreateUserDto.class));
        var createUserDtoWithAllEmptyFields = CreateUserDto.builder().build();

        mockMvc.perform(post("/users/create")
                        .flashAttr("user", createUserDtoWithAllEmptyFields)
                )
                .andExpect(status().isOk())
                .andExpect(view().name("users/edit"));
    }
}