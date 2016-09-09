package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@NamedQuery(name="pizza.findByCode", query="select p from Pizza p where p.code=:c")
//@Table(name ="Pizza2")
public class Pizza {

	Pizza(){}

	private static int NbPizza;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name="reference")
	private String code;
	@Column(name="libelle")
	private String nom;
	//@Column(name="libelle")
	private double prix;
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	@Column(name="url_image")
	private String url ="";

	@ManyToMany()
	private Set<Commande_Pizza> cmds;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Pizza(String code, String nom, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
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

		String str = StringUtils.rightPad(code,5) + "\t"+ 
				StringUtils.rightPad(Double.toString(prix),3) +"\t"+ 
				StringUtils.rightPad(nom,5) +"\t"+ 
				StringUtils.rightPad(categorie.getName(),3); 
		return str;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
