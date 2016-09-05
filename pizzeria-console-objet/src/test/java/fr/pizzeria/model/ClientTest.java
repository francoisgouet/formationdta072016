package fr.pizzeria.model;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public class ClientTest {
	
	@Test(expected = DebitException.class)
	public void testCrediterCompte() throws DebitException{
		Client client = new Client();
		double montant =  5000;
		double ancienSolde = client.getSolde();
		client.debiterCompte(montant);
		//assert(client.getSolde() == ancienSolde+montant);
	}
}