package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.DatabaseProcess;
import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.entity.RoleManagement;
import com.demo.authenticationfilter.entity.Scope;
import com.demo.authenticationfilter.entity.compositekey.RoleManagementId;
import com.demo.authenticationfilter.repository.DatabaseProcessRepository;
import com.demo.authenticationfilter.repository.RoleManagementRepository;
import com.demo.authenticationfilter.repository.RoleRepository;
import com.demo.authenticationfilter.repository.ScopeRepository;
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

    private String ROLE_PREFIX = "ROLE_";
    private String ROLE_NAME = "STUDENT";

    public String getRole() {
        return ROLE_PREFIX + ROLE_NAME;
    }

    @Test
    public void roleManagementTest() {

        repository.deleteAll();
        roleRepository.deleteAll();
        processRepository.deleteAll();
        scopeRepository.deleteAll();

        roleRepository.save(Role.of(ROLE_NAME));
        Role role = roleRepository.findFirstByRoleName(getRole());

        processRepository.save(DatabaseProcess.of("read"));
        DatabaseProcess databaseProcess = processRepository.findFirstByProcessName("read");

        scopeRepository.save(Scope.of("course"));
        Scope scope = scopeRepository.findFirstByScopeName("course");

        repository.save(
                RoleManagement.of(
                        role.getId(),
                        databaseProcess.getId(),
                        scope.getId()
                )
        );
        repository.save(
                RoleManagement.of(
                        role.getId(),
                        databaseProcess.getId(),
                        scope.getId()
                )
        );
        repository.save(
                RoleManagement.of(
                        role.getId(),
                        databaseProcess.getId(),
                        scope.getId()
                )
        );

        Long count = repository.count();

        if (count == 1)
            System.out.println("Save Success");
        else
            System.out.println("Save Fail");

        RoleManagement roleManagement = repository.findFirstByRole(role);

        if( roleManagement.getRole().getRoleName().equals(role.getRoleName()))
            System.out.println("Search Success");
        else
            System.out.println("Search Fail");
    }

}
