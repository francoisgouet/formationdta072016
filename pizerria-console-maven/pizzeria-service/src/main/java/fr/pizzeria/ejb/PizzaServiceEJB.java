package fr.pizzeria.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;


@Stateless
public class PizzaServiceEJB /*implements Stockage<Pizza>*/{

	@PersistenceContext private EntityManager em;

	
	public Collection<Pizza> findAll() {
		Query query = em.createQuery("select p from Pizza p");
		List<Pizza> lp = (ArrayList) query.getResultList();
		return lp;
	}

	
	public Pizza find(String id) {
		return em.createNamedQuery("pizza.findByCode",
				Pizza.class)
				.setParameter("c", id)
				.getSingleResult();
	}

	
	public void save(Pizza newItem) throws IOException {
		em.persist(newItem);
	}

	
	public void update(Pizza editItem, String code) {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code=:ref", Pizza.class)
				.setParameter("ref", code);
		Pizza p = query.getSingleResult();
		Integer id = p.getId();
		// mettre le bon id a la pizza modifie
		editItem.setId(id);
		// merger
		em.merge(editItem);
	}


	public void delete(String ancienCode) {
		Query query = em.createQuery("delete from Pizza where code=:ref").setParameter("ref", ancienCode);
		query.executeUpdate();
	}
}