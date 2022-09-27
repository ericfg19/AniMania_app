package br.edu.infnet.animaniaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.animaniaapp.model.domain.Felino;
import br.edu.infnet.animaniaapp.model.domain.Animal;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.FelinoService;

@Controller
public class FelinoController {
	
	private String mensagem;
	private String mensagem2;
	
	@Autowired	
	private FelinoService felinoService;
	@Autowired
	private AnimalController animalController;

	@GetMapping(value = "/felino")
	public String telaCadastro() {
		return "felino/cadastro";
	}	
	
	@GetMapping(value = "/felino/listar")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("msg", mensagem);
		model.addAttribute("msg2", mensagem2);
				
		model.addAttribute("listagem", felinoService.obterLista(usuario));
		
		return "felino/lista";
	}

	@PostMapping(value = "/felino/incluir")
	public String incluir(Felino felino, @SessionAttribute("user") Usuario usuario) {
		
		felino.setUsuario(usuario);
		
		felinoService.incluir(felino);
		
		mensagem = "O cadastro de "+ felino.getNome()+" ("+felino.getRaca()+") foi realizado com sucesso!";

		return "redirect:/felino/listar";
	}
	
	@GetMapping(value = "/felino/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Animal animal = animalController.exclusaoAnimal(id);

		mensagem = "A exclusão do pet "+animal.getNome()+" (categoria: felino) foi realizada com sucesso!";

		return "redirect:/felino/listar";
	}
}