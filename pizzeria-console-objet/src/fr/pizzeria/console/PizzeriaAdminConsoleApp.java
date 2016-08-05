package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageTableau;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Stockage stockage = new StockageTableau();
		// Afficher le Menu

		Menu listMenu = new Menu(stockage, scanner);
		try {
			// Instructions susceptibles de provoquer des erreurs;
			listMenu.start();
		} catch (NumberFormatException e) {
			System.out.println("Entrez un chiffre !" + "\n");
		}

		scanner.close();

	}

}
