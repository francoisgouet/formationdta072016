package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import fr.pizzeria.model.Pizza;

public class PizzaLaPlusEleve extends Action{

	public PizzaLaPlusEleve(IhmHelper helper) {
		super("Pizza la plus chere", helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws IOException {
		Collection<Pizza> lp = helper.getStockagePizza().findAll();
		Optional<Pizza> optMax = lp.stream().max(Comparator.comparing(Pizza::getPrix));
		if(optMax.isPresent()) {
			lp.stream().collect(Collectors.groupingBy(Pizza::getPrix)).get(optMax.get().getPrix()).forEach(System.out::println);
		} else {
			System.out.println("Pas de max...");
		}
		
	}
}
