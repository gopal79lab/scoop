package com.tsl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration ;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Disable CSRF for simplicity
//                .authorizeRequests()
//                .antMatchers("/api/auth/signup", "/api/auth/login").permitAll() // Allow signup and login
//                .anyRequest().authenticated(); // Protect other endpoints
//        return http.build(); // Build the security filter chain
//    }
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/auth/signup", "/api/auth/login").permitAll() // Allow signup and login
                        .anyRequest().authenticated() // Protect other endpoints
                );
        return http.build(); // Build the security filter chain
    }
}
