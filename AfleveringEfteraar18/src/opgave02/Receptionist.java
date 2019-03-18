package opgave02;

import java.util.Random;

public class Receptionist extends Thread {
	
	private ThreadHandler th;
	private int interval;
	private boolean random;
	private Random rand = new Random();
	
	public Receptionist(ThreadHandler th, int interval, boolean random) {
		this.interval = interval;
		this.random = random;
		this.th = th;
	}
	
	public void run() {
		while(th.run) {
			try {
				th.semHandle.acquire();
				th.handleCustomer();
				th.semHandle.release();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try {
				if (random) {
					Thread.sleep(rand.nextInt(interval));
				} else {
					Thread.sleep(interval);
				}			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
}
