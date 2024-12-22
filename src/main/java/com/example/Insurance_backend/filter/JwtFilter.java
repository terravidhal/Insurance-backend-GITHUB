package com.example.Insurance_backend.filter;


import com.example.Insurance_backend.configuration.JwtUtils;
import com.example.Insurance_backend.service.impl.CustormUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final CustormUserDetailsService custormUserDetailsService;
    private final JwtUtils jwtUtils;


    public JwtFilter(CustormUserDetailsService custormUserDetailsService, JwtUtils jwtUtils) {
        this.custormUserDetailsService = custormUserDetailsService;
        this.jwtUtils = jwtUtils;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        if(authHeader !=null && authHeader.startsWith("Bearer ")){
            jwt = authHeader.substring(7);
            username = jwtUtils.extractUsername(jwt);
        }

        if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = custormUserDetailsService.loadUserByUsername(username);

            if (jwtUtils.validateToken(jwt,userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
