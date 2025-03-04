package com.patitas.sin.hogar.patitasSinHogar.controller;

import com.patitas.sin.hogar.patitasSinHogar.dto.AdopcionDTO;
import com.patitas.sin.hogar.patitasSinHogar.dto.MascotaDTO;
import com.patitas.sin.hogar.patitasSinHogar.entity.Mascota;
import com.patitas.sin.hogar.patitasSinHogar.service.IAdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/adopcion")
public class AdopcionController {
    @Autowired
    private IAdopcionService adopcionService;
    @PostMapping
    public ResponseEntity<AdopcionDTO> crearAdopcion(@RequestBody Map<String, Integer> requestBody){
        Integer idMascota = requestBody.get("idMascota");
        Integer idPublicador = requestBody.get("idPublicador");
        Integer idAdoptante = requestBody.get("idAdoptante");

        AdopcionDTO adopcionDTOARetornar = adopcionService.crearAdopcion(idMascota, idPublicador, idAdoptante);
        if(adopcionDTOARetornar == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(adopcionDTOARetornar);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdopcionDTO> buscarAdopcionPorId(@PathVariable Integer id){
        Optional<AdopcionDTO> adopcionDTO = adopcionService.buscarPorId(id);
        if(adopcionDTO.isPresent()){
            return ResponseEntity.ok(adopcionDTO.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<AdopcionDTO>> traerTodas(){
        return ResponseEntity.ok(adopcionService.trearTodasAdopciones());
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAdopcion(@PathVariable Integer id, @RequestBody Map<String, Integer> requestBody){
        Integer idAdoptante = requestBody.get("idAdoptante");

        Optional<AdopcionDTO> adopcionDTOOpt = adopcionService.actualizarAdopcion(id, idAdoptante);
        if (adopcionDTOOpt.isPresent()) {
            return ResponseEntity.ok("{\"message\": \"adopcion modificada\"}");
        } else {
            return new ResponseEntity<>("{\"message\": \"adopcion no encontrada\"}", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarAdopcion(@PathVariable Integer id){
        Optional<AdopcionDTO> adopcionDTOOpt = adopcionService.buscarPorId(id);
        if (adopcionDTOOpt.isPresent()) {
            adopcionService.eliminarAdopcion(id);
            return ResponseEntity.ok("{\"message\": \"adopcion eliminada\"}");
        } else {
            return new ResponseEntity<>("{\"message\": \"adopcion no encontrada\"}", HttpStatus.NOT_FOUND);
        }
    }
}
