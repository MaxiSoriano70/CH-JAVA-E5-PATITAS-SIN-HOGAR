package com.patitas.sin.hogar.patitasSinHogar.entity;

import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ADOPCIONES")
public class Adopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdopcion;
    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;
    @ManyToOne
    @JoinColumn(name = "id_usuario_publicador", nullable = false)
    private Usuario publicador;
    @ManyToOne
    @JoinColumn(name = "id_usuario_adoptante", nullable = false)
    private Usuario adoptante;
    @Column(nullable = false)
    private LocalDate fechaDeAdopcion = LocalDate.now();
}
