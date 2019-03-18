package opgave09;

import java.util.Random;

public class CommonClass {
	
	volatile public int turn = 0;
	public boolean[] flag = new boolean[2];
	
	public int global = 0;
	private int max;
	
	public CommonClass(int max) {
		flag[0] = false;
		flag[1] = false;
		this.max = max;
	}

	public void tagerRandomTid(int max) {
		Random r = new Random();
		double dummy = r.nextDouble() * Math.pow(max, 5);
		for (int i = 0; i < max; i++) {
			dummy = Math.sqrt(dummy);
			for (int j = 0; j < max; j++) {
				dummy = Math.pow(dummy, 2);
			}
		}
	}
	
	public void opdaterGlobal() {
		int temp;
		temp = global;
		tagerRandomTid(max);
		global = temp + 1;
	}
	
}
