package com.flavio.lojaonline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Carrinho;
import com.flavio.lojaonline.model.Cliente;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
	
	Optional<Carrinho> findByCliente(Cliente cliente);
}