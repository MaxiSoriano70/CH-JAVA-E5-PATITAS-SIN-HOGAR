package com.patitas.sin.hogar.patitasSinHogar.service;

import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    Mascota crearMascota(Mascota mascota);
    Optional<Mascota> buscarPorId(int id);
    List<Mascota> trearTodasMascotas();
    void actualizarMascota(Mascota mascota);
    void eliminarMascota(Integer id);
}
