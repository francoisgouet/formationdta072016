package fr.pizzeria.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaFichier implements Stockage<Pizza>{
	
	public Map<String, Pizza> pizzas = new TreeMap<>();
	String line;
	Pizza a;
	@Override
	public Collection<Pizza> findAll() {
		try {
			Files.walk(Paths.get("Data")).forEach(filePath -> {
			    if (Files.isRegularFile(filePath)) {
			    	
			    	try {
						BufferedReader f = Files.newBufferedReader(filePath);
						String p = f.readLine();
						 List<String> r = Arrays.asList(p.split(";"));
						try {
							String code = r.get(0);
							Float prix = Float.valueOf(r.get(2));
							String nom = r.get(1);
							
							Pizza a = new Pizza(code,nom,prix,CategoriePizza.valueOf(r.get(3)));
							//izza code = 
							pizzas.put(r.get(0),a);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						
						//pizzas.put(r[0],a);
						//System.out.println(p);
				
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			    }
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pizzas.values();
	}

	@Override
	public Pizza find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pizza newItem) throws IOException {
		String str = newItem.getCode()+".txt";
		Path cheminFichier = Paths.get("Data",str);
		String d = String.format("%s;%s;%s;%s",newItem.getCode(),newItem.getNom(),newItem.getPrix(),newItem.getCategorie().toString());
		Files.write(cheminFichier,Arrays.asList(d));
	}



	@Override
	public void delete(String ancienCode) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Pizza editItem, String ancienCode) {
		this.pizzas.remove(ancienCode);
		try {
			String str = ancienCode+".txt";
			Path cheminFichier = Paths.get("Data",str);
			/*
			String str2 = editItem.getCode()+".txt";
			
			Path cheminFichier1 = Paths.get("Data",str2);
			File f = new File(Paths.get("Data",str).toString());
			f.delete();*/
			Files.delete(cheminFichier);
			save(editItem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
