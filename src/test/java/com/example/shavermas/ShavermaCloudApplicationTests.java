package com.example.shavermas;

import com.example.shavermas.security.RegistrationController;
import com.example.shavermas.web.DesignShavermaController;
import com.example.shavermas.web.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test of Spring Boot app.
 */
@SpringBootTest
class ShavermaCloudApplicationTests {

	@Autowired
	DesignShavermaController designShavermaController;

	@Autowired
	OrderController orderController;

	@Autowired
	RegistrationController registrationController;

	/**
	 * Test method.
	 */
	@Test
	void contextLoads() {
		assertThat(designShavermaController).isNotNull();
        assertThat(orderController).isNotNull();
        assertThat(registrationController).isNotNull();
	}

}
