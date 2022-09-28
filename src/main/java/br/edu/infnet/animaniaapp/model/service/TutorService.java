package br.edu.infnet.animaniaapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.model.domain.Tutor;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.repository.TutorRepository;

@Service
public class TutorService {
	
	@Autowired
	private TutorRepository tutorRepository;

	public void incluir(Tutor tutor) {
		tutorRepository.save(tutor);
	}
	
	public void excluir(Integer id) {
		tutorRepository.deleteById(id);
	}
	
	public Tutor obterPorId(Integer id) {
		return tutorRepository.findById(id).orElse(null);
	}
	
	public List<Tutor> obterLista(){		
		return (List<Tutor>) tutorRepository.findAll();
	}

	public List<Tutor> obterLista(Usuario usuario){		
		return (List<Tutor>) tutorRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public long obterQtde() {
		return tutorRepository.count();
	}
}