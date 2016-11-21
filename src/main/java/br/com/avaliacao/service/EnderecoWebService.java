package br.com.avaliacao.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.avaliacao.dao.EnderecoDao;
import br.com.avaliacao.dao.EnderecoDaoImpl;
import br.com.avaliacao.entity.EnderecoEntity;
import br.com.avaliacao.helper.ObjectResponse;

@Path("/endereco")
public class EnderecoWebService {
	
	private ObjectResponse objResponse = new ObjectResponse();
	private EnderecoDao dao = new EnderecoDaoImpl();
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarEndereco(EnderecoEntity endereco){
		
		this.validade(endereco);
	
		if(this.objResponse.hasError()){
			this.objResponse.setMessage("Erro ao validar dados de entrada!");
			return Response.ok(this.objResponse).build();
		}
		
		this.dao.save(endereco);
		this.objResponse.setMessage("Endereço cadastrado com sucesso!");
		return Response.ok(this.objResponse).build();
	}
	
	
	@POST
	@Path("/alteracao")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarEndereco(EnderecoEntity endereco){
		
		this.validade(endereco);
		
		if(this.objResponse.hasError()){
			this.objResponse.setMessage("Erro ao validar dados de entrada!");
			return Response.ok(this.objResponse).build();
		}
		
		this.dao.save(endereco);
		return Response.ok("Endereço alterado com sucesso!").build();
	}
	
	
	@GET
	@Path("/exclusao/{idEndereco}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response excluirEndereco(@PathParam("idEndereco") Long id){
		EnderecoEntity endereco = this.dao.findById(EnderecoEntity.class, id);
		this.dao.remove(endereco);
		return Response.ok("Endereço deletado com sucesso!").build();
	}
	
	
	private void validade(EnderecoEntity endereco){
		
		if(endereco.getRua() == null || endereco.getRua().trim().equals("")){
			this.objResponse.setError("Campo Rua é Obrigatório!");
		}
		
		if(endereco.getNumero() == null){
			this.objResponse.setError("Campo Número é Obrigatório!");
		}
		
		if(endereco.getCep() == null || endereco.getCep().trim().equals("")){
			this.objResponse.setError("Campo Cep é Obrigatório!");
		}
		
		if(endereco.getCidade() == null || endereco.getCidade().trim().equals("")){
			this.objResponse.setError("Campo Cidade é Obrigatório!");
		}
		
		if(endereco.getEstado() == null || endereco.getEstado().trim().equals("")){
			this.objResponse.setError("Campo Estado é Obrigatório!");
		}
		
	}
	

}
