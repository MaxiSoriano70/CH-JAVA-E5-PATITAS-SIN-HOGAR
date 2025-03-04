package com.patitas.sin.hogar.patitasSinHogar.dto;

import com.patitas.sin.hogar.patitasSinHogar.utils.EEspecie;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEstadoMascota;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEsterilizado;
import com.patitas.sin.hogar.patitasSinHogar.utils.ESexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private Integer edad;
    private ESexo sexo;
    private String colorDePelo;
    private String direccion;
    private EEspecie especie;
    private String raza;
    private EEsterilizado esterilizado;
    private Double pesoKg;
    private String descripcion;
    private String urlImagen;
    private LocalDate fechaPublicacion;
    private EEstadoMascota estadoMascota;
    private Integer idUsuario;
    public MascotaDTO(String nombre, LocalDate fechaDeNacimiento, ESexo sexo, String colorDePelo,
                      String direccion, EEspecie especie, String raza, EEsterilizado esterilizado,
                      Double pesoKg, String descripcion, String urlImagen, LocalDate fechaPublicacion,
                      EEstadoMascota estadoMascota, Integer idUsuario) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.edad = calcularEdad(fechaDeNacimiento);
        this.sexo = sexo;
        this.colorDePelo = colorDePelo;
        this.direccion = direccion;
        this.especie = especie;
        this.raza = raza;
        this.esterilizado = esterilizado;
        this.pesoKg = pesoKg;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoMascota = estadoMascota;
        this.idUsuario = idUsuario;
    }


    private Integer calcularEdad(LocalDate fechaDeNacimiento) {
        if (fechaDeNacimiento == null) {
            return null;
        }
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }
}
