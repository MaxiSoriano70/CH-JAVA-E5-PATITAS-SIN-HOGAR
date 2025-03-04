package com.patitas.sin.hogar.patitasSinHogar.entity;

import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEspecie;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEstadoMascota;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEsterilizado;
import com.patitas.sin.hogar.patitasSinHogar.utils.ESexo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "MASCOTAS")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ESexo sexo;
    private String colorDePelo;
    @Column(nullable = false)
    private String direccion;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EEspecie eEspecie;
    private String raza;
    @Enumerated(EnumType.STRING)
    private EEsterilizado esterilizado;
    @Column(nullable = false)
    private Double pesoKg;
    private String descripcion;
    @Column(nullable = false)
    private String urlImagen;
    @Column(nullable = false)
    private LocalDate fechaPublicacion = LocalDate.now();
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EEstadoMascota estadoMascota = EEstadoMascota.EN_ADOPCION;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
