package opgave02;

import java.util.concurrent.Semaphore;

public class ThreadHandler {

	public boolean run = true;

	public Semaphore sem = new Semaphore(1);
	public Semaphore semHandle = new Semaphore(1); 
	
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
//		display();
		
		if (nextNumber >= 100) {
			run = false;
		}
	}
	
	public void display() {
		System.out.println(currentCustomer + "/" + nextNumber);
	}
	
}
