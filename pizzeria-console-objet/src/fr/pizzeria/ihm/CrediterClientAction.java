package fr.pizzeria.ihm;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class CrediterClientAction extends Action {

	public CrediterClientAction(IhmHelper helper) {
		super("Crediter un compte", helper);
		
	}
	@Override
	public void execute() {
		ListerClientAction lc = new ListerClientAction(helper);
		lc.execute(); 
		System.out.println("Veuillez saisir un client");
		String id = helper.getScanner().next();
		Client clientToUpdate = helper.getStockageClient().find(id);
		
		System.out.println("Veuillez saisir le montant a crediter");
		double montant = helper.getScanner().nextDouble();
		try {
			clientToUpdate.crediterCompte(montant);
		} catch (CreditException e) {
			e.printStackTrace();
		}
	}
}
