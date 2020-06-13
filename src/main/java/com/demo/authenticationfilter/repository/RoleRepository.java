package com.demo.authenticationfilter.repository;

import com.demo.authenticationfilter.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findFirstByRoleName(String roleName);

}
