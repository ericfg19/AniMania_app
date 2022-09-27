package br.edu.infnet.animaniaapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.model.domain.*;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.repository.*;

@Service
public class FelinoService {

	@Autowired	
	private FelinoRepository felinoRepository;

	public void incluir(Felino felino) {
		felinoRepository.save(felino);		
	}
	
	public void excluir(Integer id) {
		felinoRepository.deleteById(id);
	}
	
	public Felino obterPorId(Integer id) {
		return felinoRepository.findById(id).orElse(null);
	}
	
	public List<Felino> obterLista(){
		return (List<Felino>) felinoRepository.findAll();
	}

	public List<Felino> obterLista(Usuario usuario){		
		return (List<Felino>) felinoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome", "raca", "peso"));
	}
}