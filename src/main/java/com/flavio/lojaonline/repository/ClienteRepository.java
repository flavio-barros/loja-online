package com.flavio.lojaonline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Cliente;
import com.flavio.lojaonline.model.Usuario;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findClienteByUsuario(Usuario usuario);
}
