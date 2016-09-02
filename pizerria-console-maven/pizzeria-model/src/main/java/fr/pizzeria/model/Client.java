package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public  class Client extends AbstractPersonne implements CompteStat {
	
	public Client(){}
	
	public Client(long id, String nom, String prenom, double solde) throws CreditException, DebitException {
		super(id,nom,prenom,solde);
		if (solde > 5000)
			throw new CreditException();
		if (solde < 0){
			throw new DebitException();
		}
	}
	
	public Client(String nom2, String prenom2, double solde2) {
		super(nom2,prenom2, solde2);
	}
	
	@Override
	public void crediterCompte(double montant) throws CreditException{
		double ancienSolde = this.getSolde();
		double nouveauSolde = this.getSolde() + montant;
		if (nouveauSolde > 5000){
			throw new CreditException(ancienSolde,nouveauSolde,this);
		}
		else
			setSolde(nouveauSolde);
	}
	
	@Override
	public void debiterCompte(double montant) throws DebitException{
		
	}
	
	public void creer(){
		
	}

	public int compareTo(AbstractPersonne o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
