package com.flavio.lojaonline.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.model.Fabricante;
import com.flavio.lojaonline.service.FabricanteService;

@Controller
@RequestMapping(value = "/admin/fabricante")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@RequestMapping(value = {"/listar", "/", ""}, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("fabricantes", fabricanteService.listar());
		return "admin/fabricante/listar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String paginaCadastrar(Fabricante fabricante) {
		return "admin/fabricante/cadastrar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Fabricante fabricante) {
		fabricanteService.salvar(fabricante);
		return "redirect:/admin/fabricante/listar";
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String paginaEditar(@PathVariable long id, Model model) {
		Optional<Fabricante> fabricanteOpt = fabricanteService.recuperar(id);
		if(fabricanteOpt.isPresent()) {
			model.addAttribute("fabricante", fabricanteOpt.get());
			return "admin/fabricante/editar";
		}else {
			return "redirect:/admin/fabricante";
		}
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable("id") Long id, Fabricante fabricante) {
		fabricante.setId(id);
		fabricanteService.salvar(fabricante);
		return "redirect:/admin/fabricante";
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Long id) {
		Optional<Fabricante> fabricanteOpt = fabricanteService.recuperar(id);
		if(fabricanteOpt.isPresent()) {
			fabricanteService.remover(fabricanteOpt.get());
			return "redirect:/admin/fabricante";
		}else {
			return "redirect:/admin/fabricante";
		}
	}
}
