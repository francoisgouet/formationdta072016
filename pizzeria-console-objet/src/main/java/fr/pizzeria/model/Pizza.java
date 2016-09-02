package fr.pizzeria.model;

public class Pizza {

	private static int NbPizza;

	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;
	
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

	public Pizza(String code, String nom, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		//this.categorie = CategoriePizza.POISSON;
	}
	
	public Pizza(String code, String nom, double prix,CategoriePizza p) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = p;
	}

	public Pizza(String code2, Double prix2, String nom2, CategoriePizza valueOf) {
		code = code2;
		prix2 = prix;
		nom2 = nom;
		categorie = valueOf;
	}

	@Override
	public String toString() {
		String str = code + " " + " "+ Double.toString(prix) +" "+ nom +" "+ categorie.getName(); 
		return str;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
