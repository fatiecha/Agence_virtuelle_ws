package bean;

import java.io.Serializable;
import java.util.Date;



public class Devis implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Date date;
	private String etat;
	private double montant;
	private String commentaire;
	private Long contrat;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	

	public Devis(Date date, String etat, double montant, String commentaire, Long contrat) {
		super();
		this.date = date;
		this.etat = etat;
		this.montant = montant;
		this.commentaire = commentaire;
		this.contrat = contrat;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Devis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Long getContrat() {
		return contrat;
	}
	public void setContrat(Long contrat) {
		this.contrat = contrat;
	}
	
}
