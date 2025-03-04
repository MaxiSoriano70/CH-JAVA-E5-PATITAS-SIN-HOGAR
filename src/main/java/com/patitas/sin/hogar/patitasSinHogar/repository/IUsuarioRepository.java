package com.patitas.sin.hogar.patitasSinHogar.repository;

import com.patitas.sin.hogar.patitasSinHogar.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
