package opgave11;

public class ThreadClass extends Thread {

	private CommonClass cc;
	private int max;
	
	public ThreadClass(CommonClass cc, int max) {
		super();
		this.cc = cc;
		this.max = max;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			cc.opdaterGlobal();
			cc.tagerRandomTid(max);
		}
	}
	
}
