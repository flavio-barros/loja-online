package com.flavio.lojaonline.service;

import java.util.Optional;

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
	
	public Cliente salvarClienteUsuario(Cliente cliente) {
		Usuario usuario = usuarioService.salvarCliente(cliente.getUsuario());
		cliente.setUsuario(usuario);
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> recuperar(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Optional<Cliente> recuperarClientePorUsuario(Usuario usuario) {
		return clienteRepository.findClienteByUsuario(usuario);
	}
}
