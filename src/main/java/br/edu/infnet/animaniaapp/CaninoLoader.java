package br.edu.infnet.animaniaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.animaniaapp.model.domain.Canino;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.CaninoService;

@Order(3)
@Component
public class CaninoLoader implements ApplicationRunner {
	
	@Autowired
	private CaninoService caninoService;
	
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario admin = new Usuario();
		admin.setId(1);
		
		Usuario dev = new Usuario();
		dev.setId(2);

		String[] caninos = {"Maradona", "Romario", "Messi", "Pelé", "Ronaldinho"};
		
		for(String c : caninos) {
			Canino canino = new Canino();
			canino.setIdade(1);
			canino.setCastrado(true);
			canino.setRaca("SRD");
			canino.setNome(c);
			canino.setPeso(20);
			canino.setGenero(true);
			canino.setValor(250);
			canino.setUsuario(admin);
			
			caninoService.incluir(canino);
			
		}
		
		Canino canino = null;
		
		canino = caninoService.obterPorId(1);
		System.out.println("Inclusão do primeiro pet(cão): " + canino.getNome());
		
		System.out.println("## Cães cadastrados por UserAdmin:");
		for(Canino c : caninoService.obterLista(admin)) {
			System.out.printf("%d - %s - %s\n",
					c.getId(),
					c.getUsuario(),
					c.getNome()
					
					);
		}
		
		caninoService.excluir(2);
		System.out.println("Exclusão do pet(cão): ID= "+canino.getId()+" -  " + canino.getNome());
		
	}
}
