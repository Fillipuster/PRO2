package miniprojekt;

public class Studerende {
	
	private String cpr;
	private String fornavn;
	private String efternavn;
	
	public Studerende(String cpr, String fornavn, String efternavn) {
		setCpr(cpr);
		setFornavn(fornavn);
		setEfternavn(efternavn);
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}
	
	@Override
	public String toString() {
		return efternavn + ", " + fornavn + " (" + cpr + ")";
	}
	
}
