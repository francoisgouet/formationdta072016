package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class SupprimerPizzaAction extends Action {

	private Stockage stockage;
	private Scanner scanner;

	public SupprimerPizzaAction(Stockage stockage, Scanner scanner) {
		super("Supprimer une pizza");
		this.stockage = stockage;
		this.scanner = scanner;
	}

	@Override
	public void execute() {
		System.out.println("Vous voulez supprimez une pizza veuillez choisir laquelle (nombre)");
		int id = scanner.nextInt();
		stockage.suppPizza(id - 1);

		System.out.println("Pizza supprimer avec succes \n");

	}

}
