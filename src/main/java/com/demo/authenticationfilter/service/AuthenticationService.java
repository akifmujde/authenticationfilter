package com.demo.authenticationfilter.service;

import com.demo.authenticationfilter.configuration.security.AuthenticationUser;
import com.demo.authenticationfilter.entity.Role;
import com.demo.authenticationfilter.entity.User;
import com.demo.authenticationfilter.repository.RoleManagementRepository;
import com.demo.authenticationfilter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleManagementRepository roleManagementRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AuthenticationUser authenticationUser = new AuthenticationUser();

        User user = userRepository.findFirstByUsername(username);
        Role role = user.getRole();
        String roleName = role.getRoleName();

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(roleName));

        Set<SimpleGrantedAuthority> collect = roleManagementRepository.findByRole(role).stream()
                .map(m -> new SimpleGrantedAuthority(m.getScope().getScopeName() + ":" + m.getProcess().getProcessName()))
                .collect(Collectors.toSet());

        grantedAuthorities.addAll(collect);

        authenticationUser.setUsername(user.getUsername());
        authenticationUser.setPassword(user.getPassword());
        authenticationUser.setIsAccountNonExpired(user.getIsAccountNonExpired());
        authenticationUser.setIsAccountNonLocked(user.getIsAccountNonLocked());
        authenticationUser.setIsCredentialsNonExpired(user.getIsCredentialsNonExpired());
        authenticationUser.setIsEnabled(user.getIsEnabled());
        authenticationUser.setAuthorities(grantedAuthorities);

        return authenticationUser;
    }
}
