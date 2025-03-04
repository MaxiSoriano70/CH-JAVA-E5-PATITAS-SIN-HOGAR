package com.patitas.sin.hogar.patitasSinHogar.security.dto;
import com.patitas.sin.hogar.patitasSinHogar.utils.ERol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private ERol role;
}
