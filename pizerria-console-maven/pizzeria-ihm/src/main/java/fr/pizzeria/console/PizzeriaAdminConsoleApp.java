package fr.pizzeria.console;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.ihm.IhmHelper;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientMap;
import fr.pizzeria.service.StockageLivreurMap;
import fr.pizzeria.service.StockagePizzaFichier;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws CreditException, DebitException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Scanner scanner = new Scanner(System.in);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("stockage.pizza");

		
		Class<?> classePizza = Class.forName(classeStockagePizza);
	
		//(Class<Stockage<Pizza>>)
		//Stockage<Pizza> stockagePizza = new StockagePizzaMap();
		Stockage<Pizza> stockagePizza = (Stockage<Pizza>) classePizza.newInstance();
		Stockage<Client> stockageClient = new StockageClientMap();
		Stockage<Livreur> stockageLivreur = new StockageLivreurMap();
	
		
		
		IhmHelper helper = new IhmHelper(stockageLivreur,stockageClient,stockagePizza, scanner);

		// Afficher le Menu

		Menu listMenu = new Menu(helper);

		listMenu.start();
		scanner.close();
	}
}
