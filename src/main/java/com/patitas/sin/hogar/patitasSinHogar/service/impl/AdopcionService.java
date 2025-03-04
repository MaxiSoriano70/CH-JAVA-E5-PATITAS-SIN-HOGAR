package com.patitas.sin.hogar.patitasSinHogar.service.impl;

import com.patitas.sin.hogar.patitasSinHogar.dto.AdopcionDTO;
import com.patitas.sin.hogar.patitasSinHogar.entity.Adopcion;
import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;
import com.patitas.sin.hogar.patitasSinHogar.repository.IAdopcionRepository;
import com.patitas.sin.hogar.patitasSinHogar.repository.IMascotaRepository;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.security.repository.IUsuarioRepository;
import com.patitas.sin.hogar.patitasSinHogar.service.IAdopcionService;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEstadoMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdopcionService implements IAdopcionService {
    @Autowired
    private IAdopcionRepository adopcionRepository;

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public AdopcionDTO crearAdopcion(Integer idMascota, Integer idPublicador, Integer idAdoptante) {
        Mascota mascota = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        Usuario publicador = usuarioRepository.findById(idPublicador)
                .orElseThrow(() -> new RuntimeException("Publicador no encontrado"));

        Usuario adoptante = usuarioRepository.findById(idAdoptante)
                .orElseThrow(() -> new RuntimeException("Adoptante no encontrado"));

        Adopcion adopcion = new Adopcion();
        adopcion.setMascota(mascota);
        adopcion.setPublicador(publicador);
        adopcion.setAdoptante(adoptante);
        adopcion.setFechaDeAdopcion(LocalDate.now());

        adopcionRepository.save(adopcion);

        mascota.setEstadoMascota(EEstadoMascota.ADOPTADO);
        mascotaRepository.save(mascota);

        return new AdopcionDTO(
                mascota.getNombre(),
                mascota.getEEspecie(),
                mascota.getSexo(),
                mascota.getDescripcion(),
                publicador.getNombre() + " " + publicador.getApellido(),
                adoptante.getNombre() + " " + adoptante.getApellido(),
                adopcion.getFechaDeAdopcion()
        );
    }

    @Override
    public Optional<AdopcionDTO> buscarPorId(int id) {
        Adopcion adopcion = adopcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adopción no encontrada"));

        Mascota mascota = adopcion.getMascota();
        Usuario publicador = adopcion.getPublicador();
        Usuario adoptante = adopcion.getAdoptante();

        AdopcionDTO adopcionDTO = new AdopcionDTO(
                mascota.getNombre(),
                mascota.getEEspecie(),
                mascota.getSexo(),
                mascota.getDescripcion(),
                publicador.getNombre() + " " + publicador.getApellido(),
                adoptante.getNombre() + " " + adoptante.getApellido(),
                adopcion.getFechaDeAdopcion()
        );

        return Optional.of(adopcionDTO);
    }

    @Override
    public List<AdopcionDTO> trearTodasAdopciones() {
        List<Adopcion> adopciones = adopcionRepository.findAll();

        List<AdopcionDTO> adopcionesDTO = adopciones.stream().map(adopcion -> {
            Mascota mascota = adopcion.getMascota();
            Usuario publicador = adopcion.getPublicador();
            Usuario adoptante = adopcion.getAdoptante();

            return new AdopcionDTO(
                    mascota.getNombre(),
                    mascota.getEEspecie(),
                    mascota.getSexo(),
                    mascota.getDescripcion(),
                    publicador.getNombre() + " " + publicador.getApellido(),
                    adoptante.getNombre() + " " + adoptante.getApellido(),
                    adopcion.getFechaDeAdopcion()
            );
        }).collect(Collectors.toList());

        return adopcionesDTO;
    }


    @Override
    public Optional<AdopcionDTO> actualizarAdopcion(int idAdopcion, Integer idAdoptante) {
        Adopcion adopcion = adopcionRepository.findById(idAdopcion)
                .orElseThrow(() -> new RuntimeException("Adopción no encontrada"));

        Usuario adoptante = usuarioRepository.findById(idAdoptante)
                .orElseThrow(() -> new RuntimeException("Adoptante no encontrado"));

        adopcion.setAdoptante(adoptante);

        adopcionRepository.save(adopcion);

        // Retornar el DTO actualizado
        return Optional.of(new AdopcionDTO(
                adopcion.getMascota().getNombre(),
                adopcion.getMascota().getEEspecie(),
                adopcion.getMascota().getSexo(),
                adopcion.getMascota().getDescripcion(),
                adopcion.getPublicador().getNombre() + " " + adopcion.getPublicador().getApellido(),
                adoptante.getNombre() + " " + adoptante.getApellido(),
                adopcion.getFechaDeAdopcion()
        ));
    }
    @Override
    public void eliminarAdopcion(Integer id) {
        Adopcion adopcion = adopcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adopción no encontrada"));

        Mascota mascota = adopcion.getMascota();
        mascota.setEstadoMascota(EEstadoMascota.EN_ADOPCION);
        mascotaRepository.save(mascota);

        adopcionRepository.delete(adopcion);
    }

}
