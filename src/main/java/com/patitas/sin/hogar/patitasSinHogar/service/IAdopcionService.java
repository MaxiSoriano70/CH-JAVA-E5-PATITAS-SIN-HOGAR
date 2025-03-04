package com.patitas.sin.hogar.patitasSinHogar.service;

import com.patitas.sin.hogar.patitasSinHogar.dto.AdopcionDTO;
import com.patitas.sin.hogar.patitasSinHogar.dto.MascotaDTO;
import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;

import java.util.List;
import java.util.Optional;

public interface IAdopcionService {
    AdopcionDTO crearAdopcion(Integer idMascota, Integer idPublicador, Integer idAdoptante);
    Optional<AdopcionDTO> buscarPorId(int id);
    List<AdopcionDTO> trearTodasAdopciones();
    Optional<AdopcionDTO> actualizarAdopcion(int idAdopcion, Integer idAdoptante);
    void eliminarAdopcion(Integer id);
}
