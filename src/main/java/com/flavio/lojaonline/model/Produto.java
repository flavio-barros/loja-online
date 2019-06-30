package com.flavio.lojaonline.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NotBlank(message = "O atributo Nome não pode ser vazio")
	@Size(max = 50, message = "O atributo Nome deve ter no máximo 50 caracteres")
	private String nome;
	
	@NotNull(message = "Selecione um fabricante")
	@ManyToOne
	private Fabricante fabricante;
	
	private String descricao;
	
	@NotNull
	private Double preco;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Secao> secoes;
	
	public Produto() {
		super();
	}
	
	public Produto(@NotNull @Size(max = 50) String nome, @NotNull Fabricante fabricante, String descricao,
			@NotNull Double preco, List<Secao> secoes) {
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
