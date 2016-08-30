package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.SaisieEntierException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageLivreurMap;

public class IhmHelper {

	private Stockage<Pizza> stockagePizza;
	private Stockage<Client> stockageClient;
	private Stockage<Livreur> stockageLivreur;
	public Stockage<Livreur> getStockageLivreur() {
		return stockageLivreur;
	}

	public void setStockageLivreur(Stockage<Livreur> stockageLivreur) {
		this.stockageLivreur = stockageLivreur;
	}

	private Scanner scanner;

	public IhmHelper(Stockage<Livreur> stockageLivreur,Stockage<Client> stockageClient, Stockage<Pizza> stockagePizza, Scanner scanner) {
		super();
		this.stockagePizza = stockagePizza;
		this.stockageClient = stockageClient;
		this.stockageLivreur = stockageLivreur;
		this.scanner = scanner;
	}

	public int saisirEntier() throws SaisieEntierException {
		try {
			String saisie = scanner.next();
			return Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieEntierException(e);
		}
	}

	public Stockage<Pizza> getStockagePizza() {
		return stockagePizza;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public Stockage<Client> getStockageClient() {
		return stockageClient;
	}

	public void setStockageClient(Stockage<Client> stockageClient) {
		this.stockageClient = stockageClient;
	}

}
