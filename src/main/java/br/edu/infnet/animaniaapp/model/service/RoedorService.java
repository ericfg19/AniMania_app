package br.edu.infnet.animaniaapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.model.domain.*;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.repository.*;

@Service
public class RoedorService {

	@Autowired	
	private RoedorRepository roedorRepository;

	public void incluir(Roedor roedor) {
		roedorRepository.save(roedor);		
	}
	
	public void excluir(Integer id) {
		roedorRepository.deleteById(id);
	}
	
	public Roedor obterPorId(Integer id) {
		return roedorRepository.findById(id).orElse(null);
	}
	
	public List<Roedor> obterLista(){
		return (List<Roedor>) roedorRepository.findAll();
	}

	public List<Roedor> obterLista(Usuario usuario){		
		return (List<Roedor>) roedorRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome", "raca", "peso"));
	}
	
	public long obterQtde() {
		return roedorRepository.count();
	}
}