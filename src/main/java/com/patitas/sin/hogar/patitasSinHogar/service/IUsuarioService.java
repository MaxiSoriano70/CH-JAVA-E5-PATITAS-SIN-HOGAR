package com.patitas.sin.hogar.patitasSinHogar.service;

import com.patitas.sin.hogar.patitasSinHogar.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario crearUsario(Usuario usuario);
    Optional<Usuario> buscarPorId(int id);
    List<Usuario> trearTodosUsuarios();
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Integer id);
}
