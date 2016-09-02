package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaAction extends Action {

	public ModifierPizzaAction(IhmHelper helper) {
		super("Modifier une pizza", helper);
	}

	@Override
	public void execute() throws IOException {
		ListerPizzaAction lp = new ListerPizzaAction(helper);
		lp.execute();
		System.out.println("Vous voulez modifier une pizza veuillez choisir laquelle (Code)");
		String ancienCode = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau code");
		String code = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau nom de la pizza");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau prix de la pizza");
		double prix = helper.getScanner().nextDouble();
		System.out.println("Veuillez saisir la categorie");
		String cat = helper.getScanner().next();
		Pizza nouvellePizza = new Pizza(code, nom, prix,CategoriePizza.valueOf(cat));
		helper.getStockagePizza().update(nouvellePizza, ancienCode);

		System.out.println("Pizza modifier avec succes \n");

	}

}
