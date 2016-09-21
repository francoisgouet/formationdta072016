package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaRessource {
	
	@EJB PizzaServiceEJB stockagePizza;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Pizza> list(){
		return  stockagePizza.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void creer(Pizza n){
		try {
			stockagePizza.save(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifier(Pizza n,@PathParam("code") String code){
		stockagePizza.update(n,code);
	}
	
	@DELETE
	@Path("/{code}")
	//@Consumes(MediaType.APPLICATION_JSON)
	public void sup(@PathParam("code") String code){
		stockagePizza.delete(code);
	}
}
