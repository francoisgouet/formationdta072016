package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class AjouterPizzaAction extends Action {

	private Stockage stockage;
	private Scanner scanner;

	public AjouterPizzaAction() {
		super("Ajouter Pizza");
	}

	public AjouterPizzaAction(Stockage stockage) {
		super("Ajouter Pizza");
		this.stockage = stockage;
	}

	public AjouterPizzaAction(Stockage stockage, Scanner sc) {
		super("Ajouter Pizza");
		this.stockage = stockage;
		this.scanner = sc;
	}

	@Override
	public void execute() {

		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez	saisir	le	code");
		String code = scanner.next();
		System.out.println("Veuillez	saisir	le	nom	(sans	espace)");
		String nom = scanner.next();
		System.out.println("Veuillez	saisir	le	prix");
		Double prix = scanner.nextDouble();
		Pizza newPizza = new Pizza(0, code, nom, prix);
		try {
			stockage.savePizza(newPizza);
		} catch (SavePizzaException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}

}
