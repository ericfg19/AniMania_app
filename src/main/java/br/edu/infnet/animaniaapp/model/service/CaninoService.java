package br.edu.infnet.animaniaapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.model.domain.*;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.repository.*;

@Service
public class CaninoService {

	@Autowired	
	private CaninoRepository caninoRepository;

	public void incluir(Canino canino) {
		caninoRepository.save(canino);		
	}
	
	public void excluir(Integer id) {
		caninoRepository.deleteById(id);
	}
	
	public Canino obterPorId(Integer id) {
		return caninoRepository.findById(id).orElse(null);
	}
	
	public List<Canino> obterLista(){
		return (List<Canino>) caninoRepository.findAll();
	}

	public List<Canino> obterLista(Usuario usuario){		
		return (List<Canino>) caninoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome", "raca", "peso"));
	}
	
	public long obterQtde() {
		return caninoRepository.count();
	}
}