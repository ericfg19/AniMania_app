package br.edu.infnet.animaniaapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.animaniaapp.model.domain.Endereco;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.EnderecoService;
import br.edu.infnet.animaniaapp.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/listar")
	public String telaLista(Model model) {

		model.addAttribute("listagem", usuarioService.obterLista());
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);

		return "redirect:/usuario/listar";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		usuarioService.excluir(id);
		
		return "redirect:/usuario/listar";
	}
	
	@PostMapping(value = "/cep")
	public String buscarCep(Model model, @RequestParam String cep) {

		model.addAttribute("myEnd", enderecoService.buscarCep(cep));

		return "usuario/cadastro";
	}
	
	//
	@PostMapping(value = "/usuario/{id}/editar")
	public String editar(Usuario usuario) {
		
		
		System.out.println(usuario);
		//usuarioService.incluir(usuario);

		return "redirect:/usuario/listar";
	}
	
	@GetMapping(value = "/usuario/{id}/editar")
	public String editarView(Model model, @PathVariable Integer id) {
		
		Optional<Usuario> usuario = usuarioService.findOne(id);
		if (usuario == null) {
			model.addAttribute("msg", "Usuario não encontrado");
			return "redirect:/usuario/listar";
			
		}
		
		model.addAttribute("usuario", usuario);

		return "usuario/editar";
	}
}