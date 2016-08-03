package fr.pizzeria.console;

public class AfficherPizza {

	public void affichage (Pizza[] Tab){
		System.out.println("***** Liste de pizza *****");
		for ( int i=0; i<Tab.length; i++){
			System.out.println((i+1) +" " +Tab[i].code + " " + Tab[i].nom + " " + Tab[i].prix);
		}
		System.out.println("\n");
	}
}
