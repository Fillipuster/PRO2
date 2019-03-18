package opgave05;

public class MainApp {

	public static void main(String[] args) {		
		Sælger Hansen = new Sælger("Hansen");
		Indkøber Jensen = new Indkøber("Jensen");
		
		BogTitel AndersAnd = new BogTitel("Anders And", 6);
		BogTitel Java = new BogTitel("Java", 8);
		
		Kunde k1 = new Kunde("Læsehest 1");
		Kunde k2 = new Kunde("Læsehest 2");
		Kunde k3 = new Kunde("Læsehest 3");
		
		AndersAnd.addObserver(Hansen);
		AndersAnd.addObserver(Jensen);
		
		System.out.println("\tKunder køber Java...");
		Java.etKøb(k1);
		Java.etKøb(k2);
		Java.etKøb(k3);
		
		System.out.println("\tKunder køber Anders And...");
		AndersAnd.etKøb(k1);
		AndersAnd.etKøb(k2);
		AndersAnd.etKøb(k3);
	}

}
