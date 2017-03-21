package bean;

import java.util.Date;

public class Echeance {
	private int ordre;
	private double montant;
	private Date dateEcheance;
	private String etat;
	public Echeance() {
		super();
	}
	public Echeance(int ordre, double montant, Date dateEcheance, String etat) {
		super();
		this.ordre = ordre;
		this.montant = montant;
		this.dateEcheance = dateEcheance;
		this.etat = etat;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
