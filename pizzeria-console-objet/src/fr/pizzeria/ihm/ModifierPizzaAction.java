package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaAction extends Action {

	public ModifierPizzaAction(IhmHelper helper) {
		super("Modifier une pizza", helper);
	}

	@Override
	public void execute() {

		System.out.println("Vous voulez modifier une pizza veuillez choisir laquelle (nombre)");
		int id = helper.getScanner().nextInt();
		System.out.println("Veuillez saisir le nouveau code");
		String code = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau nom de la pizza");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau prix de la pizza");
		double prix = helper.getScanner().nextDouble();
		Pizza nouvellePizza = new Pizza(id - 1, code, nom, prix);
		helper.getStockage().updatePizza(nouvellePizza);

		System.out.println("Pizza modifier avec succes \n");

	}

}
