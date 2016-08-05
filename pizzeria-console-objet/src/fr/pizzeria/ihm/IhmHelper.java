package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.SaisieEntierException;
import fr.pizzeria.service.Stockage;

public class IhmHelper {

	private Stockage stockage;
	private Scanner scanner;

	public IhmHelper(Stockage stockage, Scanner scanner) {
		super();
		this.stockage = stockage;
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

	public Stockage getStockage() {
		return stockage;
	}

	public Scanner getScanner() {
		return scanner;
	}

}
