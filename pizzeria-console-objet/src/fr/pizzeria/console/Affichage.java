package fr.pizzeria.console;

public class Affichage {
	
	public void affichageM (){
		System.out.println("***** Pizzeria Administration *****");	
		System.out.println("1.	Lister les pizzas ");
		System.out.println("2.	Ajouter une nouvelle pizza");
		System.out.println("3.	Mettre à jour une pizza");
		System.out.println("4.	Supprimer une pizza");
		System.out.println("99.	Sortir" + "\n");
		System.out.println("\n");
	}
	
	
	public void affichageP (Pizza[] Tab){
		System.out.println("***** Liste de pizza *****");
		for ( int i=0; i<Tab.length; i++){
			System.out.println((i+1) +" " +Tab[i].code + " " + Tab[i].nom + " " + Tab[i].prix);
		}
		System.out.println("\n");
	}

}
