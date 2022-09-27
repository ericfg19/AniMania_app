package br.edu.infnet.animaniaapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.animaniaapp.clients.IEnderecoClient;
import br.edu.infnet.animaniaapp.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscarCep(String cep){

		return enderecoClient.buscarCep(cep);
	}
}