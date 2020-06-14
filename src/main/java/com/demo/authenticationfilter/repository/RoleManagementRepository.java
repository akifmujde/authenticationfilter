package com.demo.authenticationfilter.repository;

import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.entity.RoleManagement;
import com.demo.authenticationfilter.entity.compositekey.RoleManagementId;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleManagementRepository extends CrudRepository<RoleManagement, RoleManagementId> {

    Set<RoleManagement> findByRole(Role role);

    RoleManagement findFirstByRole(Role role);
}
