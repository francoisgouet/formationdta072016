package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.IhmHelper;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageTableau;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Stockage stockage = new StockageTableau();

		IhmHelper helper = new IhmHelper(stockage, scanner);

		// Afficher le Menu

		Menu listMenu = new Menu(helper);

		listMenu.start();

		scanner.close();

	}

}
