package br.edu.infnet.animaniaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.animaniaapp.model.domain.Endereco;
import br.edu.infnet.animaniaapp.model.domain.Usuario;
import br.edu.infnet.animaniaapp.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired 
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Endereco enderecoAdmin = new Endereco();
		enderecoAdmin.setBairro("Fantasia");
		enderecoAdmin.setCep("cep matriz");
		enderecoAdmin.setComplemento("complemento admin");
		enderecoAdmin.setLocalidade("localidade admin");
		enderecoAdmin.setLogradouro("logradouro admin");
		enderecoAdmin.setUf("RJ");

		Usuario admin = new Usuario();
		admin.setAdmin(true);
		admin.setEmail("master@animania.com");
		admin.setEndereco(enderecoAdmin);
		admin.setNome("Master User");
		admin.setTelefone("21-99797-1000");
		admin.setSenha("12345");
		
		usuarioService.incluir(admin);
		
		Endereco enderecoDev = new Endereco();
		enderecoDev.setBairro("Contoso");
		enderecoDev.setCep("cep Contoso");
		enderecoDev.setComplemento("comp Teste");
		enderecoDev.setLocalidade("local Teste");
		enderecoDev.setLogradouro("Teste");
		enderecoDev.setUf("RJ");

		Usuario dev = new Usuario();
		dev.setAdmin(false);
		dev.setEmail("guardiao@animania.com");
		dev.setEndereco(enderecoDev);
		dev.setNome("Aristides Teste");
		dev.setSenha("12345");
		dev.setTelefone("21-99797-2000");
		
		usuarioService.incluir(dev);
		
		System.out.println("Usuários cadastrados: ");
		for(Usuario u : usuarioService.obterLista()) {
			System.out.println(u.getNome());
		}		
	}
}