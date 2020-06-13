package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.entity.User;
import com.demo.authenticationfilter.repository.RoleRepository;
import com.demo.authenticationfilter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    private String USER_NAME = "admin";
    private String USER_PASSWORD = "password";

    private String ROLE_PREFIX = "ROLE_";
    private String ROLE_NAME = "STUDENT";

    public String getRole() {
        return ROLE_PREFIX + ROLE_NAME;
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void userTest() {

        userRepository.deleteAll();
        roleRepository.deleteAll();

        roleRepository.save(Role.of(ROLE_NAME));

        Role admin = roleRepository.findFirstByRoleName(getRole());

        userRepository.save(User.of(USER_NAME, USER_PASSWORD, admin));

        User user = userRepository.findFirstByUsername(USER_NAME);

        System.out.println(user.getUsername());

        Role userRole = user.getRole();

        if (userRole.getRoleName().equals(admin.getRoleName()))
            System.out.println("Success");
        else
            System.out.println("Fail");

    }

}
