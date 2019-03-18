package opgave01;

public class Application {

	public static void main(String[] args) {
		performTest("Array Queue", new ArrayQueue<Integer>());
		performTest("Chain Queue", new ChainQueue<Integer>());
	}
	
	private static void performTest(String name, Queue<Integer> queue) {
		System.err.println("Testing with " + name + ".\n");
		
		queue.display();
		
		try {
			queue.getFront();
		} catch (EmptyQueueException e) {
			System.out.println("EmptyQueueException caught on getFront() call to empty queue.\n");
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Enqueueing " + i + "...");
			queue.enqueue(i);
			queue.display();
		}

		System.out.println("Front : " + queue.getFront());

		System.out.println("\t---DEQUEUEING---\n");

		for (int i = 0; i < 6; i++) {
			try {
				System.out.println("Dequeueing : " + queue.dequeue());
				queue.display();
			} catch (EmptyQueueException e) {
				System.out.println("EmptyQueueException caught on index: " + i);
			}
		}
	}

}
