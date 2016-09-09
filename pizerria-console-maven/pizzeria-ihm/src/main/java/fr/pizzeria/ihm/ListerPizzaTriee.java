package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Stream;

import fr.pizzeria.model.Pizza;

@Ac
public class ListerPizzaTriee<T> extends Action{

	public ListerPizzaTriee( IhmHelper helper) {
		super(("Lister Pizzas sort by cat "), helper);
		
	}
	
	@Override
	public void execute() throws IOException {
		super.execute();
		System.out.println("**** Liste de Pizzas ****");
		Comparator<Pizza> comp = (p1,p2)-> p1.getCategorie().toString().compareTo(p2.getCategorie().toString()) ;
		Stream<Pizza> pizzas = this.helper.getStockagePizza().findAll().stream().sorted(comp);
		pizzas.forEach(System.out::println);
	}
}

