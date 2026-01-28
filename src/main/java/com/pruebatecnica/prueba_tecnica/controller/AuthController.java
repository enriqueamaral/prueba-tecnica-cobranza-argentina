package com.pruebatecnica.prueba_tecnica.controller;

import com.pruebatecnica.prueba_tecnica.dto.*;
import com.pruebatecnica.prueba_tecnica.security.JwtUtil;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authManager,
            JwtUtil jwtUtil) {

        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        Authentication auth = authManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        // Usuario autenticado
        String username = auth.getName();

        // Obtener rol
        String role = auth.getAuthorities()
                .stream()
                .findFirst()
                .get()
                .getAuthority();

        // Generar token
        String token = jwtUtil.generateToken(username, role);

        return new LoginResponse(username, role, token);
    }
}