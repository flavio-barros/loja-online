package com.flavio.lojaonline.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.model.Secao;
import com.flavio.lojaonline.service.SecaoService;

@Controller
@RequestMapping(value = "/admin/secao")
public class SecaoController {
	
	@Autowired
	private SecaoService secaoService;
	
	@RequestMapping(value = {"/listar", "/", ""}, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("secoes", secaoService.listar());
		return "admin/secao/listar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String paginaCadastrar(Secao secao) {
		return "admin/secao/cadastrar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(@Valid Secao secao, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/admin/secao/cadastrar";
		}
		secaoService.salvar(secao);
		return "redirect:/admin/secao";
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String paginaEditar(@PathVariable long id, Model model) {
		Optional<Secao> secaoOpt = secaoService.recuperar(id);
		if(secaoOpt.isPresent()) {
			model.addAttribute("secao", secaoOpt.get());
			return "admin/secao/editar";
		}else {
			return "redirect:/admin/secao";
		}
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable("id") Long id, @Valid Secao secao, BindingResult bindingResult, Model model) {
		secao.setId(id);
		if(bindingResult.hasErrors()) {
			return "/admin/secao/editar";
		}
		secaoService.salvar(secao);
		return "redirect:/admin/secao";
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Long id) {
		Optional<Secao> secaoOpt = secaoService.recuperar(id);
		if(secaoOpt.isPresent()) {
			secaoService.remover(secaoOpt.get());
			return "redirect:/admin/secao";
		}else {
			return "redirect:/admin/secao";
		}
	}
	
	@RequestMapping(value = "/detalhes/{id}", method = RequestMethod.GET)
	public String detalhes(@PathVariable("id") Long id, Model model) {
		Optional<Secao> secaoOpt = secaoService.recuperar(id);
		if(secaoOpt.isPresent()) {
			model.addAttribute("secao", secaoOpt.get());
			return "admin/secao/detalhes";
		}
		return "redirect:/admin/secao";
	}
}
