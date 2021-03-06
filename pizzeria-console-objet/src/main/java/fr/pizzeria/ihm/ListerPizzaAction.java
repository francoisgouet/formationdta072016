package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Collection;

import fr.pizzeria.model.Pizza;

public class ListerPizzaAction extends Action {

	public ListerPizzaAction(IhmHelper helper) {
		super("Lister les pizzas", helper);
	}

	public void execute() throws IOException {
		System.out.println("**** Liste de Pizzas ****");
		Collection<Pizza> pizzas = this.helper.getStockagePizza().findAll();
		pizzas.forEach(System.out::println);
	}

}
