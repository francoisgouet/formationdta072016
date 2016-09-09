package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractPersonne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	protected String nom;
	protected String prenom;
	protected double solde;
	

	public AbstractPersonne() {
	}

	public AbstractPersonne(long id, String nom, String prenom, double solde) throws CreditException,DebitException {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
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
		solde += montant;
		double nouveauSolde = this.getSolde() + montant;
		if (nouveauSolde > 5000){
			throw new CreditException();
		}
		setSolde(nouveauSolde);
	}

	public void debiterCompte(double montant) throws DebitException{
		solde -= montant;
	}
	public String toString(){
		String str = this.id +"->"+ this.prenom +" "+ this.nom +"("+this.getSolde()+"�)";
		return str;
	}
}
