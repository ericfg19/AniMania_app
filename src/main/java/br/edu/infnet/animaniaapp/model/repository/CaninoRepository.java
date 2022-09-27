package br.edu.infnet.animaniaapp.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.animaniaapp.model.domain.Canino;

@Repository
public interface CaninoRepository extends CrudRepository<Canino, Integer> {

	@Query("from Canino c where c.usuario.id = :idUsuario")
	List<Canino> obterLista(Integer idUsuario, Sort by);
}