package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Map<Integer,Action> actions = new HashMap();

	private Scanner scanner;

	public Menu(Stockage stockage, Scanner sc) {
		this.actions.put(1,new ListerPizzasAction(stockage)); 
		this.actions.put(2,new AjouterPizzaAction(stockage, sc));
		this.actions.put(3,new ModifierPizzaAction(stockage, sc)); 
		this.actions.put(4,new SupprimerPizzaAction(stockage, sc));
		this.scanner = sc;
	}

	public void start() {

		do {
			afficher();
		} while (!choisir());

	}

	private boolean choisir() {
		// TODO Auto-generated method stub

		System.out.println("Veuillez choisir");
		int choix = scanner.nextInt();
		if (choix <= 0 || choix > actions.size()) {
			if (choix != CHOIX_SORTIR) {
				System.out.println("Veuillez nettoyer");
			}
		} else {
			actions.get(choix).execute();
		}
		return choix == CHOIX_SORTIR;
	}

	public void afficher() {
		System.out.println("*** Application Pizzeria ***");
		for (Integer numero : actions.keySet()) {
			Action actionencours = actions.get(numero);
			System.out.println(numero + ". " + actionencours.getLibelle());
		}
		System.out.println("*** Application Pizzeria ***");
	}
}