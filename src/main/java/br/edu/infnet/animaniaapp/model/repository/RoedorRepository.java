package br.edu.infnet.animaniaapp.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.animaniaapp.model.domain.Roedor;

@Repository
public interface RoedorRepository extends CrudRepository<Roedor, Integer> {

	@Query("from Roedor r where r.usuario.id = :idUsuario")
	List<Roedor> obterLista(Integer idUsuario, Sort by);
}