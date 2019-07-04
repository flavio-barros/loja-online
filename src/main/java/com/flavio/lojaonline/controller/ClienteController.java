package com.flavio.lojaonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.model.Cliente;
import com.flavio.lojaonline.service.ClienteService;

@Controller
@RequestMapping("cliente/")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String cadastrar(Cliente cliente) {
		return "cliente/cadastrar";
	}
}
