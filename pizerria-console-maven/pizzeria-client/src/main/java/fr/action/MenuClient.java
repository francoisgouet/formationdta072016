package fr.action;

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

public class MenuClient {
	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();
	private Helper helper;

	public MenuClient(Helper helper) {

		this.helper = helper;

		Reflections reflections = new Reflections();
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Actio.class);
		AtomicInteger f = new AtomicInteger();
		annotated.forEach((l) -> {
			try {
				this.actions.put(f.incrementAndGet(),(Action) l.getConstructor(Helper.class).newInstance((helper)));
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
		System.out.println("***** Pizzeria Client *****");
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
			choix = helper.saisirEntier();
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
