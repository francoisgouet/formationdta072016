package fr.action;

import java.io.IOException;

public class Action {
	private String libelle;
	protected Helper helper;

	public Action(String libelle, Helper helper) {
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
