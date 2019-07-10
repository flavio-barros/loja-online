package com.flavio.lojaonline.controller;

import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.config.MyUser;
import com.flavio.lojaonline.model.Carrinho;
import com.flavio.lojaonline.model.Cliente;
import com.flavio.lojaonline.service.CarrinhoService;
import com.flavio.lojaonline.service.ClienteService;
import com.flavio.lojaonline.service.ProdutoService;
import com.flavio.lojaonline.service.SecaoService;

@Controller
@RequestMapping(value = "/")
public class InicialController {
	
	@Autowired
	private SecaoService secaoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@RequestMapping(value = {"home", ""}, method = RequestMethod.GET)
	public String index(Model model, Authentication authentication) {

		if (authentication != null) {
			MyUser user = (MyUser) authentication.getPrincipal();
			Optional<Cliente> clienteOpt = clienteService.recuperarClientePorUsuario(user.getUsuario());
			if(clienteOpt.isPresent()) {
				model.addAttribute("cliente", clienteOpt.get());
				Optional<Carrinho> carrinhoOpt = this.carrinhoService.recuperarPorCliente(clienteOpt.get());
				System.out.println(clienteOpt.get().getCarrinho().getId());
				if(carrinhoOpt.isPresent()) {
					System.out.println(carrinhoOpt.get().getItens().size());
					model.addAttribute("tamanhoCarrinho", carrinhoOpt.get().getItens().size());
				}else {
					System.out.println("Carrinho não encontrado");
					model.addAttribute("tamanhoCarrinho", 0);
				}
			}
		}
		
		model.addAttribute("produtos", produtoService.listar());
		model.addAttribute("secoes", secaoService.listar());
		return "index";
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String paginaCadastrar(Cliente cliente) {
		return "cliente/cadastrar";
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String cadastrar(@Valid Cliente cliente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "cliente/cadastrar";
		}
		this.clienteService.salvarClienteUsuario(cliente);
		return "redirect:/home";
	}
}
