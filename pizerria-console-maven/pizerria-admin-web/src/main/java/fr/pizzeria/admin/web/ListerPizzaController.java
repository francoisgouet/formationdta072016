package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class ListerPizzaController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Stockage<Pizza> stbdd = PersistanceUtils.getInstance().getStockagePizza()	;
		Collection<Pizza> pizzs =  stbdd.findAll();
		req.setAttribute("lp",pizzs);
		req.getRequestDispatcher("/WEB-INF/view/pizzas/listerPizzas.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
