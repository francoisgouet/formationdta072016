package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public class Livreur extends AbstractPersonne implements CompteStat{
	private double montantDecouvertAutorise;

	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}
	public Livreur(){
		super();
	}
	public Livreur(double montantDecouvertAutorise) {
		super();
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}
	

	public Livreur(long i, String string, String string2) {
		super(i,string,string2);
	}
	
	public Livreur(int i, String string, String string2, int j, int k) throws CreditException {
		super(i,string,string2,j);
		this.montantDecouvertAutorise = k;
	}

	@Override
	public void debiterCompte(double montant) throws DebitException{
		this.setSolde(this.getSolde() - montant);
		if (this.getSolde() < this.montantDecouvertAutorise){
			throw new DebitException();
		}
	}
	
	@Override
	public String toString(){
		String str = super.toString();
		str += " Montant decouvert autorise "+this.montantDecouvertAutorise;
		return str;
	}

	@Override
	public int compareTo(AbstractPersonne o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
