package com.flavio.lojaonline.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;

import org.hibernate.validator.constraints.Range;

import com.flavio.lojaonline.group.IProdutoFabricante;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NotBlank(message = "O atributo Nome é obrigatório")
	@Size(max = 50, message = "O atributo Nome deve ter no máximo 50 caracteres")
	private String nome;
	
	@NotNull(message = "Selecione um fabricante")
	@Valid
	@ConvertGroup(to = IProdutoFabricante.class)
	@ManyToOne
	private Fabricante fabricante;
	
	private String descricao;
	
	@Range(min = 1, message = "O atributo preço deve ser maior ou igual a 1")
	private Double preco;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Secao> secoes;
	
	public Produto() {
		super();
	}
	
	public Produto(String nome, Fabricante fabricante, String descricao, Double preco, List<Secao> secoes) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.preco = preco;
		this.secoes = secoes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
}
