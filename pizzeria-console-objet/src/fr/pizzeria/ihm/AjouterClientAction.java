package fr.pizzeria.ihm;

import fr.pizzeria.model.Client;

public class AjouterClientAction extends Action {

	public AjouterClientAction(IhmHelper helper) {
		super("ajouter un client", helper);
		// TODO Auto-generated constructor stub
	}

@Override
public void execute() {	
	// récuperation de la saisie
			System.out.println("Vous voulez ajoutez un client");
			System.out.println("Veuillez saisir le nom du client");
			String nom = helper.getScanner().next();
			System.out.println("Veuillez saisir le prenom d'un client");
			String prenom = helper.getScanner().next();
			System.out.println("Veuillez saisir le solde d'un client");
			double solde = helper.getScanner().nextDouble();
			// creation de la nouvelle pizza
			Client nouveauClient = new Client(nom, prenom, solde);
			helper.getStockageClient().save(nouveauClient);

			System.out.println("Pizza ajouter avec succes" + "\n");
	}
}
