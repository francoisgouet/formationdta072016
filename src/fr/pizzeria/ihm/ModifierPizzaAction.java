package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ModifierPizzaAction extends Action {
	private Stockage stockage;
	private Scanner scanner;

	public ModifierPizzaAction() {
		super("Modifier les pizzas");
		this.stockage = stockage;
	}

	public ModifierPizzaAction(Stockage stockage, Scanner sc) {
		super("Modifier les pizzas");
		this.stockage = stockage;
		this.scanner = sc;
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir la pizza a modifier (99 pour abondonner)");
		ListerPizzasAction lp = new ListerPizzasAction(stockage);
		lp.execute();
		int choix = scanner.nextInt() - 1;
		System.out.println("Veuillez	saisir	le nouveau	code");
		String code = scanner.next();
		System.out.println("Veuillez	saisir	le	nouveau nom	(sans	espace)");
		String nom = scanner.next();
		System.out.println("Veuillez	saisir	le	nouveau prix");
		Double prix = scanner.nextDouble();
		// Pizza p = new Pizza(choix, code, nom, prix);

		Pizza modif = stockage.findAllPizzas().get(choix);
		modif.setCode(code);
		stockage.findAllPizzas().get(choix).setNom(nom);
		stockage.findAllPizzas().get(choix).setPrix(prix);
		
	}
}
