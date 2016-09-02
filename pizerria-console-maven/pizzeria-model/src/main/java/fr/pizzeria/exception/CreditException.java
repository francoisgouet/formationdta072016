package fr.pizzeria.exception;

import fr.pizzeria.model.Client;

public class CreditException extends Exception {

	private static final String MSG = "Seuil depassé";

	public CreditException() {
		super(MSG);
		// TODO Auto-generated constructor stub
	}

	public CreditException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CreditException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CreditException(Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}

	public CreditException(double ancienSolde, double nouveauSolde, Client client) {
		if (client.getSolde() < ancienSolde){
			System.out.println("CreditException.CreditException()");
		}
		client.setSolde(ancienSolde);
	}
}
