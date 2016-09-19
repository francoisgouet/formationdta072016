package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("technique/")
public class Technique extends HttpServlet{

	private ListenerEvent listenerEvent = new ListenerEvent();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<CreerPizzaEvent> p = listenerEvent.getP();
		req.setAttribute("listeEvent",p);
		req.getRequestDispatcher("WEB-INF/view/technique/tech.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
