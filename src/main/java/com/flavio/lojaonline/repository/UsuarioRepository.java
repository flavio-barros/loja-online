package com.flavio.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findUsuarioByEmail(String email);
}
