package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ModifierPizzaAction extends Action {

	private Stockage stockage;
	private Scanner scanner;

	public ModifierPizzaAction(Stockage stockage, Scanner scanner) {
		super("Modifier une pizza");
		this.stockage = stockage;
		this.scanner = scanner;
	}

	@Override
	public void execute() {

		System.out.println("Vous voulez modifier une pizza veuillez choisir laquelle (nombre)");
		int id = scanner.nextInt();
		System.out.println("Veuillez saisir le nouveau code");
		String code = scanner.next();
		System.out.println("Veuillez saisir le nouveau nom de la pizza");
		String nom = scanner.next();
		System.out.println("Veuillez saisir le nouveau prix de la pizza");
		double prix = scanner.nextDouble();
		Pizza nouvellePizza = new Pizza(id - 1, code, nom, prix);
		stockage.updatePizza(nouvellePizza);

		System.out.println("Pizza modifier avec succes \n");

	}

}
