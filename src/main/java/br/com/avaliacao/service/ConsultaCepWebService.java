package br.com.avaliacao.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.avaliacao.dao.EnderecoDao;
import br.com.avaliacao.entity.EnderecoEntity;
import br.com.avaliacao.helper.ObjectResponse;

@Path("/cep")
public class ConsultaCepWebService {

	private ObjectResponse objResponse = new ObjectResponse();
	private EnderecoDao dao;
	
	@GET
	@Path("/consulta/{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultaCep(@PathParam("cep") String cep){
		
		StringBuilder sb = new StringBuilder(cep);
		
		EnderecoEntity endereco = null;
		
		for(int x = 0; x < sb.length(); x++){
			
			int start = (sb.length()-(x+1));
			int end   = (sb.length()-x);
			
			sb.replace(start, end, "0");
			
			endereco = dao.findEnderecoByCep(sb.toString());
			
			if(endereco != null){
				break;
			}
			
		}
		
		if(endereco == null){
			objResponse.setMessage("CEP Inválido");
		}
		
		this.objResponse.setObject(endereco);
		
		return Response.ok(this.objResponse).build();
	}
	
}
