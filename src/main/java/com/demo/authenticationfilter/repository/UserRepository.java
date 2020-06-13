package com.demo.authenticationfilter.repository;

import com.demo.authenticationfilter.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByUsername(String username);
}
