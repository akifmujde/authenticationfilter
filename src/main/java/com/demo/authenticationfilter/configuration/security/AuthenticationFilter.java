package com.demo.authenticationfilter.configuration.security;

import com.demo.authenticationfilter.configuration.jwt.JwtProperties;
import com.demo.authenticationfilter.configuration.jwt.JwtRequestFilter;
import com.demo.authenticationfilter.configuration.jwt.JwtRequestVerifier;
import com.demo.authenticationfilter.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class AuthenticationFilter extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationService authenticationService;

    private final JwtProperties jwtProperties;

    private final SecretKey secretKey;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtRequestFilter(authenticationManager(), jwtProperties, secretKey))
                .addFilterAfter(new JwtRequestVerifier(secretKey,jwtProperties),JwtRequestFilter.class)
                .authorizeRequests()
                .antMatchers("/")
                    .permitAll()
                .anyRequest()
                .authenticated();
    }
}
