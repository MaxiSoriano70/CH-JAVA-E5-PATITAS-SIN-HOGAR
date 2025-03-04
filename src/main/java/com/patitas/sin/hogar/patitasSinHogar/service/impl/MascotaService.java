package com.patitas.sin.hogar.patitasSinHogar.service.impl;

import com.patitas.sin.hogar.patitasSinHogar.dto.MascotaDTO;
import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;
import com.patitas.sin.hogar.patitasSinHogar.repository.IMascotaRepository;
import com.patitas.sin.hogar.patitasSinHogar.service.IMascotaService;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.security.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    private IMascotaRepository mascotaRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public MascotaDTO crearMascota(MascotaDTO mascotaDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(mascotaDTO.getIdUsuario());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Mascota mascota = new Mascota();
            mascota.setNombre(mascotaDTO.getNombre());
            mascota.setFechaDeNacimiento(mascotaDTO.getFechaDeNacimiento());
            mascota.setSexo(mascotaDTO.getSexo());
            mascota.setColorDePelo(mascotaDTO.getColorDePelo());
            mascota.setDireccion(mascotaDTO.getDireccion());
            mascota.setEEspecie(mascotaDTO.getEspecie());
            mascota.setRaza(mascotaDTO.getRaza());
            mascota.setEsterilizado(mascotaDTO.getEsterilizado());
            mascota.setPesoKg(mascotaDTO.getPesoKg());
            mascota.setDescripcion(mascotaDTO.getDescripcion());
            mascota.setUrlImagen(mascotaDTO.getUrlImagen());
            mascota.setFechaPublicacion(LocalDate.now());

            if (mascotaDTO.getEstadoMascota() != null) {
                mascota.setEstadoMascota(mascotaDTO.getEstadoMascota());
            }

            mascota.setUsuario(usuario);

            Mascota mascotaPersistida = mascotaRepository.save(mascota);

            MascotaDTO savedMascotaDTO = new MascotaDTO(
                    mascotaPersistida.getNombre(),
                    mascotaPersistida.getFechaDeNacimiento(),
                    mascotaPersistida.getSexo(),
                    mascotaPersistida.getColorDePelo(),
                    mascotaPersistida.getDireccion(),
                    mascotaPersistida.getEEspecie(),
                    mascotaPersistida.getRaza(),
                    mascotaPersistida.getEsterilizado(),
                    mascotaPersistida.getPesoKg(),
                    mascotaPersistida.getDescripcion(),
                    mascotaPersistida.getUrlImagen(),
                    mascotaPersistida.getFechaPublicacion(),
                    mascotaPersistida.getEstadoMascota(),
                    mascotaPersistida.getUsuario().getIdUsuario()
            );

            return savedMascotaDTO;
        }
        return null;
    }

    @Override
    public Optional<MascotaDTO> buscarPorId(int id) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();
            return Optional.of(new MascotaDTO(
                    mascota.getNombre(),
                    mascota.getFechaDeNacimiento(),
                    mascota.getSexo(),
                    mascota.getColorDePelo(),
                    mascota.getDireccion(),
                    mascota.getEEspecie(),
                    mascota.getRaza(),
                    mascota.getEsterilizado(),
                    mascota.getPesoKg(),
                    mascota.getDescripcion(),
                    mascota.getUrlImagen(),
                    mascota.getFechaPublicacion(),
                    mascota.getEstadoMascota(),
                    mascota.getUsuario().getIdUsuario()
            ));
        }
        return Optional.empty();
    }
    @Override
    public List<Mascota> trearTodasMascotas() {
        return mascotaRepository.findAll();
    }
    @Override
    public Optional<MascotaDTO> actualizarMascota(int id, MascotaDTO mascotaDTO) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();

            if (mascotaDTO.getNombre() != null) mascota.setNombre(mascotaDTO.getNombre());
            if (mascotaDTO.getFechaDeNacimiento() != null) mascota.setFechaDeNacimiento(mascotaDTO.getFechaDeNacimiento());
            if (mascotaDTO.getSexo() != null) mascota.setSexo(mascotaDTO.getSexo());
            if (mascotaDTO.getColorDePelo() != null) mascota.setColorDePelo(mascotaDTO.getColorDePelo());
            if (mascotaDTO.getDireccion() != null) mascota.setDireccion(mascotaDTO.getDireccion());
            if (mascotaDTO.getEspecie() != null) mascota.setEEspecie(mascotaDTO.getEspecie());
            if (mascotaDTO.getRaza() != null) mascota.setRaza(mascotaDTO.getRaza());
            if (mascotaDTO.getEsterilizado() != null) mascota.setEsterilizado(mascotaDTO.getEsterilizado());
            if (mascotaDTO.getPesoKg() != null) mascota.setPesoKg(mascotaDTO.getPesoKg());
            if (mascotaDTO.getDescripcion() != null) mascota.setDescripcion(mascotaDTO.getDescripcion());
            if (mascotaDTO.getUrlImagen() != null) mascota.setUrlImagen(mascotaDTO.getUrlImagen());
            if (mascotaDTO.getEstadoMascota() != null) mascota.setEstadoMascota(mascotaDTO.getEstadoMascota());

            mascotaRepository.save(mascota);

            return Optional.of(new MascotaDTO(
                    mascota.getNombre(),
                    mascota.getFechaDeNacimiento(),
                    mascota.getSexo(),
                    mascota.getColorDePelo(),
                    mascota.getDireccion(),
                    mascota.getEEspecie(),
                    mascota.getRaza(),
                    mascota.getEsterilizado(),
                    mascota.getPesoKg(),
                    mascota.getDescripcion(),
                    mascota.getUrlImagen(),
                    mascota.getFechaPublicacion(),
                    mascota.getEstadoMascota(),
                    mascota.getUsuario().getIdUsuario()
            ));
        }
        return Optional.empty();
    }
    @Override
    public void eliminarMascota(Integer id) {
        mascotaRepository.deleteById(id);
    }
}
