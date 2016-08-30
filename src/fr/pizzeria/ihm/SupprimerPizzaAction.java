package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.service.Stockage;

public class SupprimerPizzaAction extends Action {
	private Stockage stockage;
	private Scanner scanner;

	public SupprimerPizzaAction(Stockage stockage) {
		super("Supprimer une pizza");
		this.stockage = stockage;
		// TODO Auto-generated constructor stub
	}

	public SupprimerPizzaAction() {
		super("Supprimer une pizza");
	}

	public SupprimerPizzaAction(Stockage stockage, Scanner sc) {
		super("Supprimer une pizza");
		this.stockage = stockage;
		this.scanner = sc;
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir la pizza a supprimer (99 pour abondonner)");
		ListerPizzasAction lp = new ListerPizzasAction(stockage);
		lp.execute();
		int choix = scanner.nextInt() - 1;
		try {
			stockage.deletePizza(choix);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
