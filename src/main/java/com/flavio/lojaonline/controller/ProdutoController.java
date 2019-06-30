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

import com.flavio.lojaonline.model.Fabricante;
import com.flavio.lojaonline.model.Produto;
import com.flavio.lojaonline.service.FabricanteService;
import com.flavio.lojaonline.service.ProdutoService;
import com.flavio.lojaonline.service.SecaoService;

@Controller
@RequestMapping(value = "/admin/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@Autowired
	private SecaoService secaoService;
	
	@RequestMapping(value = {"/listar", "/", ""}, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("produtos", produtoService.listar());
		return "admin/produto/listar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String paginaCadastrar(Produto produto, Model model) {
		model.addAttribute("fabricantes", fabricanteService.listar());
		model.addAttribute("secoes", secaoService.listar());
		return "admin/produto/cadastrar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Produto produto) {
//		Recuperando o fabricante do BD
		Optional<Fabricante> fabricanteOpt = fabricanteService.recuperarPorProduto(produto);
		produto.setFabricante(fabricanteOpt.orElse(null));
		
		this.produtoService.salvar(produto);
		return "redirect:/admin/produto";
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String paginaEditar(@PathVariable long id, Model model) {
		Optional<Produto> produtoOpt = produtoService.recuperar(id);
		if(produtoOpt.isPresent()) {
			model.addAttribute("produto", produtoOpt.get());
			model.addAttribute("fabricantes", fabricanteService.listar());
			model.addAttribute("secoes", secaoService.listar());
			return "admin/produto/editar";
		}else {
			return "redirect:/admin/produto";
		}
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable("id") Long id, Produto produto) {
		produto.setId(id);
		produtoService.salvar(produto);
		return "redirect:/admin/produto";
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Long id) {
		Optional<Produto> produtoOpt = produtoService.recuperar(id);
		if(produtoOpt.isPresent()) {
			this.produtoService.remover(produtoOpt.get());
			return "redirect:/admin/produto";
		}else {
			return "redirect:/admin/produto";
		}
	}
}
