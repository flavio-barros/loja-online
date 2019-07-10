package com.flavio.lojaonline.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.config.MyUser;
import com.flavio.lojaonline.model.Cliente;
import com.flavio.lojaonline.model.Produto;
import com.flavio.lojaonline.service.CarrinhoService;
import com.flavio.lojaonline.service.ClienteService;
import com.flavio.lojaonline.service.ProdutoService;

@Controller
@RequestMapping(value = "carrinho/")
public class CarrinhoController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@RequestMapping(value = "adicionar/produto/{idProduto}", method = RequestMethod.GET)
	public String adicionarProduto(Model model, @PathVariable("idProduto") long idProduto, Authentication authentication) {	
		if (authentication != null) {
			MyUser user = (MyUser) authentication.getPrincipal();
			Optional<Cliente> clienteOpt = this.clienteService.recuperarClientePorUsuario(user.getUsuario());
			if(clienteOpt.isPresent()) {
				this.carrinhoService.salvar(idProduto, clienteOpt.get());
			}
		}
		
		return "redirect:/";
	}
}
