package com.patitas.sin.hogar.patitasSinHogar.security.repository;

import com.patitas.sin.hogar.patitasSinHogar.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
