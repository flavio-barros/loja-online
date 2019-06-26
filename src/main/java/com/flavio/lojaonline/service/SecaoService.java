package com.flavio.lojaonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Secao;
import com.flavio.lojaonline.repository.SecaoRepository;

@Service
public class SecaoService{
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	public List<Secao> listar(){
		return secaoRepository.findAll();
	}
}
