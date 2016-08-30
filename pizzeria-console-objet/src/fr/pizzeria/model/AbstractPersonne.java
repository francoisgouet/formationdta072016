package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public abstract class AbstractPersonne {
	private long id;
	private String nom;
	private String prenom;
	private double solde;
	
	public AbstractPersonne() {
	}

	public AbstractPersonne(long id, String nom, String prenom, double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde=solde;
	}
	
	public AbstractPersonne(long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	protected AbstractPersonne(String nom2, String prenom2, double solde2) {
		this.nom = nom2;
		this.prenom = prenom2;
		this.solde=solde2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void crediterCompte(double montant) throws CreditException{
		this.solde += montant;
	}

	public void debiterCompte(double montant) throws DebitException{
		this.setSolde(this.getSolde() - montant);
		if (this.getSolde() < 0){
			throw new DebitException();
		}
	}
	public String toString(){
		String str = this.id +"->"+ this.prenom +" "+ this.nom +"("+this.getSolde()+"€)";
		return str;
	}
}
