package opgave05;

public class Spiritus {

	private String betegnelse;
	private int pris;
	
	public Spiritus(String betegnelse, int pris) {
		setBetegnelse(betegnelse);
		setPris(pris);
	}
	
	public double hentMoms() {
		return (pris > 90) ? pris * 1.2 : pris * 0.8;
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public void setBetegnelse(String betegnelse) {
		this.betegnelse = betegnelse;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}
	
}
