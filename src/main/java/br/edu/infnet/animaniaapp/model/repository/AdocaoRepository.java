package br.edu.infnet.animaniaapp.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.edu.infnet.animaniaapp.model.domain.Adocao;

@Repository
public interface AdocaoRepository extends CrudRepository<Adocao, Integer> {

	@Query("from Adocao ad where ad.usuario.id = :idUsuario")
	List<Adocao> obterLista(Integer idUsuario, Sort by);
}