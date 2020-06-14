package com.demo.authenticationfilter;

import com.demo.authenticationfilter.configuration.jwt.JwtProperties;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;

@SpringBootTest
public class JwtTest {

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    SecretKey secretKey;

    @Test
    public void jwtTEst() {

        String verifyToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJha2lmbXVqZGUiLCJyb2xlIjoiYWRtaW4ifQ.iAtzY2xziQAOdjK-VzrLGNuNCcr9Yp0-HqoVxEw1-fw";

        String token = Jwts.builder()
                .setSubject("akifmujde")
                .claim("role", "admin")
                .signWith(secretKey)
                .compact();

        if (token.equals(verifyToken))
            System.out.println("Success");
        else
            System.out.println("fail token: " + token);
    }
}
