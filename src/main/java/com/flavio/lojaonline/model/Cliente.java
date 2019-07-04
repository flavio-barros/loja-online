package com.flavio.lojaonline.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Valid
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco enderecoPrincipal;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecosPedidos;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	@OneToOne
	private Carrinho carrinho;
	
	@Valid
	@OneToOne
	private Usuario usuario;
	
	public Cliente() {
		super();
	}

	public Cliente(Endereco enderecoPrincipal, List<Endereco> enderecosPedidos, List<Pedido> pedidos, 
			Carrinho carrinho, Usuario usuario) {
		super();
		this.enderecoPrincipal = enderecoPrincipal;
		this.enderecosPedidos = enderecosPedidos;
		this.pedidos = pedidos;
		this.carrinho = carrinho;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public List<Endereco> getEnderecosPedidos() {
		return enderecosPedidos;
	}

	public void setEnderecosPedidos(List<Endereco> enderecosPedidos) {
		this.enderecosPedidos = enderecosPedidos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
