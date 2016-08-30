package fr.pizzeria;


import java.util.Scanner;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageTableau;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stockage stockage = new StockageTableau(); //
		Menu menu = new Menu(stockage, sc);
		menu.start();
		sc.close();
	}
}  