package bean;





public class Compte {
	private Long Id;
	
	private double mt_impayé;
	private double mt_exigible;
	private double credit;
	private double provision;
	private Contrat contrat;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public double getMt_impayé() {
		return mt_impayé;
	}
	public void setMt_impayé(double mt_impayé) {
		this.mt_impayé = mt_impayé;
	}
	public double getMt_exigible() {
		return mt_exigible;
	}
	public void setMt_exigible(double mt_exigible) {
		this.mt_exigible = mt_exigible;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getProvision() {
		return provision;
	}
	public void setProvision(double provision) {
		this.provision = provision;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(double mt_impayé, double mt_exigible, double credit, double provision) {
		super();
		this.mt_impayé = mt_impayé;
		this.mt_exigible = mt_exigible;
		this.credit = credit;
		this.provision = provision;
	}
	
}
