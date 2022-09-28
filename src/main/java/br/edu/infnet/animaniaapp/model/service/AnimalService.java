package br.edu.infnet.animaniaapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.model.domain.Animal;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.repository.AnimalRepository;


@Service
public class AnimalService {

	@Autowired	
	private AnimalRepository animalRepository;

	public void incluir(Animal animal) {
		animalRepository.save(animal);		
	}
	
	public void excluir(Integer id) {
		animalRepository.deleteById(id);
	}
	
	public Animal obterPorId(Integer id) {
		return animalRepository.findById(id).orElse(null);
	}
	
	public List<Animal> obterLista(){
		return (List<Animal>) animalRepository.findAll();
	}

	public List<Animal> obterLista(Usuario usuario){		
		return (List<Animal>) animalRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public long obterQtde() {
		return animalRepository.count();
	}
}