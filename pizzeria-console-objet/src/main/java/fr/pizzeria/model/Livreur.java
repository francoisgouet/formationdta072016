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
	public Livreur() {
		super();
		
	}
	public Livreur(double montantDecouvertAutorise) {
		super();
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}
	
	public Livreur(long i, String string, String string2) {
		super(i,string,string2);
	}
	
	public Livreur(int i, String string, String string2, double j, double k) throws CreditException, DebitException {
		super(i,string,string2,j);
		this.montantDecouvertAutorise = k;
		System.out.println(toString());
		System.out.println(Math.abs(this.getSolde()));
		System.out.println(Math.abs(this.montantDecouvertAutorise));
		if ((this.getSolde()) < -this.montantDecouvertAutorise){
			throw new DebitException();
		}
	}

	@Override
	public void debiterCompte(double montant) throws DebitException{
		this.setSolde(this.getSolde() - montant);
		
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
