package opgave04;

import java.util.Stack;

import opgave01.EmptyQueueException;
import opgave01.Queue;

public class StackQueue<T> implements Queue<T> {

	Stack<T> stack = new Stack<>();
	boolean flipped = false;
	
	private void flip() {
		Stack<T> temp = new Stack<>();
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
		}
				
		stack = temp;
		flipped = !flipped;
	}
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void enqueue(T newElement) {
		if (flipped) {
			flip();
		}
		
		stack.push(newElement);
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		if (!flipped) {
			flip();
		}
		
		return stack.pop();
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		if (!flipped) {
			flip();
		}
		
		return stack.peek();
	}

	@Override
	public int size() {
		return stack.size();
	}
	
	@Override
	public String toString() {
		if (flipped) {
			flip();
		}
		
		return stack.toString();
	}

	@Override
	public void display() {
		System.out.println(toString() + " " + size() + "/" + isEmpty() + "\n");
	}

}
