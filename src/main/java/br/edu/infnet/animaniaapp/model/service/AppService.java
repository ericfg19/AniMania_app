package br.edu.infnet.animaniaapp.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private CaninoService caninoService;
	
	@Autowired
	private FelinoService felinoService;
	
	@Autowired
	private RoedorService roedorService;
	
	@Autowired
	private AdocaoService adocaoService;
	
	
	public Map<String, Long> obterMapa(){ 
		
		Map<String, Long> mapaApp = new HashMap<String, Long>();
	
		mapaApp.put("Usuários", usuarioService.obterQtde());
		mapaApp.put("Tutores", tutorService.obterQtde());
		mapaApp.put("Animais", animalService.obterQtde());
		mapaApp.put("Caninos", caninoService.obterQtde());
		mapaApp.put("Felinos", felinoService.obterQtde());
		mapaApp.put("Roedores", roedorService.obterQtde());
		mapaApp.put("Adoções", adocaoService.obterQtde());
		
		return mapaApp;
	}

}
