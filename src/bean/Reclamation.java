package bean;

import java.util.Date;


public class Reclamation {
	private Long id;
	private Date date;
	private String origine;
	private String etat;
	private String commentaire;
	private Date dateResolution;
	private String commentaireResolution;
	private String type_reclamation;
	private long contrat;
	public Reclamation(Date date, String origine, String etat, String commentaire, String type_reclamation,
			long contrat) {
		super();
		this.date = date;
		this.origine = origine;
		this.etat = etat;
		this.commentaire = commentaire;
		this.type_reclamation = type_reclamation;
		this.contrat = contrat;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getDateResolution() {
		return dateResolution;
	}
	public void setDateResolution(Date dateResolution) {
		this.dateResolution = dateResolution;
	}
	public String getCommentaireResolution() {
		return commentaireResolution;
	}
	public void setCommentaireResolution(String commentaireResolution) {
		this.commentaireResolution = commentaireResolution;
	}
	public void setType_reclamation(String type_reclamation) {
		this.type_reclamation = type_reclamation;
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
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getType_reclamation() {
		return type_reclamation;
	}
	
	public long getContrat() {
		return contrat;
	}
	public void setContrat(long contrat) {
		this.contrat = contrat;
	}
	
	
}
