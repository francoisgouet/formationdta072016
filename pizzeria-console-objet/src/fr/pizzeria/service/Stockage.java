package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public interface Stockage {

	Pizza[] TrouverPizza();

	void savePizza(Pizza newPizza);

	void updatePizza(Pizza editPizza);

}
