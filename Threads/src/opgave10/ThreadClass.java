package opgave10;

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
			// Critical, wait and signal withint try block:
			try {
				cc.sem.acquire();
				cc.opdaterGlobal();
				cc.sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			cc.tagerRandomTid(max);
		}
	}
	
}
