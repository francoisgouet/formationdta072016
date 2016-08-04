package fr.pizzeria.ihm;

public class AjouterPizzaAction extends Action {
	
	public AjouterPizzaAction(){
		super("Ajouter une pizza");
	}

	@Override
	public void execute() {
		System.out.println("Ajout d'une pizza");
		
	}

}
