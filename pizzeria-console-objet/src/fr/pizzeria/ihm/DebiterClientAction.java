package fr.pizzeria.ihm;

import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Client;

public class DebiterClientAction extends Action {

	public DebiterClientAction(IhmHelper helper) {
		super("Debiter un client", helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		ListerClientAction lc = new ListerClientAction(helper);
		lc.execute();
		System.out.println("Veuillez saisir un client");
		String id = helper.getScanner().next();
		Client clientToUpdate = helper.getStockageClient().find(id);
		
		System.out.println("Veuillez saisir le montant a debiter");
		System.out.println(clientToUpdate.getNom());
		double montant = helper.getScanner().nextDouble();
		try {
			clientToUpdate.debiterCompte(montant);
		} catch (DebitException e) {
			e.printStackTrace();
			
		}
	}
}
