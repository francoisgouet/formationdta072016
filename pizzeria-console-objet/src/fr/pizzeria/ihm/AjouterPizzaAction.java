package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class AjouterPizzaAction extends Action {

	private Stockage stockage;
	private Scanner scanner;

	public AjouterPizzaAction(Stockage stockage, Scanner scanner) {
		super("Ajouter une pizza");
		this.stockage = stockage;
		this.scanner = scanner;
	}

	@Override
	public void execute() {

		// récuperation de la saisie
		System.out.println("Vous voulez ajoutez une pizza");
		System.out.println("Veuillez saisir le code");
		String code = scanner.next();
		System.out.println("Veuillez saisir le nom de la pizza");
		String nom = scanner.next();
		System.out.println("Veuillez saisir le prix de la pizza");
		double prix = scanner.nextDouble();
		// creation de la nouvelle pizza
		Pizza nouvellePizza = new Pizza(0, code, nom, prix);
		stockage.savePizza(nouvellePizza);

		System.out.println("Pizza ajouter avec succes");

	}

}
