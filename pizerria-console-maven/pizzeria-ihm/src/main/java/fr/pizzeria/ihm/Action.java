package fr.pizzeria.ihm;

import java.io.IOException;

public class Action {
	
	
	private String libelle;
	protected IhmHelper helper;

	public Action(String libelle, IhmHelper helper) {
		super();
		this.libelle = libelle;
		this.helper = helper;
	}

	public void execute() throws IOException {

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
