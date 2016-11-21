package br.com.avaliacao.dao;

import br.com.avaliacao.entity.EnderecoEntity;

public interface EnderecoDao extends DAO<EnderecoEntity, Long> {

	public EnderecoEntity findEnderecoByCep(String cep);

}
