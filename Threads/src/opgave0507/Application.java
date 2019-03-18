package opgave0507;

public class Application {

	private static lottoraek[] raekker;
	private static lottoraek rigtig;
	
	public static void main(String[] args) {
		long tStart = System.nanoTime();		
		
		// Generation
		generate(10000000);
		
		long tGen = System.nanoTime();
		System.out.println("Generation Time: " + (tGen - tStart) / 1000000);

		// Single
		int[] rigtigeSingle = calcSingle();
		
		long tCalcSingle = System.nanoTime();
		System.out.println("\nSingle Threaded Time: " + (tCalcSingle - tGen) / 1000000);
		System.out.println("\nSingle Rigtige:");
		for (int i = 0; i < rigtigeSingle.length; i++) {
			System.out.println(i + " rigtige: " + rigtigeSingle[i]);
		}
		int antalTalte = 0;
		for (int i = 0; i < rigtigeSingle.length; i++) {
			antalTalte += rigtigeSingle[i];
		}
		System.out.println("\nSingle antal talte: " + antalTalte);
		
		// Multi
		int[] rigtigeMulti = null;
		try {
			rigtigeMulti = calcMulti();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long tCalcMulti = System.nanoTime();
		System.out.println("\nMulti Threaded Time: " + (tCalcMulti - tCalcSingle) / 1000000);
		System.out.println("\nMulti Rigtige:");
		for (int i = 0; i < rigtigeMulti.length; i++) {
			System.out.println(i + " rigtige: " + rigtigeMulti[i]);
		}
		antalTalte = 0;
		for (int i = 0; i < rigtigeMulti.length; i++) {
			antalTalte += rigtigeMulti[i];
		}
		System.out.println("\nMulti antal talte: " + antalTalte);
		
	}
	
	private static void generate(int amount) {
		raekker = new lottoraek[amount];
		for (int i = 0; i < raekker.length; i++) {
			raekker[i] = new lottoraek();
		}
		
		rigtig = new lottoraek();
	}
	
	private static int[] calcSingle() {
		int[] antalRigtige = new int[8];
		
		for (int i = 0; i < raekker.length; i++) {
			antalRigtige[raekker[i].antalrigtige(rigtig)]++;
		}
		
		return antalRigtige;
	}
	
	private static int[] calcMulti() throws InterruptedException {
		int[] antalRigtigeA = new int[8];
		int[] antalRigtigeB = new int[8];
		
		UdtraekThread tA = new UdtraekThread(0, raekker.length / 2, raekker, antalRigtigeA, rigtig);
		UdtraekThread tB = new UdtraekThread(raekker.length / 2, raekker.length, raekker, antalRigtigeB, rigtig);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		int[] antalRigtige = new int[8];
		for (int i = 0; i < antalRigtige.length; i++) {
			antalRigtige[i] = antalRigtigeA[i] + antalRigtigeB[i];
		}
		
		return antalRigtige;
	}

}
