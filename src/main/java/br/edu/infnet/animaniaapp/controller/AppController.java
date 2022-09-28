package br.edu.infnet.animaniaapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.AppService;
import br.edu.infnet.animaniaapp.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AppService appService;
	
	private String mensagem;

	@GetMapping(value = "/")
	public String telaHome(Model model) {		

		
		model.addAttribute("mapa", appService.obterMapa());
		
		return "home";
		
	}

	@GetMapping(value = "/login")
	public String telaLogin(Model model) {
		model.addAttribute("msg", mensagem);
		
		return "login";
	}

	@PostMapping(value = "/login")
	public String validar(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario usuario = usuarioService.validar(email, senha);

		if(usuario != null) {
			
			model.addAttribute("user", usuario);
			System.out.println("Usuário logado com sucesso!!!");
			
			return "redirect:/";
		}
		
		mensagem = "Credenciais incorretas para o e-mail "+email+"!!!";
		
		System.out.println("Falha de login.");
		
		return "redirect:/login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {

		status.setComplete();
		
		session.removeAttribute("user");
		System.out.println("Usuário realizou logouf!!");
				
		return "redirect:/";
	}
	
	@GetMapping(value = "/privacy")
	public String telaPrivacy() {		
		return "privacy";
	}
}