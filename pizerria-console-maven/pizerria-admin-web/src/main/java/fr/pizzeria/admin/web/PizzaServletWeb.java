package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.StockagePizzaJpa;

public class PizzaServletWeb extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String balo = "<th>";
		String balf = "</th>";
		StockagePizzaJpa stbdd = new StockagePizzaJpa();
		Collection<Pizza> pizzs =  stbdd.findAll();
		resp.getWriter().write("<!doctype html><html><head></head><body><table>");
		pizzs.forEach(p->{
			try {
				resp.getWriter().write("<tr>");
				String id = balo.concat(String.valueOf(p.getId().toString())).concat(balf);
				String nom = balo.concat(p.getNom().toString()).concat(balf);
				String prix = balo.concat(String.valueOf(p.getPrix())).concat(balf);
				String code = balo.concat(p.getNom().toString()).concat(balf);
				String cat = balo.concat(p.getCategorie().toString()).concat(balf);
				resp.getWriter().write(id);
				resp.getWriter().write(id);
				resp.getWriter().write(id);
				resp.getWriter().write(id);
				resp.getWriter().write(id);
				resp.getWriter().write("</tr>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			});
		resp.getWriter().write("</table></body></html>");
	}
}
