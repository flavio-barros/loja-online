package com.flavio.lojaonline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Fabricante;
import com.flavio.lojaonline.model.Produto;
import com.flavio.lojaonline.repository.FabricanteRepository;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public List<Fabricante> listar() {
		return this.fabricanteRepository.findAll();
	}
	
	public Optional<Fabricante> recuperar(long id) {
		return fabricanteRepository.findById(id);
	}
	
	public Optional<Fabricante> recuperarPorProduto(Produto produto) {
		return fabricanteRepository.findById(produto.getFabricante().getId());
	}
	
	public void salvar(Fabricante fabricante) {
		this.fabricanteRepository.save(fabricante);
	}
	
	public void remover(Fabricante fabricante) {
		fabricanteRepository.delete(fabricante);
	}
	
}
