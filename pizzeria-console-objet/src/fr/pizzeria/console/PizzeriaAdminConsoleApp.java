package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		int choix = 0;
		Scanner nombre = new Scanner(System.in);
		
		Pizza Peperoni = new Pizza();
		Peperoni.id = 0;
		Peperoni.code = "PEP";
		Peperoni.nom = "Pépéroni";
		Peperoni.prix = 12.50;
		Pizza Margarita = new Pizza();
		Margarita.id = 1;
		Margarita.code = "MAR";
		Margarita.nom = "Margariata";
		Margarita.prix = 14.00;
		Pizza Reine = new Pizza();
		Reine.id = 2;
		Reine.code = "REI";
		Reine.nom = "La Reine";
		Reine.prix = 11.50;
		Pizza Fromage = new Pizza();
		Fromage.id = 3;
		Fromage.code = "FRO";
		Fromage.nom = "La 4 fromage";
		Fromage.prix = 12.00;
		Pizza Cannibale = new Pizza();
		Cannibale.id = 4;
		Cannibale.code = "CAN";
		Cannibale.nom = "La cannibale";
		Cannibale.prix = 12.50;
		Pizza Savoyarde = new Pizza();
		Savoyarde.id = 5;
		Savoyarde.code = "SAV";
		Savoyarde.nom = "La savoyarde";
		Savoyarde.prix = 13.00;
		Pizza Oriantale = new Pizza();
		Oriantale.id = 6;
		Oriantale.code = "ORI";
		Oriantale.nom = "L'oriantalei";
		Oriantale.prix = 13.50;
		Pizza Indienne = new Pizza();
		Indienne.id = 7;
		Indienne.code = "IND";
		Indienne.nom = "L'indienne";
		Indienne.prix = 14.00;

		Pizza[] pizzas = {Peperoni,Margarita,Reine,Fromage,Cannibale,Savoyarde,Oriantale,Indienne};
	
		
		while (choix == 0){
			Affichage ListMenu = new Affichage();
	    	ListMenu.affichageM();
			 try {
			    // Instructions susceptibles de provoquer des erreurs;
				 String saisie = nombre.next();
				 choix = Integer.parseInt(saisie);
			 } catch (NumberFormatException e) {
			     System.out.println("Entrez un chiffre !" + "\n");
			     choix = 0;
			     continue;
			 }
		    
		    switch (choix){
		    
		    case 1:
		    	Affichage ListPizza = new Affichage();
		    	ListPizza.affichageP(pizzas);
		    	choix = 0;
		    	break;
		    case 2:
		    	System.out.println("***** Ajouter une pizza *****" + "\n");
		    	System.out.println("Veuillez saisir le code");
		    	String code = nombre.next();
		    	System.out.println("Veuillez saisir le nomde la pizza");
		    	String nom = nombre.next();
		    	System.out.println("Veuillez saisir le prix de la pizza");
		    	double prix = nombre.nextDouble();
		    	Pizza[] newTab = Arrays.copyOf(pizzas, pizzas.length+1);
		    	
		    	Pizza nouvellePizza = new Pizza();
		    	nouvellePizza.code = code;
		    	nouvellePizza.nom = nom;
		    	nouvellePizza.prix = prix;
		    	
		    	newTab[pizzas.length] = nouvellePizza;	
		    	pizzas = newTab;
		    	System.out.println("Pizza ajouter" + "\n");
		    	choix = 0;
		    	break;
		    case 3:
		    	System.out.println("***** Modifier une pizza *****" + "\n");
		    	System.out.println("***** Liste de pizza *****");
		    	for ( int i=0; i<pizzas.length; i++){
		    			System.out.println((i+1) +" " +pizzas[i].code + " " + pizzas[i].nom + " " + pizzas[i].prix);
		    	}
		    	System.out.println("\n");
		    	int modif = 0;
		    	while (modif == 0){
			    	System.out.println("Modifier quelle pizza (numero) ?");
			    	System.out.println("Abandonner tapez 99");
			    	modif = nombre.nextInt();
			    	if (modif == 99){
			    		continue;
			    	}else if ( (modif >=1) && (modif<=pizzas.length)){
			    		System.out.println("Modifier le code ?");
			    		code = nombre.next();
			    		System.out.println("Modifier le nom ?");
			    		nom = nombre.next();
			    		System.out.println("Modifier le prix ?");
			    		prix = nombre.nextDouble();
			    		
				    	pizzas[modif].code = code;
				    	pizzas[modif].nom = nom;
				    	pizzas[modif].prix = prix;
			    		System.out.println("pizza mise a jour" + "\n");
			    	}else{
			    		System.out.println("Erreur de saisie veuillez recommencer");
			    		modif = 0;
			    	}
		    	}
		    	choix = 0;
		    	break;
		    case 4:
		    	System.out.println("***** Supprimer une pizza *****" + "\n");
		    	System.out.println("***** Liste de pizza *****");
		 /*   	for ( int i=0; i<pizzas.length; i++){
		    			System.out.println((i+1) +" " +pizzas[i].code + " " + pizzas[i].nom + " " + pizzas[i].prix);
		    	}
		    	System.out.println("\n");
		    	int supp = 0;
		    	int Index = 0;
		    	while (supp == 0){
			    	System.out.println("Supprimer quelle pizza (numero) ?");
			    	System.out.println("Abandonner tapez 99");
			    	supp = nombre.nextInt();
			    
			    	if (supp == 99){
			    		continue;
			    	}else if ( (supp >=1) && (supp<=pizzas.length)){
			    		supp--;
			    		Pizza[] newTab1 = new Object[pizzas.length - 1][3];
			    		for ( int i=0; i<pizzas.length - 1; i++){
			    			if(i>=supp) { 
			    				Index = i + 1;
			    			}else { 
			    				Index = i; 
			    			}
			    			newTab1[i][0] = pizzas[Index]; 
			    			newTab1[i][1] = pizzas[Index]; 
			    			newTab1[i][2] = pizzas[Index]; 
			    		} 

			    		pizzas = newTab1;
			    		System.out.println("pizza supprimée" + "\n");
			    	}else{
			    		System.out.println("Erreur de saisie veuillez recommencer");
			    		modif = 0;
			    	}
		    	}*/
		    	choix = 0;
		    	break;
		    case 99:
		    	System.out.println("Aurevoir" + "\n");
		    	break;
		    default:
		    	System.out.println("Erreur de saisie retour au menu" + "\n");
		    	choix = 0;
		    	break;
		    }
		}

	    nombre.close();

	}

}
