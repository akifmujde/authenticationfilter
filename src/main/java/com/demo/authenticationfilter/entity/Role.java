package com.demo.authenticationfilter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public static Role of(String roleName) {

        String DEFAULT_ROLE_PREFIX = "ROLE_";

        Role role = new Role();

        role.setRoleName(DEFAULT_ROLE_PREFIX + roleName);

        return role;
    }
}
