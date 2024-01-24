package com.example.demo.presentation;

import com.example.demo.infrastructure.config.ThymeleafConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(TeamController.class)
@Import(ThymeleafConfig.class)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should return team list page")
    void shouldReturnTeamListPage() throws Exception {

        mockMvc.perform(get("/teams"))
                .andExpect(status().isOk())
                .andExpect(view().name("teams/list"));
    }

}