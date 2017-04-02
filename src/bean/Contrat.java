package bean;

import java.util.Date;
import java.util.List;

public class Contrat {
	private Long id;
	private Date date;
	private String service;
	private String CIN;
	private String agence;
	private String branchement;
	private String etat;
	private String numCompteur;
	private Date datePoseCompteur;
	private String tournee;
	private String tarif;
	
	private Long idClient;
	private String NomClient;
	private Demande_abonnement demande_abonnement;

	private List<Consommation> consommations;
	private List<Facilite> facilites;
	private List<Devis> devis;
	private List<Facture> factures;
	private List<Reclamation> reclamations;

	private List<Client> clients;

	
	public String getTarif() {
		return tarif;
	}

	public void setTarif(String tarif) {
		this.tarif = tarif;
	}

	public String getTournee() {
		return tournee;
	}

	public void setTournee(String tournee) {
		this.tournee = tournee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return NomClient;
	}

	public void setNomClient(String idNomClient) {
		this.NomClient = idNomClient;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getBranchement() {
		return branchement;
	}

	public void setBranchement(String branchement) {
		this.branchement = branchement;
	}

	public String isEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Demande_abonnement getDemande_abonnement() {
		return demande_abonnement;
	}

	public void setDemande_abonnement(Demande_abonnement demande_abonnement) {
		this.demande_abonnement = demande_abonnement;
	}

	public List<Consommation> getConsommations() {
		return consommations;
	}

	public void setConsommations(List<Consommation> consommations) {
		this.consommations = consommations;
	}

	public List<Facilite> getFacilites() {
		return facilites;
	}

	public void setFacilites(List<Facilite> facilites) {
		this.facilites = facilites;
	}

	public List<Devis> getDevis() {
		return devis;
	}

	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumCompteur() {
		return numCompteur;
	}

	public void setNumCompteur(String numCompteur) {
		this.numCompteur = numCompteur;
	}

	public Date getDatePoseCompteur() {
		return datePoseCompteur;
	}

	public void setDatePoseCompteur(Date datePoseCompteur) {
		this.datePoseCompteur = datePoseCompteur;
	}

	public String getEtat() {
		return etat;
	}

	public Contrat(Date date, String service, String cIN, String agence, String branchement, String etat,
			String numCompteur, Date datePoseCompteur, Demande_abonnement demande_abonnement) {
		super();
		this.date = date;
		this.service = service;
		CIN = cIN;
		this.agence = agence;
		this.branchement = branchement;
		this.etat = etat;
		this.numCompteur = numCompteur;
		this.datePoseCompteur = datePoseCompteur;
		this.demande_abonnement = demande_abonnement;
	}

}
