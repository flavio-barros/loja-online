package com.flavio.lojaonline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flavio.lojaonline.model.Papel;
import com.flavio.lojaonline.model.Usuario;
import com.flavio.lojaonline.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUsuarioByEmail(email);
        if (usuario == null){
            throw new UsernameNotFoundException("Email inválido ou senha inválida.");
        }
        return 
        	new User(usuario.getEmail(), usuario.getSenha(), mapRolesToAuthorities(usuario.getPapeis()));
	}

	private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Papel> papeis){
        return papeis.stream()
                .map(papel -> new SimpleGrantedAuthority(papel.getNome()))
                .collect(Collectors.toList());
    }
}
