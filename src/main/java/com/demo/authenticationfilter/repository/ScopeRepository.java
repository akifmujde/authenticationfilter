package com.demo.authenticationfilter.repository;

import com.demo.authenticationfilter.entity.Scope;
import org.springframework.data.repository.CrudRepository;

public interface ScopeRepository extends CrudRepository<Scope, Integer> {

    Scope findFirstByScopeName(String scopeName);
}
