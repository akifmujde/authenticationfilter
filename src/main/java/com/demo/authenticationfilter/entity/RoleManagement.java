package com.demo.authenticationfilter.entity;

import com.demo.authenticationfilter.entity.compositekey.RoleManagementId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role_management")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RoleManagement {

    @EmbeddedId
    private RoleManagementId id;

    @ManyToOne
    @MapsId("role_id")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @MapsId("process_id")
    @JoinColumn(name = "process_id")
    private DatabaseProcess process;

    @ManyToOne
    @MapsId("scope_id")
    @JoinColumn(name = "scope_id")
    private Scope scope;

    public static RoleManagement of(Integer roleId, Integer processId, Integer scopeId) {

        RoleManagement roleManagement = new RoleManagement();

        roleManagement.setId(RoleManagementId.of(roleId, processId, scopeId));

        return roleManagement;
    }
}
