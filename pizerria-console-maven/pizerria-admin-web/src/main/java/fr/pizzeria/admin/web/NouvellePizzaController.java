package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class NouvellePizzaController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Stockage<Pizza> stbdd = PersistanceUtils.getInstance().getStockagePizza();
		Collection<Pizza> pizzs =  stbdd.findAll();
		String p = req.getParameter("code");
		System.out.println(p);
		Pizza pizz = stbdd.find(p);
		String nom = req.getParameter("nom");
		CategoriePizza categorie = CategoriePizza.valueOf(req.getParameter("categorie"));
		Double prix = Double.valueOf(req.getParameter("prix"));
		Pizza pi = new Pizza(p,nom,prix,categorie);
		stbdd.update(pi,p);*/
		req.getRequestDispatcher("/WEB-INF/view/pizzas/NewPizza.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Stockage<Pizza> stbdd = PersistanceUtils.getInstance().getStockagePizza();
		Collection<Pizza> pizzs =  stbdd.findAll();
		String p = req.getParameter("code");
		String nom = req.getParameter("nom");
		CategoriePizza categorie = CategoriePizza.valueOf(req.getParameter("categorie"));
		Double prix = Double.valueOf(req.getParameter("prix"));
		Pizza pi = new Pizza(p,nom,prix,categorie);
		stbdd.save(pi);
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
