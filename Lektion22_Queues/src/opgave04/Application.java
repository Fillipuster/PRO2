package opgave04;

import opgave01.EmptyQueueException;

public class Application {

	public static void main(String[] args) {
		StackQueue<Integer> sq = new StackQueue<>();
		
		for (int i = 0; i < 5; i++) {
			sq.enqueue(i);
		}
		
		sq.display();
		System.out.println("Front: " + sq.getFront() + "\n");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Dequeue: " + sq.dequeue());
		}
		System.out.println();
		sq.display();
		
		for (int i = 0; i < 5; i++) {
			sq.enqueue(i);
		}
		
		sq.display();
		System.out.println("Front: " + sq.getFront() + "\n");
		
		while (!sq.isEmpty()) {
			System.out.println("Dequeue: " + sq.dequeue());
		}
		System.out.println();
		sq.display();
		
		try {
			sq.getFront();
			System.out.println("Failed!");
		} catch (EmptyQueueException e) {
			System.out.println("Caught EmptyQueueException!");
		}
		
		try {
			sq.dequeue();
			System.out.println("Failed!");
		} catch (EmptyQueueException e) {
			System.out.println("Caught EmptyQueueException!");
		}
	}

}
