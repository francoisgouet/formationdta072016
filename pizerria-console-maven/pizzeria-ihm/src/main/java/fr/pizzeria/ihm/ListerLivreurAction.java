package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Collection;

import fr.pizzeria.model.Livreur;

public class ListerLivreurAction extends Action {
	public ListerLivreurAction(IhmHelper helper) {
		super("Lister les livreurs", helper);
	}

	public void execute() throws IOException {
		System.out.println("**** Liste de Livreurs ****");
		Collection<Livreur> livreurs = this.helper.getStockageLivreur().findAll();
		/**J7 **/
		 /*for (Livreur livreurEnCours : livreurs) {
		 
			System.out.println(livreurEnCours.toString());
		}*/
		/** J8 **/
		livreurs.forEach(p -> System.out.println(p));
		System.out.println("\n");
		}
	}