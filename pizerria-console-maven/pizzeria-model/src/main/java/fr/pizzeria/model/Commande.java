package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	Integer numero_commande;
	Statut statut;
	Date date_commande;
	
	@ManyToOne
	@JoinColumn(name="livreur_id")
	Livreur livreur_id;
	
	@ManyToMany 
	@JoinTable(name="commande_Pizza",
            joinColumns=@JoinColumn(name="commande_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="pizza_id", referencedColumnName="id"))
	Set<Pizza> lp;
	
	public Commande(){}
	
	public Commande( Client client_id, Livreur livreur_id) {
		super();
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}

	@ManyToOne
	@JoinColumn(name="client_id")
	Client client_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero_commande() {
		return numero_commande;
	}

	public void setNumero_commande(Integer numero_commande) {
		this.numero_commande = numero_commande;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public Livreur getLivreur_id() {
		return livreur_id;
	}

	public void setLivreur_id(Livreur livreur_id) {
		this.livreur_id = livreur_id;
	}

	public Client getClient_id() {
		return client_id;
	}

	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
}
