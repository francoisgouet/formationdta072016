package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet{

	@EJB PizzaServiceEJB stockagePizza;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Pizza> pizzs =   stockagePizza.findAll();
		req.setAttribute("lp",pizzs);
		req.getRequestDispatcher("/WEB-INF/view/pizzas/listerPizzas.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
