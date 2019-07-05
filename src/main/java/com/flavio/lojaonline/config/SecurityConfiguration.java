package com.flavio.lojaonline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.flavio.lojaonline.service.CustomUserDetailsService;
import com.flavio.lojaonline.util.Constantes;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        	authorizeRequests().
        		antMatchers("/", "/home", "/cadastrar/**").permitAll().
        		antMatchers("/css/**", "/js/**", "/webjars/**").permitAll().
        		antMatchers("/admin/**").hasRole(Constantes.PAPEL_ADMIN).
        		antMatchers("/cliente/**").hasRole(Constantes.PAPEL_USER).
        		anyRequest().authenticated().and().
        	formLogin().
        		defaultSuccessUrl("/loginSucesso").
        		loginPage("/login").permitAll().and().
        	logout().
        		logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
        		logoutSuccessUrl("/home");
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
     
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}