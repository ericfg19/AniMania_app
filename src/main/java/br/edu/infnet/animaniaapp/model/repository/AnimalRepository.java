package br.edu.infnet.animaniaapp.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.animaniaapp.model.domain.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

	@Query("from Animal a where a.usuario.id = :idUsuario")
	List<Animal> obterLista(Integer idUsuario, Sort by);
}