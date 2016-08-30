package fr.pizzeria.model;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private double solde;
	
	void crediterCompte(double montant){
		double nouveauSolde = solde + montant;
		if (solde > 5000){
			throw e;
		}
	}
	
	void debiterCompte(double montant){
		
	}
	
	public String toString(){
		return nom;
		}
}
