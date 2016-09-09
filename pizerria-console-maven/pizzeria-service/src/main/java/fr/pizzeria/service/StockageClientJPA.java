package fr.pizzeria.service;

import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.pizzeria.model.Client;

public class StockageClientJPA implements Stockage<Client>{

	EntityManagerFactory emf;
	
	@Override
	public Collection<Client> findAll() {
		return null;
	}

	@Override
	public Client find(String id) {
		return null;
	}

	@Override
	public void save(Client newItem) throws IOException {
		System.out.println(newItem);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newItem);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Client editItem, String code) {
	}

	@Override
	public void delete(String ancienCode) {
	}

}
