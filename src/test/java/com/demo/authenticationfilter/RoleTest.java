package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.repository.RoleRepository;
import com.demo.authenticationfilter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

    private String ROLE_PREFIX = "ROLE_";
    private String ROLE_NAME = "STUDENT";

    public String getRole() {
        return ROLE_PREFIX + ROLE_NAME;
    }

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void roleTest() {

        userRepository.deleteAll();
        roleRepository.deleteAll();

        roleRepository.save(Role.of(ROLE_NAME));

        Role student = roleRepository.findFirstByRoleName(getRole());

        System.out.println(student.getRoleName());

    }
}
