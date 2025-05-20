package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Value("${api.key}")
    private String apiKey;

    private static final String header = "X-API-KEY";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String providedKey = request.getHeader(header);
        if (providedKey != null && providedKey.equals(apiKey)) {
            SecurityContextHolder.getContext().setAuthentication(new ApiKeyAuth(providedKey, AuthorityUtils.NO_AUTHORITIES));
        }
        filterChain.doFilter(request, response);
    }
}