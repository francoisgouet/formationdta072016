package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public Pizza[] pizzas = { new Pizza(0, "PEP", "Pépéroni", 12.50), new Pizza(1, "MAR", "Margherita", 14.00),
			new Pizza(2, "REI", "La Reine", 11.50), new Pizza(3, "FRO", "La 4 fromages", 12.00),
			new Pizza(4, "CAN", "La cannibale", 12.50), new Pizza(5, "SAV", "La savoyarde", 13.00),
			new Pizza(6, "ORI", "L'orientale", 13.50), new Pizza(7, "IND", "L'indienne", 14.00) };

	@Override
	public Pizza[] TrouverPizza() {
		// TODO Auto-generated method stub
		return pizzas;
	}

	@Override
	public void savePizza(Pizza newPizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(Pizza editPizza) {
		// TODO Auto-generated method stub

	}

}
