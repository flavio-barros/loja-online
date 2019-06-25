package com.flavio.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.lojaonline.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long>{
	
	Papel findPapelByNome(String nome);
}
