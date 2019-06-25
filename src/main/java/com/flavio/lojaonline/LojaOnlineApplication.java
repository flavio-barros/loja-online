package com.flavio.lojaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class LojaOnlineApplication {
	
	public static void main(String[] args) {	
		SpringApplication.run(LojaOnlineApplication.class, args);
	}

}
