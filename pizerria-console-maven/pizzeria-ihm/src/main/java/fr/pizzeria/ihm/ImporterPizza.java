package fr.pizzeria.ihm;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import org.apache.commons.collections4.ListUtils;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.StockagePizzaDB;

@Ac
public class ImporterPizza extends Action{
	List<Pizza> pizzas = new ArrayList<Pizza>();
	public ImporterPizza(IhmHelper helper) {
		super("Exporter", helper);	
	}

	public List<Pizza> extracted() {
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
								pizzas.add(a);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}  
				    }
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		return pizzas;
	}
	
	@Override
	public void execute() throws IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String typeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(typeStockagePizza);
		if (typeStockagePizza.equals("fr.pizzeria.service.StockagePizzaMap") || (typeStockagePizza.equals("fr.pizzeria.service.StockagePizzaFichier"))){
			Error f = new Error("Veuillez configurer l’application avec une implémentation base de données");
			System.err.println(f.getMessage());
		}
		else{
		// liste de pizzas
		pizzas = extracted();
		// mise en base de données par 3
		List<List<Pizza>> pizzpartrois = ListUtils.partition(pizzas,3);
		System.out.println("Bla");
		/*StockageTransitoir bdd = new StockageTransitoir();*/
		StockagePizzaDB lp = (StockagePizzaDB) helper.getStockagePizza();
		pizzpartrois.forEach(
				lpizza -> {
					try {
						lp.save((List<Pizza>) lpizza);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		// commitation*/
		
		}
	}

	public Collection<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
}
