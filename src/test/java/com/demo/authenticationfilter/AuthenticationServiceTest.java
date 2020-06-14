package com.demo.authenticationfilter;

import com.demo.authenticationfilter.configuration.security.AuthenticationUser;
import com.demo.authenticationfilter.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
public class AuthenticationServiceTest {

    String USER_NAME = "admin";
    String USER_PASSWORD = "password";

    @Autowired
    AuthenticationService service;

    @Test
    public void test() {

        UserDetails user = service.loadUserByUsername(USER_NAME);

        if (user.getUsername().equals(USER_NAME))
            System.out.println("Username is success");

        if (!user.getAuthorities().isEmpty())
            System.out.println("Authorities are success");

        if (user.getPassword().equals(USER_PASSWORD))
            System.out.println("Password is success");

        if (user.getClass().equals(AuthenticationUser.class))
            System.out.println("User class is success");

    }

}
