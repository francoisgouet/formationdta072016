package fr.pizzeria.admin.web;

import java.io.IOException;
import java.net.PasswordAuthentication;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {
	private FilterConfig config = null;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		/* Récupération de la session depuis la requête */

		/**
		 * Si l'objet -utilisateur- connecte n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté.
		 */
		// si la session n'existe pas 
		if (request.getSession().getAttribute("connecte") != null || request.getRequestURL().toString().contains("/login")) {
			if (request.getSession().getAttribute("connecte").equals(true)){
				String url = request.getParameter("url");
				if (url != null)
				response.sendRedirect( request.getContextPath()+"/"+url );
				//chain.doFilter( request, response );
			}
			else{
				// si l'url contains login demandez de se reconnecter
				chain.doFilter( request, response );
			}
		}
		else {
			// la session existe mais pas de connexion
			response.sendRedirect( request.getContextPath()+"/login" );
		}
	}

	@Override
	public void destroy() { }
}
















