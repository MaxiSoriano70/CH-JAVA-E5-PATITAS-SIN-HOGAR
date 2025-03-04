package com.patitas.sin.hogar.patitasSinHogar.security.controller;

import com.patitas.sin.hogar.patitasSinHogar.security.dto.AuthenticationRequest;
import com.patitas.sin.hogar.patitasSinHogar.security.dto.AuthenticationResponse;
import com.patitas.sin.hogar.patitasSinHogar.security.dto.RegisterRequest;
import com.patitas.sin.hogar.patitasSinHogar.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
