package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	static boolean menu = true;
	
	public static Scanner in = new Scanner(System.in);
	
	public static Pizza[] tab = {
			new Pizza(0,"PEP","Pépéroni",12.50),
			new Pizza(1,"MAR","Margherita",14.00),
			new Pizza(2,"REI","La reine",11.50),
			new Pizza(3,"FRO","La 4 Fromtons",12.00),
			new Pizza(4,"CAN","La cannibale",12.50),
			new Pizza(5,"SAV","La savoyarde",13.00),
			new Pizza(6,"ORI","L'orientale",13.50),
			new Pizza(7,"IND","L'indienne",14.00)};
		
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
				System.out.println("Mise � jour d'une pizza");
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
	
	private static Pizza[] supp_pizzas() {
		lister_pizzas();
		System.out.println("Veuillez choisir la pizza a supprimer (99 pour abondonner)");
		int index = in.nextInt()-1;		Pizza [] tab_tmp = new Pizza[tab.length-1];
		int ind;
		if (index < tab.length){
			for (int i = 0; i < tab_tmp.length; i++) {
				if (i>=index){
					ind = i+1;
				}
				else{
					ind = i;
				}
				tab_tmp[i] = tab[ind];
			}
		}
		return tab_tmp;
	}
	
	private static Pizza[] ajouter_pizzas() {
		System.out.println("Veuillez	saisir	le	code");
		String code = in.next();
		System.out.println("Veuillez	saisir	le	nom	(sans	espace)");
		String nom = in.next();
		System.out.println("Veuillez	saisir	le	prix");
		Double prix = in.nextDouble();
		Pizza[] tab2 = new Pizza[tab.length+1];
		for (int i = 0; i < tab.length; i++) {
				tab2[i] = tab[i];
		}
		tab2[tab2.length-1] = new Pizza(tab2.length-1,code,nom,prix);
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
		for (Pizza piz:tab) {
			//System.out.println(tab[s].getCode());
			System.out.println(piz.getCode()+ "->" + piz.getNom()+"("+ piz.getPrix()+"€)");
			}
		System.out.println(new String("--------------"+Pizza.NB_PIZZAS+" pizzas "+" depuis l'initialisation du programme"));
		menu = true;
	}
	
	public static Pizza[] maj_pizzas(){
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
			Double prix = in.nextDouble();
			// menu = false;
			tab[choix-1].setCode(code);
			tab[choix-1].setNom(nom);
			tab[choix-1].setPrix(prix);
			}
	return tab;
	}	
}    