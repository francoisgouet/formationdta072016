package fr.pizzeria.model;

public class Pizza {

	protected int id;
	private String code;
	private String nom;
	private double prix;

	public static int NB_PIZZAS = 0;

	public Pizza() {
		this("NOM PAR DEFAUT", 0);
		NB_PIZZAS++;
		//id = StockageTableau.findAllPizzas().size();
	}

	public Pizza(String unNom, double unPrix) {
		this.nom = unNom;
		this.prix = unPrix;
		NB_PIZZAS++;
	}

	public Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		NB_PIZZAS++;
	}

	public double doublerPrixInstance() {
		return prix * 2;
	}

	public static double doublerPrixStatic(double unPrix) {
		return unPrix * 2;
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
}
