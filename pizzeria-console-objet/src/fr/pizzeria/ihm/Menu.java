package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Action[] actions;
	private Scanner scanner;

	public Menu(Stockage stockage, Scanner scanner) {
		this.actions = new Action[] { new ListerPizzaAction(stockage), new AjouterPizzaAction(stockage, scanner),
				new ModifierPizzaAction(stockage, scanner), new SupprimerPizzaAction(stockage, scanner) };
		this.scanner = scanner;
	}

	public void start() {
		boolean result = false;
		do {
			affichageM();
			result = choisir();
		} while (!result);
	}

	public void affichageM() {
		System.out.println("***** Pizzeria Administration *****");

		for (int i = 0; i < actions.length; i++) {
			Action ActionEnCours = actions[i];
			String libelleAction = ActionEnCours.getLibelle();
			int indexMenu = i + 1;
			System.out.println(indexMenu + " " + libelleAction);

		}
		System.out.println(CHOIX_SORTIR + ". Quitter");
	}

	public boolean choisir() {
		System.out.println("Veuillez choisir une option");
		int choix = scanner.nextInt();
		if (choix <= 0 || choix > actions.length) {
			if (choix != CHOIX_SORTIR) {
				System.out.println("Erreur de saisie, veuillez recommencer!");
			}
		} else {

			Action LaBonneAction = actions[choix - 1];
			LaBonneAction.execute();

		}
		return choix == CHOIX_SORTIR;
	}

}
