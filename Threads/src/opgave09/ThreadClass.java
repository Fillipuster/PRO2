package opgave09;

public class ThreadClass extends Thread {

	private int me, other;
	private CommonClass cc;
	private int max;
	
	public ThreadClass(int me, CommonClass cc, int max) {
		super();
		this.me = me;
		this.other = me == 1 ? 0 : 1;
		this.cc = cc;
		this.max = max;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			
			// Entercritical:
			cc.flag[me] = true;
			cc.turn = other;
			while (cc.flag[other] && cc.turn == other);
			// Critical:
			cc.opdaterGlobal();
			// Exitcritical:
			cc.flag[me] = false;
			// End of Petersons;
			
			cc.tagerRandomTid(max);
		}
	}
	
}
