package br.edu.infnet.animaniaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.animaniaapp.model.domain.Animal;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.AnimalService;

@Controller
public class AnimalController {
	
	private String mensagem;
	private String mensagem2;
	
	@Autowired	
	private AnimalService animalService;

	@GetMapping(value = "/animal/listar")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("msg", mensagem);
		
		model.addAttribute("msg2", mensagem2);
				
		model.addAttribute("listagem", animalService.obterLista(usuario));
		
		return "animal/lista";
	}

	@PostMapping(value = "/animal/incluir")
	public String incluir(Animal animal, @SessionAttribute("user") Usuario usuario) {
		
		animal.setUsuario(usuario);
		
		animalService.incluir(animal);
		
		mensagem = "A inclusão do pet "+ animal.getNome()+" (ID="+animal.getId()+") foi realizada com sucesso!";

		return "redirect:/animal/listar";
	}
	
	@GetMapping(value = "/animal/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Animal animal = null;

		try {
			animal = animalService.obterPorId(id);
			animalService.excluir(id);
			mensagem = "A exclusão do pet "+animal.getNome()+"  foi realizada com sucesso!";
			
		} catch (Exception e) {
			mensagem2 = "Não foi possível realizar a exclusão do pet "+animal.getNome()+"("+animal.getId()+") pois este deve estar cadastrado em uma adoção!";
		}

		return "redirect:/animal/listar";
	}
	
	public Animal exclusaoAnimal(Integer id) {
				
		Animal animal = null;
		
		try {
			animal = animalService.obterPorId(id);
			animalService.excluir(id);
			mensagem = "A exclusão do pet "+animal.getNome()+"  foi realizada com sucesso!";
			
		} catch (Exception e) {
			mensagem2 = "Não foi possível realizar a exclusão do pet "+animal.getNome()+"("+animal.getId()+") pois este deve estar cadastrado em uma adoção!";
		}
		
		
		return animal;
	}
}