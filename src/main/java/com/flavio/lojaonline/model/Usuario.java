package com.flavio.lojaonline.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String senha;
	private String primeiroNome;
	private String ultimoNome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_papel", 
		joinColumns = @JoinColumn(name = "usuario_id"), 
	    inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private List<Papel> papeis;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String senha, String primeiroNome, String ultimoNome,
			List<Papel> papeis) {
		super();
		this.email = email;
		this.senha = senha;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.papeis = papeis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
}
