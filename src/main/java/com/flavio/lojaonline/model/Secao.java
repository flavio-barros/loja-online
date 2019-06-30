package com.flavio.lojaonline.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "secao")
public class Secao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank(message = "O atributo Nome não pode ser vazio")
	@Size(max = 20, message = "O atributo Nome deve ter no máximo 20 caracteres")
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "secao_produto", joinColumns= @JoinColumn(name="secao_id"), 
	inverseJoinColumns=@JoinColumn(name="produto_id"))
	private List<Produto> produtos;
	
	public Secao() {
		super();
	}

	public Secao(String nome) {
		super();
		this.nome = nome;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public void removeProduto(Produto produto) {
		this.produtos.remove(produto);
	}
	
}
