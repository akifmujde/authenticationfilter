package com.demo.authenticationfilter.repository;

import com.demo.authenticationfilter.entity.DatabaseProcess;
import org.springframework.data.repository.CrudRepository;

public interface DatabaseProcessRepository extends CrudRepository<DatabaseProcess, Integer> {

    DatabaseProcess findFirstByProcessName(String processName);
}
