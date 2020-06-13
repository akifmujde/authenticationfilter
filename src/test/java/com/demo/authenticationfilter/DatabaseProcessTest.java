package com.demo.authenticationfilter;

import com.demo.authenticationfilter.entity.DatabaseProcess;
import com.demo.authenticationfilter.repository.DatabaseProcessRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseProcessTest {

    String CREATE = "create";
    String READ = "read";
    String UPDATE = "update";
    String DELETE = "delete";

    @Autowired
    DatabaseProcessRepository repository;

    @Test
    public void databaseProcessTest() {

        repository.deleteAll();

        repository.save(DatabaseProcess.of(CREATE));
        repository.save(DatabaseProcess.of(READ));
        repository.save(DatabaseProcess.of(UPDATE));
        repository.save(DatabaseProcess.of(DELETE));

        Long count = repository.count();

        if (count == 4)
            System.out.println("Success");
        else
            System.out.println("Fail");

    }
}
