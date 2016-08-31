package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.model.Client;

public class StockageClientMap implements Stockage<Client> {
	public Map<String, Client> clients = new TreeMap<>();
	
	public StockageClientMap() throws CreditException {
		this.clients.put("12",new Client(12,"Jules","Robert",-200));
		this.clients.put("15",new Client(15,"Hugues","Robert",700));
		this.clients.put("1",new Client(1,"Marcel","Robert",5000));
		this.clients.put("2",new Client(2,"Francois","Robert",400));
	}
	
	@Override
	public Collection<Client> findAll() {
		return clients.values();
	}

	@Override
	public void save(Client newItem) {
		this.clients.put(new Integer(this.clients.size()+1).toString(), newItem);
	}

	@Override
	public void update(Client editItem, String code) {
		this.clients.remove(code);
		this.clients.put(Long.toString(editItem.getId()),editItem);
	}

	@Override
	public void delete(String ancienCode) {
	}

	@Override
	public Client find(String id){
		Client client = this.clients.get(id);
		
		return client;
	}

	
}
