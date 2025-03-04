package com.patitas.sin.hogar.patitasSinHogar.service.impl;

import com.patitas.sin.hogar.patitasSinHogar.entity.Usuario;
import com.patitas.sin.hogar.patitasSinHogar.repository.IUsuarioRepository;
import com.patitas.sin.hogar.patitasSinHogar.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public Usuario crearUsario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> trearTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
