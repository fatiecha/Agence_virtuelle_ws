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
//		AjouterConCliWS c=new AjouterConCliWS();
//		List<Contrat> contrats=new ArrayList<Contrat>();
//contrats=c.getCinIdContrat("784ddf89", "eau");
//if(contrats.isEmpty()){
//	System.out.println("empty");
//}
//else{
//for(int i=0;i<contrats.size();i++){
//Contrat t=contrats.get(i);
//System.out.println(t.getCIN()+" "+t.getId());
//String msg=c.getCinClient("12");
//System.out.println(msg);
		
//		boolean a=c.checkConcli("2", "1");
//		System.out.println(a);
//		String msg=c.addContratClient("333", "1", "eau");
//		System.out.println(msg);
//		AjouterDemAboWS c=new AjouterDemAboWS();
//		String msg=c.ajouterDem_Abo("1555", "1", "eau", "tar");
//		System.out.println(msg);
//		ConsulterContratsWS c=new ConsulterContratsWS();
//		List<Contrat> l=new ArrayList<Contrat>();
//		l=c.consulterContrats("1");
//		for(int i=0;i<l.size();i++){
//			Contrat e =l.get(i);
//			System.out.println(e.getId());
//		}
		
		ConsulterCompteWS c=new ConsulterCompteWS();
		Compte d=new Compte();
		d=c.consulterCompte("12");
		System.out.println(d.getCredit());
		System.out.println(d.getProvision());
		System.out.println(d.getMt_impayé());
		System.out.println(d.getMt_exigible());

}

}
