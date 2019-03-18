package opgave03;

public class ThreadHandler {

	public boolean run = true;
	
	private int currentCustomer = 0;
	private int nextNumber = 0;
	
	public synchronized void handleCustomer() {
		if (nextNumber > currentCustomer) {
			currentCustomer++;
		}
		display();
	}
	
	public synchronized void drawNumber() {
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
