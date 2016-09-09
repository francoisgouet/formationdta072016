package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

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

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws CreditException, DebitException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Scanner scanner = new Scanner(System.in);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String typeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(typeStockagePizza);
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		
		
		Class<?> classePizza = Class.forName(typeStockagePizza);
	
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
