package opgave03;

import java.util.Random;

public class Indgang extends Thread {
	
	private ThreadHandler th;
	private int interval;
	private boolean random;
	private Random rand = new Random();
	
	public Indgang(ThreadHandler th, int interval, boolean random) {
		this.interval = interval;
		this.random = random;
		this.th = th;
	}
	
	public void run() {
		while(th.run) {
			th.drawNumber();
			
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
