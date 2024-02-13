package com.example.demo.presentation.controller;

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

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
}