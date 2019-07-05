package com.flavio.lojaonline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.model.Cliente;
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
	
	@RequestMapping(value = {"home", ""}, method = RequestMethod.GET)
	public String index(Model model) {
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
		clienteService.salvar(cliente);
		return "redirect:/home";
	}
}
