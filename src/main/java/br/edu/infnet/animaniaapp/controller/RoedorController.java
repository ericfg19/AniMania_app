package br.edu.infnet.animaniaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.animaniaapp.model.domain.Animal;
import br.edu.infnet.animaniaapp.model.domain.Roedor;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.RoedorService;


@Controller
public class RoedorController {
	
	private String mensagem;
	private String mensagem2;
	
	@Autowired	
	private RoedorService roedorService;
	@Autowired
	private AnimalController animalController;

	@GetMapping(value = "/roedor")
	public String telaCadastro() {
		return "roedor/cadastro";
	}	
	
	@GetMapping(value = "/roedor/listar")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("msg", mensagem);
		model.addAttribute("msg2", mensagem2);
				
		model.addAttribute("listagem", roedorService.obterLista(usuario));
		
		return "roedor/lista";
	}

	@PostMapping(value = "/roedor/incluir")
	public String incluir(Roedor roedor, @SessionAttribute("user") Usuario usuario) {
		
		roedor.setUsuario(usuario);
		
		roedorService.incluir(roedor);
		
		mensagem = "O cadastro de "+ roedor.getNome()+" ("+roedor.getRaca()+") foi realizado com sucesso!";

		return "redirect:/roedor/listar";
	}
	
	@GetMapping(value = "/roedor/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Animal animal = animalController.exclusaoAnimal(id);

		mensagem = "A exclusão do pet "+animal.getNome()+" (categoria: roedor) foi realizada com sucesso!";

		return "redirect:/roedor/listar";
	}
}