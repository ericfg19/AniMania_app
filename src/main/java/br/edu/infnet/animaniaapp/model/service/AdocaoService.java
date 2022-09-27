package br.edu.infnet.animaniaapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.model.domain.Adocao;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.repository.AdocaoRepository;

@Service
public class AdocaoService {

	@Autowired	
	private AdocaoRepository adocaoRepository;

	public void incluir(Adocao adocao) {
		adocaoRepository.save(adocao);		
	}
	
	public void excluir(Integer id) {
		adocaoRepository.deleteById(id);
	}
	
	public Adocao obterPorId(Integer id) {
		return adocaoRepository.findById(id).orElse(null);
	}
	
	public List<Adocao> obterLista(){
		return (List<Adocao>) adocaoRepository.findAll();
	}

	public List<Adocao> obterLista(Usuario usuario){		
		return (List<Adocao>) adocaoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "data", "titulo"));
	}
}