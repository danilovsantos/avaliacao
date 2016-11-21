package br.com.avaliacao.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.avaliacao.connection.ConnectionFactory;
import br.com.avaliacao.entity.EnderecoEntity;

public class EnderecoDaoImpl extends DAOImpl<EnderecoEntity, Long> implements EnderecoDao {

	
	@Override
	public EnderecoEntity findEnderecoByCep(String cep){

		EntityManagerFactory emf = ConnectionFactory.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select t from EnderecoEntity as t where t.cep = :nrCep");
		query.setParameter("nrCep", cep);

		return (EnderecoEntity) query.getSingleResult();

	}
	
}
