package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public interface Stockage {

	Pizza[] trouverPizza();

	void savePizza(Pizza newPizza);

	void updatePizza(Pizza editPizza);

	void suppPizza(int j);

}
