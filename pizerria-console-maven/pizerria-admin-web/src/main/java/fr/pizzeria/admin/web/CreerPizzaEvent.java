package fr.pizzeria.admin.web;

import java.util.Calendar;
import fr.pizzeria.model.Pizza;

public class CreerPizzaEvent {

	Calendar cal;
	Pizza pizza;
	
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
