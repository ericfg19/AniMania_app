package br.edu.infnet.animaniaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.animaniaapp.model.domain.Animal;
import br.edu.infnet.animaniaapp.model.domain.Canino;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.CaninoService;

@Controller
public class CaninoController {
	
	private String mensagem;
	private String mensagem2;
	
	@Autowired	
	private CaninoService caninoService;
	@Autowired
	private AnimalController animalController;

	@GetMapping(value = "/canino")
	public String telaCadastro() {
		return "canino/cadastro";
	}	
	
	@GetMapping(value = "/canino/listar")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("msg", mensagem);
		model.addAttribute("msg2", mensagem2);
				
		model.addAttribute("listagem", caninoService.obterLista(usuario));
		
		return "canino/lista";
	}

	@PostMapping(value = "/canino/incluir")
	public String incluir(Canino canino, @SessionAttribute("user") Usuario usuario) {
		
		canino.setUsuario(usuario);
		
		caninoService.incluir(canino);
		
		mensagem = "O cadastro de "+canino.getNome()+" ("+canino.getRaca()+") foi realizado com sucesso!";

		return "redirect:/canino/listar";
	}
	
	@GetMapping(value = "/canino/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Animal animal = animalController.exclusaoAnimal(id);

		mensagem = "A exclusão do pet "+animal.getNome()+" (categoria: canino) foi realizada com sucesso!";

		return "redirect:/canino/listar";
	}
}