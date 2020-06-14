package com.demo.authenticationfilter.repository;

import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.entity.RoleManagement;
import com.demo.authenticationfilter.entity.compositekey.RoleManagementId;
import org.springframework.data.repository.CrudRepository;

public interface RoleManagementRepository extends CrudRepository<RoleManagement, RoleManagementId> {

    RoleManagement findFirstByRole(Role role);
}
