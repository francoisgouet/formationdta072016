package fr.pizzeria.ihm;

public abstract class Action {

	private String libelle;

	public Action(String string) {
		this.libelle = string;
	}

	public abstract void execute();

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
