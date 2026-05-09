package com.example.fuegoypan.security;

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
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService userDetailsService
    ) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String path = request.getServletPath();

//  RUTAS PÚBLICAS (NO JWT)
        if (path.startsWith("/api/auth") || path.startsWith("/whatsapp")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        System.out.println("AUTH HEADER: " + authHeader);

        // Sin token
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {

            System.out.println("NO TOKEN");

            filterChain.doFilter(request, response);
            return;
        }

        try {

            final String jwt = authHeader.substring(7);

            System.out.println("JWT: " + jwt);

            final String username = jwtService.extractUsername(jwt);

            System.out.println("USERNAME: " + username);

            // Si no hay auth cargada
            if (username != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(username);

                System.out.println("USER FOUND: " + userDetails.getUsername());

                if (!jwtService.isTokenValid(jwt, userDetails)) {

                    System.out.println("TOKEN INVALID");

                    response.sendError(
                            HttpServletResponse.SC_UNAUTHORIZED,
                            "Token inválido"
                    );

                    return;
                }

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);

                System.out.println("AUTH OK");
            }

        } catch (Exception e) {

            System.out.println("JWT ERROR:");
            e.printStackTrace();

            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    e.getMessage()
            );

            return;
        }

        filterChain.doFilter(request, response);
    }
}