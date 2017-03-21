package bean;

import java.util.Date;


public class Consommation {
	private long id;
	private String periode;
	private Date date_releve;
	private int nbr_jour;
	private double index_lu;
	private double volume_consomme;
	private double volume_facture;
	private String type_lecture;

	private Contrat contrat;

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

	public Date getDate_releve() {
		return date_releve;
	}

	public void setDate_releve(Date date_releve) {
		this.date_releve = date_releve;
	}

	public int getNbr_jour() {
		return nbr_jour;
	}

	public void setNbr_jour(int nbr_jour) {
		this.nbr_jour = nbr_jour;
	}

	public double getIndex_lu() {
		return index_lu;
	}

	public void setIndex_lu(double index_lu) {
		this.index_lu = index_lu;
	}

	public double getVolume_consomme() {
		return volume_consomme;
	}

	public void setVolume_consomme(double volume_consomme) {
		this.volume_consomme = volume_consomme;
	}

	public double getVolume_facture() {
		return volume_facture;
	}

	public void setVolume_facture(double volume_facture) {
		this.volume_facture = volume_facture;
	}

	
	public String getType_lecture() {
		return type_lecture;
	}

	public void setType_lecture(String type_lecture) {
		this.type_lecture = type_lecture;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Consommation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consommation(String periode, Date date_releve, int nbr_jour, double index_lu, double volume_consomme,
			double volume_facture, String type_lecture, Contrat contrat) {
		super();
		this.periode = periode;
		this.date_releve = date_releve;
		this.nbr_jour = nbr_jour;
		this.index_lu = index_lu;
		this.volume_consomme = volume_consomme;
		this.volume_facture = volume_facture;
		this.type_lecture = type_lecture;
		this.contrat = contrat;
	}
	
}
