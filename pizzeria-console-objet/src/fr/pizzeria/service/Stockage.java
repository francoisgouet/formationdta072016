package fr.pizzeria.service;

import java.util.Collection;

import fr.pizzeria.model.Pizza;

public interface Stockage {

	Collection<Pizza> trouverPizza();

	void savePizza(Pizza newPizza);

	void updatePizza(Pizza editPizza, String code);

	void suppPizza(String ancienCode);

	void savePizza(String code, String nom);

}
