package com.quadrant.spring_sample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetWelcomeMessage() throws Exception {
        mockMvc.perform(get("/")) // Simulate a GET request to "/"
               .andExpect(status().isOk()) // Expect HTTP 200 status
               .andExpect(content().string("Hello world!!")); // Expect the response body to be "Hello world!!"
    }
}


