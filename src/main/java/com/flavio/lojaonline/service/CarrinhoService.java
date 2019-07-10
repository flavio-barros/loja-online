package com.flavio.lojaonline.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Carrinho;
import com.flavio.lojaonline.model.Cliente;
import com.flavio.lojaonline.model.Item;
import com.flavio.lojaonline.model.Produto;
import com.flavio.lojaonline.repository.CarrinhoRepository;
import com.flavio.lojaonline.repository.ItemRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemRepository itemRepository;	
	
	public Optional<Carrinho> recuperarPorCliente(Cliente cliente){
		
		return this.carrinhoRepository.findByCliente(cliente);
	}
	
//	Salvar Carrinho com o cliente do "idCliente" e com o item com o Produto do "idProduto"
//	e quantidade igual a 1
	public void salvar(Long idProduto, Cliente cliente){
		Optional<Produto> produtoOpt = this.produtoService.recuperar(idProduto);
		Optional<Carrinho> carrinhoOpt = this.carrinhoRepository.findByCliente(cliente);
		
		if(produtoOpt.isPresent()) {
			Carrinho carrinho = null;
			if(carrinhoOpt.isPresent()) {
				carrinho = carrinhoOpt.get();
			}else {
				carrinho = new Carrinho();
				cliente.setCarrinho(carrinho);
				carrinho = this.clienteService.salvar(cliente).getCarrinho();
			}
			
			Produto produto = produtoOpt.get();
			Item item = new Item();
			item.setProduto(produto);
			item.setQuantidade(1);
			item.setCarrinho(carrinho);
			
			this.itemRepository.save(item);
		}else {
//			Retornar mensagem de erro "Produto não encontrado"
		}
	}
}
