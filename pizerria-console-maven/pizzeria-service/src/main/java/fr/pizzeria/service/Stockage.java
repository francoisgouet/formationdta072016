package fr.pizzeria.service;

import java.io.IOException;
import java.util.Collection;

public interface Stockage<T> {

	Collection<T> findAll();
	
	T find(String id);
	void save(T newItem) throws IOException;
	void update(T editItem, String code);
	void delete(String ancienCode);	
}
