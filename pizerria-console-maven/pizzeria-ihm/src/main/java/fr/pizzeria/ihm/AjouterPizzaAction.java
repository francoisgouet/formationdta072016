package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Ac
public class AjouterPizzaAction extends Action {
	
	public AjouterPizzaAction(IhmHelper helper) {
		super("Ajouter une pizza", helper);
	}

	@Override
	public void execute() {
		// r�cuperation de la saisie
		System.out.println("Vous voulez ajoutez une pizza");
		System.out.println("Veuillez saisir le code");
		String code = helper.getScanner().next();
		System.out.println("Veuillez saisir le nom de la pizza");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le prix de la pizza");
		double prix = helper.getScanner().nextDouble();
		System.out.println("Veuillez saisir l'enum");
		String enumeration = helper.getScanner().next();
		System.out.println();
		// creation de la nouvelle pizza
		CategoriePizza cat = CategoriePizza.valueOf(enumeration);
		Pizza nouvellePizza = new Pizza(code, nom, prix,cat);
		try {
			helper.getStockagePizza().save(nouvellePizza);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Pizza ajouter avec succes" + "\n");
	}
}
