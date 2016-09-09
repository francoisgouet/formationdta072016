package fr.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import fr.action.Helper;
import fr.action.MenuClient;
import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientJPA;
import fr.pizzeria.service.StockageClientMap;
import fr.pizzeria.service.StockageLivreurMap;

public class consoleClient {
	public static void main(String[] args) throws ClassNotFoundException, CreditException, DebitException, InstantiationException, IllegalAccessException, IOException {
		Scanner scanner = new Scanner(System.in);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String typeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(typeStockagePizza);
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		
		Class<?> classePizza = Class.forName(typeStockagePizza);
		Stockage<Pizza> stockagePizza = (Stockage<Pizza>) classePizza.newInstance();
		Stockage<Client> stockageClient = new StockageClientJPA();
		Stockage<Livreur> stockageLivreur = new StockageLivreurMap();
		
		
		Helper helper = new Helper(stockageLivreur,stockageClient,stockagePizza, scanner);

		// Afficher le Menu

		MenuClient listMenu = new MenuClient(helper);
		
		listMenu.start();
		scanner.close();
	}
}
