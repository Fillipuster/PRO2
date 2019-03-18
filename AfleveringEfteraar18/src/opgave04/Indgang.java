package opgave04;

import java.util.Random;

public class Indgang extends Thread {
	
	private ThreadHandler th;
	private int interval;
	private boolean random;
	private Random rand = new Random();
	private String name;
	private int count = 0;
	
	public Indgang(ThreadHandler th, int interval, boolean random, String name) {
		this.interval = interval;
		this.random = random;
		this.th = th;
		this.name = name;
	}
	
	public void run() {
		while(th.run) {
			try {
				th.drawNumber(name + Integer.toString(++count));
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
