package com.flavio.lojaonline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Papel;
import com.flavio.lojaonline.model.Usuario;
import com.flavio.lojaonline.repository.PapelRepository;
import com.flavio.lojaonline.repository.UsuarioRepository;
import com.flavio.lojaonline.util.Constantes;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Usuario salvarCliente(Usuario usuario){
		usuario.setSenha(this.encoder.encode(usuario.getSenha()));
		Papel papelUsuario = this.papelRepository.findPapelByNome("ROLE_"+Constantes.PAPEL_USER);
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papelUsuario);
		usuario.setPapeis(papeis);
		return this.usuarioRepository.save(usuario);
	}
}
