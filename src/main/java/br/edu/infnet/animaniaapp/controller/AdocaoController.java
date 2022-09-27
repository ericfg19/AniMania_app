package br.edu.infnet.animaniaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.animaniaapp.model.domain.*;

import br.edu.infnet.animaniaapp.model.service.*;


@Controller
public class AdocaoController {
	
	private String mensagem;
	private String mensagem2;
	
	@Autowired	
	private AdocaoService adocaoService;
	@Autowired
	private TutorService tutorService;
	@Autowired
	private AnimalService animalService;

	@GetMapping(value = "/adocao")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("tutores", tutorService.obterLista(usuario));
		
		model.addAttribute("animais", animalService.obterLista(usuario));
		
		
		
		return "adocao/cadastro";
	}	
	
	@GetMapping(value = "/adocao/listar")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("msg", mensagem);
		
		model.addAttribute("msg2", mensagem2);
				
		model.addAttribute("listagem", adocaoService.obterLista(usuario));
		
		return "adocao/lista";
	}

	@PostMapping(value = "/adocao/incluir")
	public String incluir(Adocao adocao, @SessionAttribute("user") Usuario usuario) {
		
		//teste inclusão
		System.out.println("TITULO = " + adocao.getTitulo());
		System.out.println("TUTOR = " +adocao.getTutor().getNome()+ "ID="+ adocao.getTutor().getId());
		
		for(Animal animal : adocao.getAnimais()) {
			System.out.println("ANIMAL = " + animal.getNome());
		}
		
		
		adocao.setUsuario(usuario);
		
		adocaoService.incluir(adocao);
		
		mensagem = "O registro da adoção "+adocao.getTitulo()+" "+adocao.getAnimais()+" foi registrada para "+adocao.getTutor()+"  com sucesso!";

		return "redirect:/adocao/listar";
	}
	
	@GetMapping(value = "/adocao/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Adocao adocao = null;
		
		try {
			adocao = adocaoService.obterPorId(id);
			adocaoService.excluir(id);
			mensagem = "A exclusão da adoção "+adocao.getTitulo()+"  foi realizada com sucesso!";
			
		} catch (Exception e) {
			mensagem2 = "Não foi possível realizar a exclusão da adoção "+adocao.getTitulo()+"!";
		}
		
		
		return "redirect:/adocao/listar";
	}
}