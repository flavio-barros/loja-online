package com.flavio.lojaonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.model.Cliente;

@Controller
@RequestMapping("cliente/")
public class ClienteController {
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String cadastrar(Cliente cliente) {
		return "cliente/cadastrar";
	}
}
