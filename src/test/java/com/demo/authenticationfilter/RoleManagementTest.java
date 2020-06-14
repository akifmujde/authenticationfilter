package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.*;
import com.demo.authenticationfilter.entity.compositekey.RoleManagementId;
import com.demo.authenticationfilter.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleManagementTest {

    @Autowired
    RoleManagementRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DatabaseProcessRepository processRepository;

    @Autowired
    ScopeRepository scopeRepository;

    @Autowired
    UserRepository userRepository;

    private String ROLE_PREFIX = "ROLE_";
    private String ADMIN_ROLE_NAME = "ADMIN";

    public String getAdminRole() {
        return ROLE_PREFIX + ADMIN_ROLE_NAME;
    }

    @Test
    public void roleManagementTest() {

        userRepository.deleteAll();
        repository.deleteAll();
        roleRepository.deleteAll();
        processRepository.deleteAll();
        scopeRepository.deleteAll();

        roleRepository.save(Role.of(ADMIN_ROLE_NAME));
        Role admin = roleRepository.findFirstByRoleName(getAdminRole());

        User user = userRepository.save(User.of("admin", "password", admin));

        processRepository.save(DatabaseProcess.of("read"));
        DatabaseProcess read = processRepository.findFirstByProcessName("read");

        scopeRepository.save(Scope.of("course"));
        Scope course = scopeRepository.findFirstByScopeName("course");

        repository.save(
                RoleManagement.of(
                        admin.getId(),
                        read.getId(),
                        course.getId()
                )
        );
        repository.save(
                RoleManagement.of(
                        admin.getId(),
                        read.getId(),
                        course.getId()
                )
        );
        repository.save(
                RoleManagement.of(
                        admin.getId(),
                        read.getId(),
                        course.getId()
                )
        );

        Long count = repository.count();

        if (count == 1)
            System.out.println("Save Success");
        else
            System.out.println("Save Fail");

        RoleManagement roleManagement = repository.findFirstByRole(admin);

        if( roleManagement.getRole().getRoleName().equals(admin.getRoleName()))
            System.out.println("Search Success");
        else
            System.out.println("Search Fail");
    }

}
