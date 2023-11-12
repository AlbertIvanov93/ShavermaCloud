package com.example.shavermas;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.shavermas.data.IngredientRepository;
import com.example.shavermas.data.OrderRepository;
import com.example.shavermas.data.ShavermaRepository;
import com.example.shavermas.data.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for HomeController.
 * Annotation WebMvcTest runs test in context Spring MVC app.
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HomeControllerTest {

    /**
     * Injects MockMVC.
     */
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private IngredientRepository ingredientRepository;

    @MockBean
    private ShavermaRepository shavermaRepository;

    @MockBean
    private OrderRepository orderRepository;

    private User user = new User("asd", "asd", "asd", "asd", "asd", "asd", "1", "123");

    /**
     * Test for home page. It runs GET request and expects that response has status HTTP 200 (OK),
     * name of view is "home" and contains "Welcome to..." string.
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception {
        userRepository.save(user);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Welcome to...")));
    }
}
