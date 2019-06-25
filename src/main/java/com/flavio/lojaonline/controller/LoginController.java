package com.flavio.lojaonline.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flavio.lojaonline.util.Constantes;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/loginSucesso")
	public String login(HttpServletRequest request) {
//		System.out.println(request.getUserPrincipal().toString());
		if(request.isUserInRole(Constantes.PAPEL_ADMIN)) {
			return "redirect:/admin/home";
		}else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
