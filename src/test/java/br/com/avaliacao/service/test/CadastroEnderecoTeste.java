package br.com.avaliacao.service.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import br.com.avaliacao.entity.EnderecoEntity;

public class CadastroEnderecoTeste {

	public static void main(String[]args){

		EnderecoEntity endereco = new EnderecoEntity();
		
		endereco.setRua("Rua Direita");
		endereco.setNumero(48);
		endereco.setComplemento("Casper Libero");
		endereco.setBairro("Bela Vista");
		endereco.setCep("06080140");
		endereco.setCidade("Osasco");
		endereco.setEstado("SP");
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/avaliacao").path("/endereco/cadastro");
		String result = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(endereco, MediaType.APPLICATION_JSON), String.class);
		
		System.out.println(result);
		
	}

}
