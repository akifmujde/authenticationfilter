package com.demo.authenticationfilter.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin() {
        return "admin";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('admin:create')")
    public String adminCreate() {
        return "admin:create";
    }

}
