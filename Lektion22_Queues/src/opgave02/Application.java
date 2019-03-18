package opgave02;

public class Application {

	public static void main(String[] args) {
		
		ChainDequeue<Integer> queue = new ChainDequeue<>();
		
		queue.display();
		
		boolean placeLast = false;
		for (int i = 0; i < 15; i++) {
			if (placeLast) {
				queue.addLast(i);
			} else {
				queue.addFirst(i);
			}
			
			placeLast = !placeLast;
			
			queue.display();
		}
		
	}

}
