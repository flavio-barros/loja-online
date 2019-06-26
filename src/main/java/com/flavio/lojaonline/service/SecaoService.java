package com.flavio.lojaonline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Secao;
import com.flavio.lojaonline.repository.SecaoRepository;

@Service
public class SecaoService{
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	public Optional<Secao> recuperar(long id) {
		return secaoRepository.findById(id);
	}
	
	public List<Secao> listar() {
		return secaoRepository.findAll();
	}
	
	public void salvar(Secao secao) {
		secaoRepository.save(secao);
	}
	
	public void remover(Secao secao) {
		secaoRepository.delete(secao);
	}
}
