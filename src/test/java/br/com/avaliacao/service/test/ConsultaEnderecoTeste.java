package br.com.avaliacao.service.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ConsultaEnderecoTeste {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();		
		String result = client.target("http://localhost:8080/avaliacao")
  			                  .path("/cep/consulta/06080140")
                              .request(MediaType.APPLICATION_JSON)
                              .get(String.class);
		
		System.out.println(result);

	}

}
