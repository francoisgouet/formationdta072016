package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ListerPizzasAction extends Action {

	private Stockage stockage;

	public ListerPizzasAction(Stockage stockage) {
		super("Lister les pizzas");
		this.stockage = stockage;
	}

	public ListerPizzasAction() {
		super("Lister les pizzas");
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		//stockage.findAllPizzas().sort(c);
		for (Pizza piz : this.stockage.findAllPizzas()) {
			System.out.println(
					(piz.getId() + 1) + ". " + piz.getCode() + "->" + piz.getNom() + "(" + piz.getPrix() + "€)");
		}
		System.out.println("--------------" + Pizza.NB_PIZZAS + " pizzas " + " depuis l'initialisation du programme");
	}

}