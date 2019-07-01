package com.flavio.lojaonline.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.flavio.lojaonline.group.IProdutoFabricante;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Min(value = 0, groups = IProdutoFabricante.class, message = "Selecione um fabricante")
	private Long id;
	
	@NotBlank(message = "O atributo Nome não pode ser vazio")
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy = "fabricante")
	private List<Produto> produtos;
	
	public Fabricante() {
		super();
	}

	public Fabricante(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
