package fr.pizzeria.service;

import java.util.List;
import java.util.Set;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface Stockage {

	public List<Pizza> findAllPizzas();

	public void savePizza(Pizza newPizza) throws SavePizzaException;
	
	public void updatePizza(String codePizza) throws UpdatePizzaException;

	public void deletePizza(int ind) throws DeletePizzaException;
}
