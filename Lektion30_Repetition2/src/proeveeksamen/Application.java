package proeveeksamen;

import java.util.ArrayList;
import java.util.List;

public class Application {
	
	private static void pPrint(String msg, Object res) {
		System.out.println(msg + "\n-> " + res + "\n");
	}
	
	public static void main(String[] args) {
		Abonnement a = new Abonnement(120, 0.5);
		TimePakke tp = new TimePakke(90, 0.7, 5);
		UdvidelsesPakke up = new UdvidelsesPakke(90, 0.7, 5, 30.5);
		
		List<Abonnement> list = new ArrayList<Abonnement>();
		list.add(a);
		list.add(tp);
		list.add(up);
		
		pPrint("Pris for Abonnement:", a.abonnementsPris());
		pPrint("Pris for TimePakke:", tp.abonnementsPris());
		pPrint("Pris for UdvidelsesPakke:", up.abonnementsPris());
		pPrint("Sum af pakkepriser:", Abonnement.getTotalAbonnementPris(list));
	}
		
}
