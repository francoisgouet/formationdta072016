package fr.pizzeria.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaDB implements Stockage<Pizza> {

	private ResourceBundle bundle;

	public StockagePizzaDB() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		bundle = ResourceBundle.getBundle("jdbc");
		String db = bundle.getString("db");
		String user = bundle.getString("user");
		String mdp = bundle.getString("mdp");
		try (Connection conn = DriverManager.getConnection(db, user, mdp);
				Statement statement = conn.createStatement();
				ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");) {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			// Properties p = load();

			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root","root");

			while (resultats.next()) {
				String id = resultats.getString("id");
				String code = resultats.getString("reference");
				String cat = resultats.getString("categorie");
				String nom = resultats.getString("libelle");
				double prix = resultats.getDouble("prix");
				Pizza pizza = new Pizza(code, nom, prix, CategoriePizza.valueOf(cat));
				// pizzas.put(id,pizza);
				System.out.println("[id=" + id + " name=" + nom + " price=" + prix + "]");
			}
		}
	}

	@Override
	public Collection<Pizza> findAll() {

		return null;
	}

	@Override
	public void save(Pizza newItem) throws IOException {
		// PreparedStatement updatePizzaSt;
		bundle = ResourceBundle.getBundle("jdbc");
		String db = bundle.getString("db");
		String user = bundle.getString("user");
		String mdp = bundle.getString("mdp");
		try (Connection conn = DriverManager.getConnection(db, user, mdp);
				PreparedStatement updatePizzaSt = conn.prepareStatement(
						"INSERT INTO PIZZA (libelle,reference,prix,url_image,categorie) VALUES (?,?,?,'',?)")) {
			updatePizzaSt.setString(1, newItem.getNom());
			updatePizzaSt.setString(2, newItem.getCode());
			updatePizzaSt.setDouble(3, newItem.getPrix());
			// updatePizzaSt.setString(4, newItem.getUrl());
			updatePizzaSt.setString(4, newItem.getCategorie().toString());
			updatePizzaSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save(Collection<Pizza> lp) throws IOException {
		bundle = ResourceBundle.getBundle("jdbc");
		String db = bundle.getString("db");
		String user = bundle.getString("user");
		String mdp = bundle.getString("mdp");
		lp.forEach(System.out::println);
		Pizza[] b = new Pizza[3];
		// lp.toArray(b);
		int a = 0;
		try (Connection conn = DriverManager.getConnection(db, user, mdp);) {
			conn.setAutoCommit(false);

			try (PreparedStatement updatePizzaSt = conn.prepareStatement(
					"INSERT INTO PIZZA (libelle,reference,prix,url_image,categorie) VALUES (?,?,?,'',?)")) {
				for (Pizza pizza : lp) {

					updatePizzaSt.setString(1, pizza.getNom());
					updatePizzaSt.setString(2, pizza.getCode());
					updatePizzaSt.setDouble(3, pizza.getPrix());
					updatePizzaSt.setString(4, pizza.getCategorie().toString());
					a = updatePizzaSt.executeUpdate();

				}
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}

			conn.commit();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Pizza editItem, String code) {
	}

	@Override
	public void delete(String ancienCode) {
	}

	@Override
	public Pizza find(String id) {
		return null;
	}
}
