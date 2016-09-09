package fr.action;
import java.io.IOException;

import fr.pizzeria.model.Client;



@Actio
public class InscriptionAction extends Action{
	
	public InscriptionAction(Helper helper) {
		super("S'inscrire", helper);
	}

	@Override
	public void execute() throws IOException {
		System.out.println("Vous voulez ajoutez un client");
		System.out.println("Veuillez saisir le nom du client");
		String nom = helper.getScanner().next();			
		System.out.println("Veuillez saisir le prenom d'un client");
		String prenom = helper.getScanner().next();
		System.out.println("Veuillez saisir le solde d'un client");
		double solde = helper.getScanner().nextDouble();
		// creation de la nouvelle pizza
		Client nouveauClient = new Client(nom, prenom, solde);
		System.out.println(nouveauClient.toString());
		helper.getStockageClient().save(nouveauClient);
		System.out.println("Clients ajouter avec succes" + "\n");
	}
}
