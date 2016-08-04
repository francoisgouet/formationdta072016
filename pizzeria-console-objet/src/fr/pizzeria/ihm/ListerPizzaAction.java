package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ListerPizzaAction extends Action {

	private Stockage stockage;

	public ListerPizzaAction(Stockage stockage) {
		super("Lister les pizzas");
		this.stockage = stockage;
	}

	public void execute() {
		System.out.println("**** Liste de Pizzas ****");
		Pizza[] pizzas = this.stockage.TrouverPizza();
		for (int i = 0; i < pizzas.length; i++) {
			Pizza p = pizzas[i];
			System.out.println(p.getCode() + " " + p.getNom());
		}
	}

}
