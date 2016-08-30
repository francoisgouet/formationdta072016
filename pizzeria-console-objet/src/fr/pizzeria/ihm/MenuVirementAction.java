package fr.pizzeria.ihm;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Client;

public class MenuVirementAction extends Action {

	public MenuVirementAction( IhmHelper helper) {
		super("Effectuer un virement entre deux clients", helper);
	}

	@Override
	public void execute() {
		ListerClientAction lc = new ListerClientAction(helper);
		lc.execute();
		System.out.println("Veuillez saisir le client à debiter");
		String idDebit = helper.getScanner().next();
		System.out.println("Veuillez saisir le client à crediter");
		String idCredit = helper.getScanner().next();
		Client clientDebit = helper.getStockageClient().find(idDebit);
		Client clientCredit = helper.getStockageClient().find(idCredit);
		
		
		System.out.println("Veuillez saisir le montant a debiter");
		System.out.println(clientDebit.getNom());
		double montant = helper.getScanner().nextDouble();
		try {
			clientDebit.debiterCompte(montant);
			clientCredit.crediterCompte(montant);
		} catch (DebitException e) {
			e.printStackTrace();
			
		} catch (CreditException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
