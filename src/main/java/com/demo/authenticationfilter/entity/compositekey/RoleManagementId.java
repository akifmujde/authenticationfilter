package com.demo.authenticationfilter.entity.compositekey;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RoleManagementId implements Serializable {

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "process_id")
    private Integer processId;

    @Column(name = "scope_id")
    private Integer scopeId;

    public static RoleManagementId of(Integer roleId, Integer processId, Integer scopeId) {

        RoleManagementId id = new RoleManagementId();

        id.setRoleId(roleId);
        id.setProcessId(processId);
        id.setScopeId(scopeId);

        return id;
    }
}
