package fr.pizzeria.service;

import java.util.Collection;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public interface Stockage<T> {

	Collection<T> findAll();
	
	T find(String id);
	void save(T newItem);
	void update(T editItem, String code);
	void delete(String ancienCode);	
}
