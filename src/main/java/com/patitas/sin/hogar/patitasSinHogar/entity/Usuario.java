package com.patitas.sin.hogar.patitasSinHogar.entity;

import com.patitas.sin.hogar.patitasSinHogar.utils.ETipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ETipoUsuario rol = ETipoUsuario.COMUN;
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaDeRegistro = LocalDateTime.now();
}
