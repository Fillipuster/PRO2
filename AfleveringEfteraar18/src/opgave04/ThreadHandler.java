package opgave04;

public class ThreadHandler {

	public boolean run = true;

	private int size = 50;
	private String[] buffer = new String[size];
	private int bufferSize = 0, nextIn = 0, nextOut = 0, customers = 0;
	
	public synchronized void handleCustomer() throws InterruptedException {
		while (bufferSize == 0) wait();
		String result = buffer[nextOut];
		nextOut = (nextOut + 1) % size;
		bufferSize--;
		notifyAll();
		
//		if (result != null) display(true, result);
		display(true, result);
	}
	
	public synchronized void drawNumber(String name) throws InterruptedException {
		while (bufferSize == size) wait();
		buffer[nextIn] = name;
		nextIn = (nextIn + 1) % size; 
		bufferSize++;		
		notifyAll();
		
		customers++;
		display(false, name);
		
		if (customers > 100) run = false;
	}
	
	public void display(boolean handling, String name) {
		if (handling) {
			System.err.println(name + " handled.");
		} else {
			System.out.println(name + " added.");
		}
		
//		System.out.print("[");
//		for (int i = 0; i < buffer.length; i++) {
//			System.out.print(buffer[i] + (i == buffer.length ? "" : ", "));
//		}
//		System.out.println("]\n");
	}
	
}