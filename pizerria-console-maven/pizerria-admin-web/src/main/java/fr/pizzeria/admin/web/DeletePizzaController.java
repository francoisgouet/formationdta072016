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

public class DeletePizzaController extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Stockage<Pizza> stbdd = PersistanceUtils.getInstance().getStockagePizza();
		String p = req.getParameter("codePizza");
		System.out.println("a");
		stbdd.delete(p);
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
