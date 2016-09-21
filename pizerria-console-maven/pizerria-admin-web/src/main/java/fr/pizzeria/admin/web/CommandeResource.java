package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import fr.pizzeria.ejb.CommandeServiceEJB;
import fr.pizzeria.model.Commande;

@Path("/commande")
public class CommandeResource {

		
		@EJB CommandeServiceEJB stockageCommande;
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<Commande> list(){
			return  stockageCommande.findAll();
		}
		
		/*@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void creer(Commande cmd){
			try {
				stockageComande.save(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@PUT
		@Path("/{code}")
		@Consumes(MediaType.APPLICATION_JSON)
		public void modifier(Pizza n,@PathParam("code") String code){
			stockageComande.update(n,code);
		}
		
		@DELETE
		@Path("/{code}")
		//@Consumes(MediaType.APPLICATION_JSON)
		public void sup(@PathParam("code") String code){
			stockageComande.delete(code);
		}*/
}
