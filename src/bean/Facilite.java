package bean;

public class Facilite {
	private long id;
	private String etat;
	private double montant;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String isEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Facilite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facilite(String etat, double montant) {
		super();
		this.etat = etat;
		this.montant = montant;
	}
	
}
