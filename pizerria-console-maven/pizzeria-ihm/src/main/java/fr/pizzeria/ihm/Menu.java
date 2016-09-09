package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.reflections.Reflections;

import fr.pizzeria.exception.SaisieEntierException;
public class Menu { 
	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();
	private IhmHelper ihmHelper;

	public Menu(IhmHelper helper) {
		
		this.ihmHelper = helper;
		
		Reflections reflections = new Reflections();
		//Set<Class<? extends Action>> subTypes = reflections.getSubTypesOf(Action.class);
		
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Ac.class);
		AtomicInteger f = new AtomicInteger();
		annotated.forEach((l) -> {
				try {
					this.actions.put(f.incrementAndGet(),(Action) l.getConstructor(IhmHelper.class).newInstance((helper)));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					
					e.printStackTrace();
				}
		});	
		
		System.out.println(DateFormatUtils.format(Calendar.getInstance(),"dd/MM-hh:mm"));
	}

	public void start() throws IOException {
		boolean result = false;
		do {
			affichageM();
			result = choisir();
		} while (!result);
	}

	public void affichageM() {
		System.out.println("***** Pizzeria Administration *****");

		/*for (Integer numero : actions.keySet()) {
			Action ActionEnCours = actions.get(numero);
			String libelleAction = ActionEnCours.getLibelle();
			System.out.println(numero + " " + libelleAction);

		}*/
		actions.forEach((numero,valeur)->{
			Action ActionEnCours = actions.get(numero);
			String libelleAction = ActionEnCours.getLibelle();
			System.out.println(numero + " " + libelleAction);
			});
		System.out.println(CHOIX_SORTIR + ". Quitter" + "\n");
		}

	public boolean choisir() throws IOException {
		System.out.println("Veuillez choisir une option");
		int choix = 0;
		try {
			// Instructions susceptibles de provoquer des erreurs;

			choix = ihmHelper.saisirEntier();
			if (!actions.containsKey(choix)) {
				if (choix != CHOIX_SORTIR) {
					System.out.println("Erreur de saisie, veuillez recommencer!" + "\n");
				}
			} else {

				Action LaBonneAction = actions.get(choix);
				LaBonneAction.execute();

			}
		} catch (SaisieEntierException e) {
			System.out.println(e.getMessage());
		}

		return choix == CHOIX_SORTIR;
	}

}
