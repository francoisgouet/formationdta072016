package fr.pizzeria.console;
import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		int choix = 0;
		Scanner nombre = new Scanner(System.in);

		Object[][] pizzas = {{"PEP", "Pépéroni", 12.50},{"MAR","Margarita",14.00},{"REI","La Reine",11.50},
				{"FRO","la 4 fromage",12.00},{"CAN","la canibale",12.50},{"SAV","la savoyarde",13.00},
				{"ORI","l'oriantale",13.50},{"IND","L'indienne",14.00}};
	
		
		while (choix == 0){
			System.out.println("***** Pizzeria Administration *****");	
			System.out.println("1.	Lister les pizzas ");
			System.out.println("2.	Ajouter une nouvelle pizza");
			System.out.println("3.	Mettre à jour une pizza");
			System.out.println("4.	Supprimer une pizza");
			System.out.println("99.	Sortir" + "\n");
			
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
		    	System.out.println("***** Liste de pizza *****");
		    	for ( int i=0; i<pizzas.length; i++){
		    			System.out.println((i+1) +" " +pizzas[i][0] + " " + pizzas[i][1] + " " + pizzas[i][2]);
		    	}
    			System.out.println("\n");
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
		    	Object[][] newTab = Arrays.copyOf(pizzas, pizzas.length+1);
		    	newTab[pizzas.length] = new Object[]{code, nom, prix};	
		    	pizzas = newTab;
		    	System.out.println("Pizza ajouter" + "\n");
		    	choix = 0;
		    	break;
		    case 3:
		    	System.out.println("***** Modifier une pizza *****" + "\n");
		    	System.out.println("***** Liste de pizza *****");
		    	for ( int i=0; i<pizzas.length; i++){
		    			System.out.println((i+1) +" " +pizzas[i][0] + " " + pizzas[i][1] + " " + pizzas[i][2]);
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
			    		pizzas[modif-1] = new Object[]{code, nom, prix};
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
		    	for ( int i=0; i<pizzas.length; i++){
		    			System.out.println((i+1) +" " +pizzas[i][0] + " " + pizzas[i][1] + " " + pizzas[i][2]);
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
			    		Object[][] newTab1 = new Object[pizzas.length - 1][3];
			    		for ( int i=0; i<pizzas.length - 1; i++){
			    			if(i>=supp) { 
			    				Index = i + 1;
			    			}else { 
			    				Index = i; 
			    			}
			    			newTab1[i][0] = pizzas[Index][0]; 
			    			newTab1[i][1] = pizzas[Index][1]; 
			    			newTab1[i][2] = pizzas[Index][2]; 
			    		} 

			    		pizzas = newTab1;
			    		System.out.println("pizza supprimée" + "\n");
			    	}else{
			    		System.out.println("Erreur de saisie veuillez recommencer");
			    		modif = 0;
			    	}
		    	}
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
