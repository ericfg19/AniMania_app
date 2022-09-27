package br.edu.infnet.animaniaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.animaniaapp.model.domain.Felino;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.FelinoService;

@Order(4)
@Component
public class FelinoLoader implements ApplicationRunner {
	
	@Autowired
	private FelinoService felinoService;
	
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario admin = new Usuario();
		admin.setId(1);
		
		Usuario dev = new Usuario();
		dev.setId(2);

		String[] felinos = {"Geronimo", "Faísca", "Acerola", "Niko", "Sukita"};
		
		for(String f : felinos) {
			Felino felino = new Felino();
			felino.setIdade(1);
			felino.setCastrado(true);
			felino.setRaca("SRD");
			felino.setNome(f);
			felino.setPeso(3);
			felino.setGenero(true);
			felino.setValor(250);
			felino.setUsuario(admin);
			
			felinoService.incluir(felino);
			
		}
		
		Felino felino = null;
		
		felino = felinoService.obterPorId(6);
		System.out.println("Inclusão do primeiro pet(gato): " + felino.getNome());
		
		System.out.println("## Felinos cadastrados por UserAdmin:");
		for(Felino f : felinoService.obterLista(admin)) {
			System.out.printf("%d - %s - %s\n",
					f.getId(),
					f.getUsuario(),
					f.getNome()
					
					);
		}
		
		felinoService.excluir(8);
		System.out.println("Exclusão do pet(gato): ID= "+felino.getId()+" -  " + felino.getNome());
	}
}
