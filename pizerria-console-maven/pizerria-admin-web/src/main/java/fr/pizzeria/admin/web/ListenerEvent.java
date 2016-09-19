package fr.pizzeria.admin.web;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.event.Observes;
import javax.xml.bind.Marshaller.Listener;

import fr.pizzeria.model.Pizza;

public class ListenerEvent {
	
	private List<CreerPizzaEvent> p = new ArrayList<>();
	
	public void onPizzaCree(@Observes CreerPizzaEvent event) {
		System.out.println("Pizza Creer");
		p.add(event);
	}

	public List<CreerPizzaEvent> getP() {
		return p;
	}	
}
