package com.flavio.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
