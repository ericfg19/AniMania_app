package br.edu.infnet.animaniaapp.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.animaniaapp.model.domain.Felino;

@Repository
public interface FelinoRepository extends CrudRepository<Felino, Integer> {

	@Query("from Felino f where f.usuario.id = :idUsuario")
	List<Felino> obterLista(Integer idUsuario, Sort by);
}