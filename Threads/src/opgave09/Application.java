package opgave09;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		long tStart = System.nanoTime();
		int max = 10000;
		
		CommonClass cc = new CommonClass(max);
		
		ThreadClass tA = new ThreadClass(0, cc, max);
		ThreadClass tB = new ThreadClass(1, cc, max);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		System.out.println("Global: " + cc.global);
		System.out.println("Time: " + (System.nanoTime() - tStart) / 1000000);
	}

}
