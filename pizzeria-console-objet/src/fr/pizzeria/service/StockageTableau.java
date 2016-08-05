package fr.pizzeria.service;

import java.util.Arrays;

import fr.pizzeria.exception.SaisieCodeException;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public Pizza[] pizzas = { new Pizza(0, "PEP", "Pépéroni", 12.50), new Pizza(1, "MAR", "Margherita", 14.00),
			new Pizza(2, "REI", "La Reine", 11.50), new Pizza(3, "FRO", "La 4 fromages", 12.00),
			new Pizza(4, "CAN", "La cannibale", 12.50), new Pizza(5, "SAV", "La savoyarde", 13.00),
			new Pizza(6, "ORI", "L'orientale", 13.50), new Pizza(7, "IND", "L'indienne", 14.00) };

	@Override
	public Pizza[] trouverPizza() {
		return pizzas;
	}

	@Override
	public void savePizza(Pizza newPizza) {
		Pizza[] newTab = Arrays.copyOf(pizzas, pizzas.length + 1);
		newPizza.setId(pizzas.length);
		newTab[pizzas.length] = newPizza;
		pizzas = newTab;

	}

	public void saisirCode(Pizza newPizza) throws SaisieCodeException {
		if (newPizza.getCode().length() < 3 || newPizza.getCode().length() > 3) {
			SaisieCodeException CodeException = new SaisieCodeException("Attention rentrer un code a 3 chiffres");
			throw CodeException;
		}
	}

	@Override
	public void updatePizza(Pizza editPizza) {
		int id = editPizza.getId();
		pizzas[id] = editPizza;

	}

	@Override
	public void suppPizza(int j) {
		Pizza[] newTab1 = Arrays.copyOf(pizzas, pizzas.length - 1);
		int id = j;
		int Index = 0;
		for (int i = 0; i < pizzas.length - 1; i++) {
			if (i >= id) {
				Index = i + 1;
			} else {
				Index = i;
			}

			newTab1[i] = pizzas[Index];

		}
		pizzas = newTab1;
	}

}
