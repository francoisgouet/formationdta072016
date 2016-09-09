package fr.pizzeria.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne
	@JoinColumn(name="client_id")
	Client client_id;
}
