package com.example.Insurance_backend.configuration;


import com.example.Insurance_backend.filter.JwtFilter;
import com.example.Insurance_backend.service.impl.CustormUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustormUserDetailsService custormUserDetailsService;
    private  final  JwtUtils jwtUtils;

    public SecurityConfig(CustormUserDetailsService custormUserDetailsService, JwtUtils jwtUtils) {
        this.custormUserDetailsService = custormUserDetailsService;
        this.jwtUtils = jwtUtils;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                 .requestMatchers("/api/auth/**").permitAll()

                                 .requestMatchers(HttpMethod.GET, "/api/insurances/**").hasAnyRole("USER", "ADMIN")
                                 .requestMatchers(HttpMethod.POST, "/api/insurances/**").hasRole("ADMIN")
                                 .requestMatchers(HttpMethod.PATCH, "/api/insurances/**").hasRole("ADMIN")
                                 .requestMatchers(HttpMethod.DELETE, "/api/insurances/**").hasRole("ADMIN")

                                 .requestMatchers(HttpMethod.GET, "/api/subscriptions/**").hasAnyRole("USER", "ADMIN")
                                 .requestMatchers(HttpMethod.POST, "/api/subscriptions/**").hasAnyRole("USER", "ADMIN")
                                 .requestMatchers(HttpMethod.PATCH,"/api/subscriptions/**").hasRole("ADMIN")
                                 .requestMatchers(HttpMethod.DELETE,"/api/subscriptions/**").hasRole("ADMIN")

                                 .requestMatchers("/api/users/**").hasRole("ADMIN")

                                .anyRequest().authenticated())
                .addFilterBefore(new JwtFilter(custormUserDetailsService, jwtUtils), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(custormUserDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }


}
