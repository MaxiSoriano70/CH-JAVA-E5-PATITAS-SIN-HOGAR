package com.patitas.sin.hogar.patitasSinHogar.security.service;

import com.patitas.sin.hogar.patitasSinHogar.security.dto.AuthenticationRequest;
import com.patitas.sin.hogar.patitasSinHogar.security.dto.AuthenticationResponse;
import com.patitas.sin.hogar.patitasSinHogar.security.dto.RegisterRequest;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.security.repository.IUsuarioRepository;
import com.patitas.sin.hogar.patitasSinHogar.utils.ERol;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        ERol role = request.getRole() != null ? request.getRole() : ERol.USER;

        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .telefono(request.getTelefono())
                .role(role)
                .fechaDeRegistro(LocalDate.now())
                .build();
        usuarioRepository.save(usuario);
        String jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }


    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        String jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }
}
