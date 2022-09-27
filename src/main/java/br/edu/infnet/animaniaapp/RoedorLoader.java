package br.edu.infnet.animaniaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.animaniaapp.model.domain.Roedor;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.RoedorService;

@Order(5)
@Component
public class RoedorLoader implements ApplicationRunner {
	
	@Autowired
	private RoedorService roedorService;
	
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario admin = new Usuario();
		admin.setId(1);
		
		Usuario dev = new Usuario();
		dev.setId(2);

		String[] roedores = {"Jerry", "Remy", "Ligeirinho", "Cérebro", "Mickey"};
		
		for(String r : roedores) {
			Roedor roedor = new Roedor();
			roedor.setIdade(1);
			roedor.setCastrado(true);
			roedor.setRaca("Hamster");
			roedor.setNome(r);
			roedor.setPeso(1);
			roedor.setGenero(true);
			roedor.setValor(300);
			roedor.setUsuario(admin);
			
			roedorService.incluir(roedor);
			
		}
		
		Roedor roedor = null;
		
		roedor = roedorService.obterPorId(11);
		System.out.println("Inclusão do primeiro pet(roedor): " + roedor.getNome());
		
		System.out.println("## Roedores cadastrados por UserAdmin:");
		for(Roedor r : roedorService.obterLista(admin)) {
			System.out.printf("%d - %s - %s\n",
					r.getId(),
					r.getUsuario(),
					r.getNome()
					
					);
		}
		
		roedorService.excluir(13);
		System.out.println("Exclusão do pet(roedor): ID= "+roedor.getId()+" - " + roedor.getNome());
	}
}
