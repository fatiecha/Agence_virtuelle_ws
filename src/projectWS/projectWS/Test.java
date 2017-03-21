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
	/*public static void main(String[] args) throws Exception {
		List<Facture> l = new ArrayList<>();
ConsulterFacturesWS c=new ConsulterFacturesWS();
		l = c.consulterFacture(1L);
		System.out.println(l);
		for (int i = 0; i < l.size(); i++) {
			Facture d = l.get(i);
			System.out.println(d.getId());
		}

	}*/
	/*public static void main(String[] args) throws Exception {
	AjouterReclamationWS c=new AjouterReclamationWS();
	String msg=c.ajouterReclamation(1l, "origine", "type1", "comm1");
	System.out.println(msg);
	

	}*/
	
	public static void main(String[] args) throws Exception {
		ConsulterDevisWS c=new ConsulterDevisWS();
		List<Devis> msg=c.consulterDevis(1L);
		System.out.println("test" + msg.size());
	}
}
