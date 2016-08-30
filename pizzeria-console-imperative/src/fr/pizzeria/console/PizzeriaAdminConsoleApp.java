package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	static boolean menu = true;
	
	public static Scanner in = new Scanner(System.in);
	
	public static String[][] tab = new String[][]{{"0","PEP","Pépéroni","12.50"},
		{"1","MAR","Margherita","14.00"},
		{"2","REI","La reine","11.50"},
		{"3","FRO","La 4 Fromtons","12.00"},
		{"4","CAN","La cannibale","12.50"},
		{"5","SAV","La savoyarde","13.00"},
		{"6","ORI","L'orientale","13.50"},
		{"7","IND","L'indienne","14.00"}};
		
	public static void main(String[] args){
		int choix;
		while (menu){
			affichage_menu();
			choix = in.nextInt();
			switch (choix) {
			case 1:	
				System.out.println("Liste des pizzas");
				lister_pizzas();
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				//String [][] a;
				tab = ajouter_pizzas();
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				tab = maj_pizzas();
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				tab = supp_pizzas();
				break;	
			case 99:
				System.out.println("Au revoir :( ");
				menu = false;
				break;
			default:
				break;
			}		
		}
	}
	
	private static String[][] supp_pizzas() {
		lister_pizzas();
		System.out.println("Veuillez choisir la pizza a supprimer (99 pour abondonner)");
		int index = in.nextInt()-1;
		String [][] tab_tmp = new String[tab.length-1][4];
		// il parcourt juska l'index
		if (index < tab.length){
			for (int i = 0; i < index; i++) {
				tab_tmp[i][0] = tab[i][0];
				tab_tmp[i][1] = tab[i][1];
				tab_tmp[i][2] = tab[i][2];
				tab_tmp[i][3] = tab[i][3];
			}
		for (int j = index; j < tab_tmp.length; j++) {
			tab_tmp[j][0] = tab[j+1][0];
			tab_tmp[j][1] = tab[j+1][1];
			tab_tmp[j][2] = tab[j+1][2];
			tab_tmp[j][3] = tab[j+1][3];
		}
		}
		return tab_tmp;
	}
	
	private static String [][] ajouter_pizzas() {
		System.out.println("Veuillez	saisir	le	code");
		String code = in.next();
		System.out.println("Veuillez	saisir	le	nom	(sans	espace)");
		String nom = in.next();
		System.out.println("Veuillez	saisir	le	prix");
		String prix = in.next();
		String [][] tab2 = new String[tab.length+1][4];
		for (int i = 0; i < tab.length; i++) {
				tab2[i][0] = tab[i][0];	
				tab2[i][1] = tab[i][1];	
				tab2[i][2] = tab[i][2];
				tab2[i][3] = tab[i][3];
		}
		tab2[tab2.length-1][0] = Integer.toString(tab.length+1);
		tab2[tab2.length-1][1] = code; 
		tab2[tab2.length-1][2] = nom; 
		tab2[tab2.length-1][3] = prix;
		menu = true;
		return tab2;
	}
	
	public static void affichage_menu(){
		System.out.println("*****	Pizzeria	Administration	*****");
		System.out.println("1.	Lister	les	pizzas");
		System.out.println("2.	Ajouter une	nouvelle	pizza");	
		System.out.println("3.	Mettre	à	jour	une	pizza");
		System.out.println("4.	Supprimer	une	pizza");
		System.out.println("99.	Sortir");
		}
	
	public static void lister_pizzas(){
		for (int s = 0;s < tab.length;s++) {
			System.out.println(tab[s][1]+"->"+tab[s][2]+"("+tab[s][3]+"€)");
			}
		menu = true;
	}
	
	public static String[][] maj_pizzas(){
		lister_pizzas();
		System.out.println("Veuillez choisir la pizza a modifier (99 pour abondonner)");
		int choix = in.nextInt();
		if (choix < tab.length){
		if (choix == 99){
			System.out.println("Au revoir :( ");
		}
			System.out.println("Veuillez	saisir	le	code");
			String code = in.next();
			System.out.println("Veuillez	saisir	le	nom	(sans	espace)");
			String nom = in.next();
			System.out.println("Veuillez	saisir	le	prix");
			String prix = in.next();
			// menu = false;
			tab[choix][1] = code;
			tab[choix][2]= nom;
			tab[choix][3] = prix;
			}
	return tab;
	}	
}    