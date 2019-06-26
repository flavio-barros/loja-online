package com.flavio.lojaonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "admin/produto/")
public class ProdutoAdminController {
	
	@RequestMapping(value = "listar")
	public ModelAndView listar() {
		return new ModelAndView("admin/produto/listar");
	}
}
