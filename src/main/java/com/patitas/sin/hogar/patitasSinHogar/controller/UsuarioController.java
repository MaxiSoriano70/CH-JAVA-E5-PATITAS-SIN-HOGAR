package com.patitas.sin.hogar.patitasSinHogar.controller;

import com.patitas.sin.hogar.patitasSinHogar.dto.UsuarioDTO;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.security.repository.IUsuarioRepository;
import com.patitas.sin.hogar.patitasSinHogar.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario usuarioARetornar = usuarioService.crearUsuario(usuario);
        if(usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
    }
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> traerTodos(){
        return ResponseEntity.ok(usuarioService.trearTodosUsuarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarCategoriaPorId(@PathVariable Integer id){
        Optional<UsuarioDTO> usuarioDTO = usuarioService.buscarPorId(id);
        if(usuarioDTO.isPresent()){
            UsuarioDTO usuarioDTOARetornar = usuarioDTO.get();
            return ResponseEntity.ok(usuarioDTOARetornar);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOptional = usuarioService.actualizarUsuario(id, usuarioDTO);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok("{\"message\": \"usuario modificado\"}");
        } else {
            return new ResponseEntity<>("{\"message\": \"usuario no encontrado\"}", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Integer id){
        Optional<UsuarioDTO> usuarioOptional = usuarioService.buscarPorId(id);
        if (usuarioOptional.isPresent()) {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("{\"message\": \"usuario eliminado\"}");
        } else {
            return new ResponseEntity<>("{\"message\": \"usuario no encontrada\"}", HttpStatus.NOT_FOUND);
        }
    }

}
