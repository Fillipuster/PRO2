package opgave05;

public class FoedeVare extends Vare {

	public FoedeVare(String navn, int pris) {
		super(navn, pris);
	}

	@Override
	public double beregnMoms() {
		return getPris() * 0.05;
	}

}
