package com.flavio.lojaonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flavio.lojaonline.service.SecaoService;

@Controller
@RequestMapping(value = "admin/secao/")
public class SecaoAdminController {
	
	@Autowired
	private SecaoService secaoService;
	
	@RequestMapping(value = "listar")
	public String listar(Model model) {
		model.addAttribute("secoes", secaoService.listar());
		return "admin/secao/listar";
	}
}
