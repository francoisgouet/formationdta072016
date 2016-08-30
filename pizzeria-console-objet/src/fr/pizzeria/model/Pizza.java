package fr.pizzeria.model;

public class Pizza {
	private int id;
	private String code;
	private String nom;
	private double prix;
	public static int NB_PIZZAS = 0;
	
	public Pizza(int id, String code, String nom, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		NB_PIZZAS ++;
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public static int getNbPizzas() {
		return NB_PIZZAS;
	}
	public static void setNbPizzas(int nbPizzas) {
		Pizza.NB_PIZZAS = nbPizzas;
	}
}