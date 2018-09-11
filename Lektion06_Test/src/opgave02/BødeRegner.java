package opgave02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BødeRegner {

	public int beregnBøde(LocalDate beregnetDato, LocalDate faktiskDato, boolean voksen) {
		if (beregnetDato.isAfter(faktiskDato)) {
			throw new RuntimeException("Bog ikke afleveret for sent.");
		}
		
		int daysLate = (int) ChronoUnit.DAYS.between(beregnetDato, faktiskDato);
		
		if (daysLate > 14) {
			return (voksen) ? 90 : 45;
		} else if (daysLate > 7) {
			return (voksen) ? 60 : 30;
		} else {
			return (voksen) ? 20 : 10;
		}
	}
	
}
