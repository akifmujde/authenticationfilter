package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.Scope;
import com.demo.authenticationfilter.repository.ScopeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScopeTest {

    String SCOPE_NAME = "course";

    @Autowired
    ScopeRepository scopeRepository;

    @Test
    public void scopeTest() {

        scopeRepository.deleteAll();

        scopeRepository.save(Scope.of(SCOPE_NAME));

        Scope scope = scopeRepository.findFirstByScopeName(SCOPE_NAME);

        if(scope.getScopeName().equals(SCOPE_NAME))
            System.out.println("Success");
        else
            System.out.println("Fail");
    }
}
