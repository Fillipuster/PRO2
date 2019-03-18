package opgave05;

public abstract class Vare {

	private String navn;
	private int pris;
	
	public Vare(String navn, int pris) {
		setNavn(navn);
		setPris(pris);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}
	
	abstract public double beregnMoms();
	
	@Override
	public String toString() {
		// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
		return String.format("%16s (%,8d|%,10.2f)", navn, pris, pris + beregnMoms());
	}
	
}
