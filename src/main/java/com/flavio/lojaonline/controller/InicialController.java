package com.flavio.lojaonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.service.SecaoService;

@Controller
@RequestMapping(value = "/")
public class InicialController {
	
	@Autowired
	private SecaoService secaoService;
	
	@RequestMapping(value = {"home"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("secoes", secaoService.listar());
		return "index";
	}
}
