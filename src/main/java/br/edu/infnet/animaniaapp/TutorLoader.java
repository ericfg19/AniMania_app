package br.edu.infnet.animaniaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.animaniaapp.model.domain.Tutor;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.TutorService;

@Order(2)
@Component
public class TutorLoader implements ApplicationRunner {

	@Autowired 
	private TutorService tutorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Tutor tutor = new Tutor();
		tutor.setCpf("222333444-55");
		tutor.setEmail("anna@gmail.com");
		tutor.setNome("Annabeth");
		tutor.setTelefone("21-99797-0000");
		tutor.setGuarda("Lar Temporário");
		tutor.setUsuario(usuario);
		

		tutorService.incluir(tutor);
	}
}