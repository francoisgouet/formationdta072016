package fr.pizzeria.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import fr.pizzeria.model.Pizza;

public class StockagePizzaJpa implements Stockage<Pizza> {

	EntityManagerFactory emf;

	public StockagePizzaJpa(EntityManagerFactory entityManagerFactory) {
		this.emf = entityManagerFactory;
	}

	public StockagePizzaJpa() {
		emf = Persistence.createEntityManagerFactory("pizzeria-unit");
	}

	@Override
	public Collection<Pizza> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Pizza p");
		List<Pizza> lp = (ArrayList) query.getResultList();
		em.close();
		return lp;
	}

	@Override
	public Pizza find(String code) {
		EntityManager em = emf.createEntityManager();
		return em.createNamedQuery("pizza.findByCode",
				Pizza.class)
				.setParameter("c", code)
				.getSingleResult();
	}

	@Override
	public void save(Pizza newItem) throws IOException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(newItem);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Pizza editItem, String code) {

		Consumer<EntityManager> c = x -> {
			TypedQuery<Pizza> query = x.createQuery("select p from Pizza p where p.code=:ref", Pizza.class)
					.setParameter("ref", code);
			Pizza p = query.getSingleResult();
			x.getTransaction().begin();
			Integer id = p.getId();
			// mettre le bon id a la pizza modifi�e
			editItem.setId(id);
			// merger
			x.merge(editItem);
		};
		
		mutualiser(c);
	}

	public void mutualiser(Consumer<EntityManager> code) {
		EntityManager em = emf.createEntityManager();
		code.accept(em);
		// commit transaction at all
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(String ancienCode) {
		EntityManager em = emf.createEntityManager();
		// plus rapide que de recuperer l'objet
		em.getTransaction().begin();
		Query query = em.createQuery("delete from Pizza where code=:ref").setParameter("ref", ancienCode);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.emf = entityManagerFactory;
	}
}
