package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.entity.RoleManagement;
import com.demo.authenticationfilter.entity.User;
import com.demo.authenticationfilter.repository.RoleManagementRepository;
import com.demo.authenticationfilter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
public class AuthenticationUserTest {

    String USER_NAME = "admin";

    @Autowired
    UserRepository repo;

    @Autowired
    RoleManagementRepository roleManagementRepository;

    @Test
    public void authenticationUserTest() {

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        User user = repo.findFirstByUsername(USER_NAME);

        Role userRole = user.getRole();

        grantedAuthorities.add( new SimpleGrantedAuthority(userRole.getRoleName()) );

        if (grantedAuthorities.isEmpty())
            System.out.println("Role cannot added.");


        Set<SimpleGrantedAuthority> collect = roleManagementRepository.findByRole(userRole).stream()
                .map(m -> new SimpleGrantedAuthority(m.getScope().getScopeName() + ":" + m.getProcess().getProcessName()))
                .collect(Collectors.toSet());

        grantedAuthorities.addAll(collect);

        if (grantedAuthorities.size() > 1)
            System.out.println("Success");
        else
            System.out.println("Fail");
    }

}
