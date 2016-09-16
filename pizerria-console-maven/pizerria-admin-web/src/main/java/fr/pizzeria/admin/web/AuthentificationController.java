package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthentificationController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/login/Log.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail = req.getParameter("mail");
		String pass = req.getParameter("psd");
		// si c'est pas bon
		boolean a = "admin@pizzeria.fr".equals(mail) && "admin".equals(pass);
		System.out.println(mail);
		System.out.println(pass);
		System.out.println(a);
		req.getSession().setAttribute("connecte",a);
	}
}
