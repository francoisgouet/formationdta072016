package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {
	public static Pizza[] tabPizza = { new Pizza(0, "PEP", "P�p�roni", 12.50),
			new Pizza(1, "MAR", "Margherita", 14.00), new Pizza(2, "REI", "La reine", 11.50),
			new Pizza(3, "FRO", "La 4 Fromtons", 12.00), new Pizza(4, "CAN", "La cannibale", 12.50),
			new Pizza(5, "SAV", "La savoyarde", 13.00), new Pizza(6, "ORI", "L'orientale", 13.50),
			new Pizza(7, "IND", "L'indienne", 14.00) };
	//List<Pizza> lp = Arrays.asList(tabPizza);
	List<Pizza> listePizza = new ArrayList<>(Arrays.asList(tabPizza));
	//listePizza.addAll(lp);

	@Override
	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza)throws SavePizzaException {
		newPizza.setId(listePizza.size());
		if (newPizza.getCode().length() != 3){
			throw new SavePizzaException("Code pas bon");
		}
		listePizza.add(newPizza);
		
	}

	@Override
	public void deletePizza(int ind) {
		listePizza.remove(ind);
		updateIndex();
	}
	
	public void updateIndex() {
		for (int i = 0; i < listePizza.size(); i++) {
			listePizza.get(i).setId(i);
		}
	}

	@Override
	public void updatePizza(String codePizza) throws UpdatePizzaException {
	}
}
