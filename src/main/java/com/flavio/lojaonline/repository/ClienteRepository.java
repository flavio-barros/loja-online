package com.flavio.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
