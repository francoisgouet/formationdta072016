package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

@WebListener
public class ListennerAppOpen implements ServletContextListener{

	@EJB private PizzaServiceEJB stockagePizza;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//List p = new ArrayList<Pizza>(new Pizza(),new Pizza());
		Pizza[] lp = {
				new Pizza("VIANDE","REI","Reine",10,"pizza_Reine.jpg"),
		new Pizza("VIANDE","REG ","Regina ",10,"pizza_Regina.jpg"),
		new Pizza("VIANDE","CAL","Calzone",4,"pizza_Calzone.jpg"),
		new Pizza("SANS_VIANDE","NAP","Napolitaine",10,"pizza_Napolitaine.jpg"),
		new Pizza("SANS_VIANDE","4FR","4 fromages",10,"pizza_4fromages.jpg"),
		new Pizza("VIANDE","CHO","Chorizo",10,"pizza_Chorizo.jpg"),
		new Pizza("SANS_VIANDE","4SA","4 saisons",9,"pizza_4saisons.jpg"), 
		new Pizza("VIANDE","BOL","Bolognese",12,"pizza_Bolognese.jpg"),
		new Pizza("POISSON","ALA","Alademande",13,"pizza_Alademande.jpg")};
		
		for (Pizza pizza : lp){
			try {
				stockagePizza.save(pizza);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
