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

@Entity
@Table(name = "secao")
public class Secao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
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
