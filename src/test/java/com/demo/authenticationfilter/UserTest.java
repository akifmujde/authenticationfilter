package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.User;
import com.demo.authenticationfilter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    String USER_NAME = "admin";
    String USER_PASSWORD = "password";

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        
        userRepository.save(User.of(USER_NAME, USER_PASSWORD));

        User user = userRepository.findFirstByUsername(USER_NAME);

        System.out.println(user.getUsername());

    }

}
