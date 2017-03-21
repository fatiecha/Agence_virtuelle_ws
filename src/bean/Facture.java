package bean;




import java.util.Date;
import java.util.List;



public class Facture {
	
	private long id;
	private String periode;
	private double montant;
	private double solde;
	private Date date_exigibilite;
	private Date date;
	private boolean etat;
	
	private String type_facture;
	
	private long contrat;
	
	private List<Paiement> paiements;
	
	
	private long facilite;
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(String periode, double montant, double solde, Date date_exigibilite, Date date,
			String type_facture, long contrat) {
		super();
		this.periode = periode;
		this.montant = montant;
		this.solde = solde;
		this.date_exigibilite = date_exigibilite;
		this.date = date;
		this.type_facture = type_facture;
		this.contrat = contrat;
	}
	
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDate_exigibilite() {
		return date_exigibilite;
	}
	public void setDate_exigibilite(Date date_exigibilite) {
		this.date_exigibilite = date_exigibilite;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType_facture() {
		return type_facture;
	}
	public void setType_facture(String type_facture) {
		this.type_facture = type_facture;
	}
	public long getContrat() {
		return contrat;
	}
	public void setContrat(long contrat) {
		this.contrat = contrat;
	}
	public List<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	public long getFacilite() {
		return facilite;
	}
	public void setFacilite(long facilite) {
		this.facilite = facilite;
	}
	
	
	
	
	
	

	
	
	
	
}
