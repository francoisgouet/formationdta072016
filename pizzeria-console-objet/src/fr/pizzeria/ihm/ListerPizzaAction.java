package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class ListerPizzaAction extends Action {

	public ListerPizzaAction(IhmHelper helper) {
		super("Lister les pizzas", helper);
	}

	public void execute() {
		System.out.println("**** Liste de Pizzas ****");
		Pizza[] pizzas = this.helper.getStockage().trouverPizza();
		for (int i = 0; i < pizzas.length; i++) {
			Pizza p = pizzas[i];
			System.out.println(p.getCode() + " " + p.getNom() + " " + p.getPrix());
		}
		System.out.println("\n");
	}

}
