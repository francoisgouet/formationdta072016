package fr.pizzeria.exception;

import fr.pizzeria.model.Client;

public class CreditException extends Exception {

	private static final String MSG = "Seuil depass�";

	public CreditException() {
		super(MSG);
	}

	public CreditException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreditException(String message) {
		super(message);
	}

	public CreditException(Throwable cause) {
		super(MSG, cause);
	}

	public CreditException(double ancienSolde, double nouveauSolde, Client client) {
		if (client.getSolde() < ancienSolde){
			System.out.println("CreditException.CreditException()");
		}
		client.setSolde(ancienSolde);
	}
}
