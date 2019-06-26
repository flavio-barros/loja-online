package com.flavio.lojaonline.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.model.Secao;
import com.flavio.lojaonline.service.SecaoService;

@Controller
@RequestMapping(value = "/admin/secao/")
public class SecaoAdminController {
	
	@Autowired
	private SecaoService secaoService;
	
	@RequestMapping(value = {"listar", ""})
	public String listar(Model model) {
		model.addAttribute("secoes", secaoService.listar());
		return "admin/secao/listar";
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String paginaCadastrar(Secao secao) {
		return "admin/secao/cadastrar";
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String cadastrar(Secao secao) {
		secaoService.salvar(secao);
		return "redirect:/admin/secao/listar";
	}
	
	@RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
	public String paginaEditar(@PathVariable long id, Model model) {
		Optional<Secao> secaoOpt = secaoService.recuperar(id);
		if(secaoOpt.isPresent()) {
			model.addAttribute("secao", secaoOpt.get());
			return "admin/secao/editar";
		}else {
			return "redirect:/admin/secao/listar";
		}
	}
	
	@RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable("id") Long id, Secao secao) {
		secao.setId(id);
		secaoService.salvar(secao);
		return "redirect:/admin/secao/listar";
	}
	
	@RequestMapping(value = "remover/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Long id) {
		Optional<Secao> secaoOpt = secaoService.recuperar(id);
		if(secaoOpt.isPresent()) {
			secaoService.remover(secaoOpt.get());
			return "redirect:/admin/secao/listar";
		}else {
			return "redirect:/admin/secao/listar";
		}
	}
}
