package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Livreur;

public class StockageLivreurMap implements Stockage<Livreur>{
	public Map<String, Livreur> livreurs = new TreeMap<String, Livreur>();
	
	public StockageLivreurMap() throws CreditException,DebitException {
		this.livreurs.put("12",new Livreur(12,"Hugues","Jean"));
		this.livreurs.put("15",new Livreur(15,"Dadou","Dadi",-200,100));
	}

	@Override
	public Collection<Livreur> findAll() {
		return livreurs.values();
	}
	
	@Override
	public void save(Livreur newItem) {
		this.livreurs.put(new Integer(this.livreurs.size()+1).toString(), newItem);
	}
	
	@Override
	public void update(Livreur editItem, String code) {
		this.livreurs.remove(code);
	}
	
	@Override
	public void delete(String ancienCode) {
	}
	
	@Override
	public Livreur find(String id){
		Livreur livreur = this.livreurs.get(id);
		
		return livreur;
	}
}
