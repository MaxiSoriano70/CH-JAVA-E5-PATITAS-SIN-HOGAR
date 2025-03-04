package com.patitas.sin.hogar.patitasSinHogar.controller;

import com.patitas.sin.hogar.patitasSinHogar.dto.MascotaDTO;
import com.patitas.sin.hogar.patitasSinHogar.dto.UsuarioDTO;
import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private IMascotaService mascotaService;
    @PostMapping
    public ResponseEntity<MascotaDTO> crearMascota(@RequestBody MascotaDTO mascotaDTO){
        MascotaDTO mascotaARetornar = mascotaService.crearMascota(mascotaDTO);
        if(mascotaARetornar == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(mascotaARetornar);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> buscarMascotaPorId(@PathVariable Integer id){
        Optional<MascotaDTO> mascotaDTO = mascotaService.buscarPorId(id);
        if(mascotaDTO.isPresent()){
            return ResponseEntity.ok(mascotaDTO.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Mascota>> traerTodos(){
        return ResponseEntity.ok(mascotaService.trearTodasMascotas());
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarMascota(@PathVariable Integer id, @RequestBody MascotaDTO mascotaDTO){
        Optional<MascotaDTO> mascotaDTOOpt = mascotaService.actualizarMascota(id, mascotaDTO);
        if (mascotaDTOOpt.isPresent()) {
            return ResponseEntity.ok("{\"message\": \"mascota modificada\"}");
        } else {
            return new ResponseEntity<>("{\"message\": \"mascota no encontrada\"}", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarMascota(@PathVariable Integer id){
        Optional<MascotaDTO> mascotaDTOOpt = mascotaService.buscarPorId(id);
        if (mascotaDTOOpt.isPresent()) {
            mascotaService.eliminarMascota(id);
            return ResponseEntity.ok("{\"message\": \"mascota eliminada\"}");
        } else {
            return new ResponseEntity<>("{\"message\": \"mascota no encontrada\"}", HttpStatus.NOT_FOUND);
        }
    }
}
