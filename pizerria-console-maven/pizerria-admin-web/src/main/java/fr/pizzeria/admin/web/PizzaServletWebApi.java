package fr.pizzeria.admin.web;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;

import fr.pizzeria.service.StockagePizzaDB;
import fr.pizzeria.service.StockagePizzaJpa;

public class PizzaServletWebApi extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Bijour !!");
		StockagePizzaJpa stbdd = new StockagePizzaJpa();
		Collection<Pizza> pizzs =  stbdd.findAll();
		resp.getWriter().write(pizzs.toString());   
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("name");
		String code = req.getParameter("code");
		double prix = Double.valueOf(req.getParameter("prix"));	
		CategoriePizza categorie = CategoriePizza.valueOf(req.getParameter("cat").toString());
		StockagePizzaJpa stbdd = new StockagePizzaJpa();
		Pizza newItem = new Pizza(code,nom,prix,categorie);
		stbdd.save(newItem);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map <String,String> map = new HashMap<String, String>();
		//System.out.println(lp.toString());
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String data = br.readLine();
		String[] parts = data.split("&");
		//Map<String, String> map = Splitter.on( "::" ).withKeyValueSeparator( ':' ).split(data);
		for (String s:parts){
			//resp.getWriter().write(s);
			String[] t = s.split("=");
		    map.put(t[0], t[1]);
		}
		//resp.getWriter().write(map.get("name"));
		String nom = map.get("name");
		String code = map.get("code");
		double prix = Double.valueOf(map.get("prix"));	
		CategoriePizza categorie = CategoriePizza.valueOf(map.get("cat").toString());
		StockagePizzaJpa stbdd = new StockagePizzaJpa();
		Pizza editItem = new Pizza(code,nom,prix,categorie);
		stbdd.update(editItem, code);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream())); 
		String data = br.readLine();
		String [] parts = data.split("=");*/
		String ancienCode = req.getParameter("code");
		StockagePizzaJpa stbdd = new StockagePizzaJpa();
		stbdd.delete(ancienCode);
	}
}
