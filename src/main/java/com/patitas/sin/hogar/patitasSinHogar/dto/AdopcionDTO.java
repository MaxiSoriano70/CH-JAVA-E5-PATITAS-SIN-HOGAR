package com.patitas.sin.hogar.patitasSinHogar.dto;

import com.patitas.sin.hogar.patitasSinHogar.utils.EEspecie;
import com.patitas.sin.hogar.patitasSinHogar.utils.ESexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdopcionDTO {
    private String nombreMascota;
    private EEspecie especie;
    private ESexo sexo;
    private String descripcionMascota;
    private String publicador;
    private String adoptante;
    private LocalDate fechaDeAdopcion;
}
