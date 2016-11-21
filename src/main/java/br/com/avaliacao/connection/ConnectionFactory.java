package br.com.avaliacao.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	
private static ConnectionFactory connectionFactory;
	
	public static ConnectionFactory getInstance(){
		
		if(connectionFactory != null){
			return connectionFactory;
		}
		
		return new ConnectionFactory();
		
	}

	
	public EntityManagerFactory getEntityManagerFactory(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-eclipselink");
		return emf;
	}
	

}
