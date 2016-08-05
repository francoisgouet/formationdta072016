package fr.pizzeria.ihm;

public class SupprimerPizzaAction extends Action {

	public SupprimerPizzaAction(IhmHelper helper) {
		super("Supprimer une pizza", helper);
	}

	@Override
	public void execute() {
		System.out.println("Vous voulez supprimez une pizza veuillez choisir laquelle (nombre)");
		int id = helper.getScanner().nextInt();
		helper.getStockage().suppPizza(id - 1);

		System.out.println("Pizza supprimer avec succes \n");

	}

}
