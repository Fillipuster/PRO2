package opgave05;

public class MainApp {

	public static void main(String[] args) {
		
		ElVare ev = new ElVare("T420", 4950);
		FoedeVare fv = new FoedeVare("Æble", 13999);
		
		Spiritus s1 = new Spiritus("Jägermeister", 239);
		SpiritusAdapter sa1 = new SpiritusAdapter(s1);
		
		Spiritus s2 = new Spiritus("Shotka-vodka", 74);
		SpiritusAdapter sa2 = new SpiritusAdapter(s2);
		
		System.out.println(ev);
		System.out.println(fv);
		System.out.println(sa1);
		System.out.println(sa2);
		
	}

}
