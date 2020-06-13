package com.demo.authenticationfilter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean isAccountNonExpired;

    @Column
    private Boolean isAccountNonLocked;

    @Column
    private Boolean isCredentialsNonExpired;

    @Column
    private Boolean isEnabled;

    public static User of(
            String username,
            String password
    ) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsEnabled(true);

        return user;
    }

}
