package br.edu.infnet.animaniaapp.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.animaniaapp.model.domain.Tutor;

@Repository
public interface TutorRepository extends CrudRepository<Tutor, Integer> {

	@Query("from Tutor t where t.usuario.id = :idUsuario")
	List<Tutor> obterLista(Integer idUsuario, Sort by);
}