package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.ihm.IhmHelper;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientMap;
import fr.pizzeria.service.StockageLivreurMap;
import fr.pizzeria.service.StockagePizzaMap;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws CreditException {

		Scanner scanner = new Scanner(System.in);

		Stockage<Pizza> stockagePizza = new StockagePizzaMap();
		Stockage<Client> stockageClient = new StockageClientMap();
		Stockage<Livreur> stockageLivreur = new StockageLivreurMap();
		

		IhmHelper helper = new IhmHelper(stockageLivreur,stockageClient,stockagePizza, scanner);

		// Afficher le Menu

		Menu listMenu = new Menu(helper);

		listMenu.start();
		scanner.close();
	}
}
