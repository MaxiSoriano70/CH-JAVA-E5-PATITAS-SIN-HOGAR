package com.patitas.sin.hogar.patitasSinHogar.service;

import com.patitas.sin.hogar.patitasSinHogar.dto.MascotaDTO;
import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    MascotaDTO crearMascota(MascotaDTO mascotaDTO);
    Optional<MascotaDTO> buscarPorId(int id);
    List<Mascota> trearTodasMascotas();
    Optional<MascotaDTO> actualizarMascota(int id, MascotaDTO mascotaDTO);
    void eliminarMascota(Integer id);
}
