package fr.pizzeria.ihm;

import fr.pizzeria.exception.SaisieEntierException;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Action[] actions;
	private IhmHelper ihmHelper;

	public Menu(IhmHelper helper) {
		this.actions = new Action[] { new ListerPizzaAction(helper), new AjouterPizzaAction(helper),
				new ModifierPizzaAction(helper), new SupprimerPizzaAction(helper) };
		this.ihmHelper = helper;
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
		System.out.println(CHOIX_SORTIR + ". Quitter" + "\n");
	}

	public boolean choisir() {
		System.out.println("Veuillez choisir une option");
		int choix = 0;
		try {
			// Instructions susceptibles de provoquer des erreurs;

			choix = ihmHelper.saisirEntier();
			if (choix <= 0 || choix > actions.length) {
				if (choix != CHOIX_SORTIR) {
					System.out.println("Erreur de saisie, veuillez recommencer!" + "\n");
				}
			} else {

				Action LaBonneAction = actions[choix - 1];
				LaBonneAction.execute();

			}
		} catch (SaisieEntierException e) {
			System.out.println(e.getMessage());
		}

		return choix == CHOIX_SORTIR;
	}

}
