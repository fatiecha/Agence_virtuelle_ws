package projectWS.projectWS;

import java.util.ArrayList;
import java.util.List;

import bean.Compte;
import bean.Consommation;
import bean.Contrat;
import bean.Devis;
import bean.Echeance;
import bean.Facilite;
import bean.Facture;
import bean.Reclamation;

public class Test {
	public static void main(String[] args) throws Exception {
		List<Echeance> l = new ArrayList<Echeance>();
ConsulterFacilitesWS c=new ConsulterFacilitesWS();
		l = c.consulterEcheance("1");
		System.out.println(l);
		for (int i = 0; i < l.size(); i++) {
			Echeance d = l.get(i);
			System.out.println(d.getOrdre());
			System.out.println(d.getMontant());
		}

	}
	/*public static void main(String[] args) throws Exception {
	AjouterReclamationWS c=new AjouterReclamationWS();
	String msg=c.ajouterReclamation(1l, "origine", "type1", "comm1");
	System.out.println(msg);
	

	}*/
	
	/*public static void main(String[] args) throws Exception {
		ConsulterFacturesWS f=new ConsulterFacturesWS();
		List<Facture> l = new ArrayList<Facture>();		
		l=f.consulterFacture("1");
		
	}*/
}
