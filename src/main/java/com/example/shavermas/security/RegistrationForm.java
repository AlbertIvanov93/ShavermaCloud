package com.example.shavermas.security;

import com.example.shavermas.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Links to registration form "/register"
 */
@Data
public class RegistrationForm {

    private final String username;
    private final String password;
    private final String fullname;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String phoneNumber;

    /**
     * Creates new User obj from a registration form.
     * @param passwordEncoder PasswordEncoder.
     * @return new User obj.
     */
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phoneNumber);
    }
}
