package com.patitas.sin.hogar.patitasSinHogar.dto;

import com.patitas.sin.hogar.patitasSinHogar.utils.ERol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaDeRegistro;
}
