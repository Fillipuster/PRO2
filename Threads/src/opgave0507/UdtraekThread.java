package opgave0507;

public class UdtraekThread extends Thread {
	
	private int iMin, iMax;
	private lottoraek[] raekker;
	private lottoraek rigtig;
	private int[] antalRigtige;
	
	public UdtraekThread(int iMin, int iMax, lottoraek[] raekker, int[] antalRigtige, lottoraek rigtig) {
		super();
		this.iMin = iMin;
		this.iMax = iMax;
		this.raekker = raekker;
		this.antalRigtige = antalRigtige;
		this.rigtig = rigtig;
	}
	
	public void run() {
		for (int i = iMin; i < iMax; i++) {
			antalRigtige[raekker[i].antalrigtige(rigtig)]++;
		}
	}
	
}
