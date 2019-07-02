package com.flavio.lojaonline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Produto;
import com.flavio.lojaonline.model.Secao;
import com.flavio.lojaonline.repository.ProdutoRepository;
import com.flavio.lojaonline.repository.SecaoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private SecaoRepository secaoRepository;
	
	public List<Produto> listar() {
		return this.produtoRepository.findAll();
	}
	
	public Optional<Produto> recuperar(long id) {
		return produtoRepository.findById(id);
	}
	
	public void salvar(Produto produto) {
		Produto produtoSalvo = this.produtoRepository.save(produto);
		
//		Salvando as seções do objeto produto
		for(Secao secaoProduto: produto.getSecoes()) {
			Optional<Secao> secaoOpt = secaoRepository.findById(secaoProduto.getId());
			if(secaoOpt.isPresent()) {
				Secao secao = secaoOpt.get();
				secao.addProduto(produtoSalvo);
				secaoRepository.save(secao);
			}
		}
		
//		Removendo as seções que não estão no objeto produto
		for(Secao secaoProduto: produtoSalvo.getSecoes()) {
			Optional<Secao> secaoOpt = secaoRepository.findById(secaoProduto.getId());
			if(secaoOpt.isPresent()) {
				Secao secao = secaoOpt.get();
				if(!produto.getSecoes().contains(secao)) {
					secao.removeProduto(produtoSalvo);
					secaoRepository.save(secao);
				}
			}
		}
	}
	
	public void remover(Produto produto) {
//		Removendo as seções do produto
		Optional<Produto> produtoSalvoOpt = this.produtoRepository.findById(produto.getId());
		
		if(produtoSalvoOpt.isPresent()) {
			Produto produtoSalvo = produtoSalvoOpt.get();
			for(Secao secaoProduto: produtoSalvo.getSecoes()) {
				Optional<Secao> secaoOpt = secaoRepository.findById(secaoProduto.getId());
				if(secaoOpt.isPresent()) {
					Secao secao = secaoOpt.get();
					secao.removeProduto(produtoSalvo);
					secaoRepository.save(secao);
				}
			}
		}
		
//		Removendo o produto
		produtoRepository.delete(produto);
	}
}
