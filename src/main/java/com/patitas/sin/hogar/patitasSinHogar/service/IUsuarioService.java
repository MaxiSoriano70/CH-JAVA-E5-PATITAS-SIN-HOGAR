package com.patitas.sin.hogar.patitasSinHogar.service;

import com.patitas.sin.hogar.patitasSinHogar.dto.UsuarioDTO;
import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Usuario crearUsuario (Usuario usuario);
    Optional<UsuarioDTO> buscarPorId(int id);
    List<UsuarioDTO> trearTodosUsuarios();
    Optional<Usuario> actualizarUsuario(int id, UsuarioDTO usuarioDTO);
    void eliminarUsuario(Integer id);
}
