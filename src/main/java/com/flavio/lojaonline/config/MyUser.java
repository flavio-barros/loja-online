package com.flavio.lojaonline.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.flavio.lojaonline.model.Usuario;

public class MyUser extends User{

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			Usuario usuario) {
		super(username, password, authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
