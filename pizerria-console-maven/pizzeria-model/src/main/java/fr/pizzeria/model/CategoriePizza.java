package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	private String name;
	
	
	private CategoriePizza(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
