package com.example.demo.entrypoints.rest.controller;

import com.example.demo.configuration.UseCaseConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
@Import({UseCaseConfiguration.class, RestExceptionHandler.class})
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGreetingForValidRequest() throws Exception {
        mockMvc.perform(post("/api/v1/greetings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Andrea\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recipient").value("Andrea"))
                .andExpect(jsonPath("$.message").value("Hola, Andrea!"));
    }

    @Test
    void shouldReturnBadRequestForBlankName() throws Exception {
        mockMvc.perform(post("/api/v1/greetings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\" \"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }
}
