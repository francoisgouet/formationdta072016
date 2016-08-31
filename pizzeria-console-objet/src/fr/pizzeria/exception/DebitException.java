package fr.pizzeria.exception;

import fr.pizzeria.model.AbstractPersonne;

public class DebitException extends Exception {

	private static final String MSG = "Solde negatif";

	public DebitException() {
		super(MSG);
		// TODO Auto-generated constructor stub
	}
	
	public DebitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DebitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DebitException(Throwable cause) {
		super(MSG, cause);
		// TODO Auto-generated constructor stub
	}

	public DebitException(double ancienSolde, double nouveauSolde, AbstractPersonne personne) {
		if (personne.getSolde() < ancienSolde){
			System.out.println("DedbitEx");
		}
		personne.setSolde(ancienSolde);
	}

}