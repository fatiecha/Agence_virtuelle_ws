package bean;

import java.util.Date;

public class Demande_abonnement {
	private Long id;
	private  Long tournee;
	private Date date;
	private String tarif;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTournee() {
		return tournee;
	}
	public void setTournee(Long tournee) {
		this.tournee = tournee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTarif() {
		return tarif;
	}
	public void setTarif(String tarif) {
		this.tarif = tarif;
	}
	public Demande_abonnement(Long tournee, Date date, String tarif) {
		super();
		this.tournee = tournee;
		this.date = date;
		this.tarif = tarif;
	}
	
}
