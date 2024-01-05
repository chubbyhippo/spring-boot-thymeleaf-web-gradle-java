package com.example.demo.presentation;

import com.example.demo.infrastructure.ThymeleafConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(HomeController.class)
@Import(ThymeleafConfig.class)
class HomeControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return index page response")
    void shouldReturnIndexPageResponse() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"))
                .andExpect(view().name("redirect:/users"));
    }
}