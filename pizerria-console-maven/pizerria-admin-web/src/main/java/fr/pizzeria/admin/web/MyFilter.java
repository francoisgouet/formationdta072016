package fr.pizzeria.admin.web;

import java.io.IOException;
import java.net.PasswordAuthentication;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns={"/*"})
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
		/*HttpSession session = request.getSession();
		System.out.println(session.getAttribute("connecte"));

		if (session.getAttribute("connecte") != null || request.getRequestURL().toString().contains("/login")) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/login" );
		}*/
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() { }
}
















