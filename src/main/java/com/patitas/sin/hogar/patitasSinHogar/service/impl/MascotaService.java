package com.patitas.sin.hogar.patitasSinHogar.service.impl;

import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;
import com.patitas.sin.hogar.patitasSinHogar.repository.IMascotaRepository;
import com.patitas.sin.hogar.patitasSinHogar.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MascotaService implements IMascotaService {
    @Autowired
    private IMascotaRepository mascotaRepository;
    @Override
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Optional<Mascota> buscarPorId(int id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public List<Mascota> trearTodasMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void eliminarMascota(Integer id) {
        mascotaRepository.deleteById(id);
    }
}
