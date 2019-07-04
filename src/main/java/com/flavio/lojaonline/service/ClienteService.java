package com.flavio.lojaonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Cliente;
import com.flavio.lojaonline.model.Usuario;
import com.flavio.lojaonline.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Cliente salvar(Cliente cliente) {
		Usuario usuario = usuarioService.salvarCliente(cliente.getUsuario());
		cliente.setUsuario(usuario);
		return this.clienteRepository.save(cliente);
	}
}
