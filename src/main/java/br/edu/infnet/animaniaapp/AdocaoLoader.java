package br.edu.infnet.animaniaapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.animaniaapp.model.domain.*;
import br.edu.infnet.animaniaapp.model.service.AdocaoService;

@Order(6)
@Component
public class AdocaoLoader implements ApplicationRunner {


	@Autowired
	private AdocaoService adocaoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Tutor tutor = new Tutor();
		tutor.setId(1);
		
		Felino geronimo = new Felino();
		geronimo.setId(1);
		
		Felino nika = new Felino();
		nika.setId(4);
		
		Canino romario = new Canino();
		romario.setId(6);
		
		List<Animal> animais = new ArrayList<Animal>();
		animais.add(geronimo);
		animais.add(nika);
		animais.add(romario);
		

		Adocao adocao = new Adocao();
		adocao.setTitulo("Primeira Adoção");
		adocao.setAnimais(animais);
		adocao.setTutor(tutor);
		adocao.setUsuario(usuario);
		
		
		adocaoService.incluir(adocao);
	}
}