package proeveeksamen;

import java.util.List;

public class Abonnement {

	public static double getTotalAbonnementPris(List<Abonnement> list) {
		double sum = 0d;
		for (Abonnement a : list) {
			sum += a.abonnementsPris();
		}
		
		return sum;
	}
	
	private double mndPris, minutPris;
	
	public Abonnement(double mndPris, double minutPris) {
		this.mndPris = mndPris;
		this.minutPris = minutPris;
	}
	
	public double abonnementsPris() {
		return mndPris;
	}
	
}
