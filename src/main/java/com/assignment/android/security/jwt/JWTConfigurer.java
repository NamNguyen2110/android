package com.assignment.android.security.jwt;

import com.assignment.android.service.UserDetailsServiceImpl;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final TokenProvider tokenProvider;
    private final UserDetailsServiceImpl userDetailService;

    public JWTConfigurer(TokenProvider tokenProvider, UserDetailsServiceImpl userDetailService) {
        this.tokenProvider = tokenProvider;
        this.userDetailService = userDetailService;
    }

    @Override
    public void configure(HttpSecurity http) {
        var customFilter = new JWTFilter(tokenProvider, userDetailService);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
