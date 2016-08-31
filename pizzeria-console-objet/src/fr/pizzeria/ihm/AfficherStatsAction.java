package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.CompteStat;
import fr.pizzeria.model.Livreur;

public class AfficherStatsAction extends Action {

	public AfficherStatsAction(IhmHelper helper) {
		super("Afficher Statistiques Compte", helper);
	}
	
	@Override
	public void execute(){
		Collection<CompteStat> collec = new ArrayList<CompteStat>();
		Collection<Client> clients = this.helper.getStockageClient().findAll();
		Collection<Livreur> livreurs = this.helper.getStockageLivreur().findAll();
		collec.addAll(clients);
		collec.addAll(livreurs);
		
		int nb_comptes = collec.size();
		
		/** Java 7 **/ 
		/*double total=0;
		 * for (CompteStat t:collec){
			total += t.getSolde();
		}
		double moyenne = total/nb_comptes;
		CompteStat mini = Collections.min(collec, new Comparator<CompteStat>() {

			@Override
			public int compare(CompteStat o1, CompteStat o2) {
				return o1.getSolde().compareTo(o2.getSolde());
			}
		});
		Double soldePlusFaible = mini.getSolde();
		CompteStat maxi = Collections.max(collec, new Comparator<CompteStat>() {

			@Override
			public int compare(CompteStat o1, CompteStat o2) {
				return o1.getSolde().compareTo(o2.getSolde());
			}
		});
		Double soldePlusEleve = maxi.getSolde();
		System.out.println("Total Solde= "+ total + "€");
		System.out.println("Moyenne Solde= "+ moyenne);
		System.out.println("Solde le plus faible = "+ soldePlusFaible);
		System.out.println("Solde le plus eleve = "+ soldePlusEleve);*/
		/** Java 8 **/
		double moyenneJava8 = collec.stream().collect(Collectors.averagingDouble(CompteStat::getSolde));
		double totalJava8 = collec.stream().map(t -> t.getSolde()).reduce((t1,t2) -> t1+t2).get().doubleValue();
		Comparator <CompteStat> comp = (p1,p2)-> Double.compare(p1.getSolde(),p2.getSolde()) ;
		Optional<CompteStat> f = collec.stream().min(comp);
		Optional<CompteStat> g = collec.stream().max(comp);
		System.out.println("Nombres de comptes = "+ nb_comptes);
		System.out.println("Total Solde= "+ totalJava8 + "€");
		System.out.println("Moyenne Solde J8= "+ moyenneJava8);
		System.out.println("Solde le plus faible = "+f.get().getSolde());
		System.out.println("Solde le plus eleve = "+g.get().getSolde());
		
	}
}
