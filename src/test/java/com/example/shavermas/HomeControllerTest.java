package com.example.shavermas;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for HomeController.
 * Annotation WebMvcTest runs test in context Spring MVC app.
 */
@WebMvcTest
public class HomeControllerTest {

    /**
     * Injects MockMVC.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test for home page. It runs GET request and expects that response has status HTTP 200 (OK),
     * name of view is "home" and contains "Welcome to..." string.
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Welcome to...")));
    }
}
