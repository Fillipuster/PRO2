package opgave05;

public class ElVare extends Vare {

	public ElVare(String navn, int pris) {
		super(navn, pris);
	}

	@Override
	public double beregnMoms() {
		double moms = 0d;
		
		moms = getPris() * 0.3;
		moms = (moms < 3) ? 3 : moms;
		
		return moms;
	}

}
