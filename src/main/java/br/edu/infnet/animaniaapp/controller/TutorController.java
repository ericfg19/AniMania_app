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
public class TutorController {
	
	private String mensagem;
	private String mensagem2;
	
	@Autowired 
	private TutorService tutorService;
	//


	
	@GetMapping(value = "/tutor")
	public String telaCadastro() {
		return "tutor/cadastro";
	}
	
	@GetMapping(value = "/tutor/listar")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("msg", mensagem);
		
		model.addAttribute("msg2", mensagem2);
		
		model.addAttribute("listagem", tutorService.obterLista(usuario));
		
		return "tutor/lista";
	}

	@PostMapping(value = "/tutor/incluir")
	public String incluir(Tutor tutor, @SessionAttribute("user") Usuario usuario) {
		
		tutor.setUsuario(usuario);
		
		tutorService.incluir(tutor);
		
		mensagem = "A inclusão do tutor "+tutor.getNome()+" (Email="+tutor.getEmail()+") ("+tutor.getGuarda()+") foi realizada com sucesso!";

		return "redirect:/tutor/listar";
	}
	
	@GetMapping(value = "/tutor/{id}/excluir")
	public String excluir(@PathVariable Integer id){
		
		Tutor tutor = null;
		
		try {
			tutor = tutorService.obterPorId(id);
			tutorService.excluir(id);
			mensagem = "A exclusão do tutor (ID="+id+") foi realizada com sucesso!";
		} catch (Exception e) {
			mensagem2 = "Não foi possível realizar a exclusão do tutor "+tutor.getNome()+"("+tutor.getId()+") pois este deve estar cadastrado em um pedido!";
		}
		

		return "redirect:/tutor/listar";
	}
}
