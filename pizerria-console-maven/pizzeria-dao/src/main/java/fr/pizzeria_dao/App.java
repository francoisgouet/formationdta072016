package fr.pizzeria_dao;

import java.io.IOException;
import java.util.Collection;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class App implements Stockage  
{
	@Override
	public Collection findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object newItem) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object editItem, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ancienCode) {
		// TODO Auto-generated method stub
		
	}
}
