package opgave01;

public class ThreadHandler {

	public boolean run = true;
	
	public volatile int turn = 0;
	public boolean[] flag = new boolean[2];
	
	private int currentCustomer = 0;
	private int nextNumber = 0;
	
	public void handleCustomer() {
		if (nextNumber > currentCustomer) {
			currentCustomer++;
		}
		display();
	}
	
	public void drawNumber() {
		nextNumber++;
		display();
		
		if (nextNumber >= 100) {
			run = false;
		}
	}
	
	public void display() {
		System.out.println(currentCustomer + "/" + nextNumber);
	}
	
}
