package opgave01;

import java.util.Random;

public class Indgang extends Thread {
	
	private int me, other;
	private ThreadHandler th;
	private int interval;
	private boolean random;
	private Random rand = new Random();
	
	public Indgang(int me, ThreadHandler th, int interval, boolean random) {
		this.interval = interval;
		this.random = random;
		this.th = th;
		this.me = me;
		this.other = me == 1 ? 0 : 1;
	}
	
	public void run() {
		while(th.run) {
			th.flag[me] = true;
			th.turn = other;
			while(th.flag[other] && th.turn == other);
			th.drawNumber();
			th.flag[me] = false;
			
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
