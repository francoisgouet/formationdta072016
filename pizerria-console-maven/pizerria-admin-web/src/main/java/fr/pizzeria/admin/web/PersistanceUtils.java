package fr.pizzeria.admin.web;

import org.dom4j.util.SimpleSingleton;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class PersistanceUtils {
    
    private static PersistanceUtils instanceUnique = new PersistanceUtils();
    
    private Stockage<Pizza> stockagePizza = new StockagePizzaJpa();
    
    // etape 1 - constructeur privé
    private PersistanceUtils() {
    }
    
    // etape 2 - accéder à l'instance unique depuis l'extérieur de la classe
    public static PersistanceUtils getInstance() {
        return instanceUnique;
    }
    
    public Stockage<Pizza> getStockagePizza() {
        return stockagePizza;
    }
}

