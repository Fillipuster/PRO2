package opgave03;

import java.util.EmptyStackException;

import opgave01.Stack;

public class LinkedDropOutStack<T> implements Stack<T> {
	
	Node top;
	int maxSize;
	int size;
	
	public LinkedDropOutStack(int size) {
		maxSize = size;
		size = 0;
	}
	
	@Override
	public void push(T element) {
		if (size == maxSize) {
			top.dropLast();
		} else {
			size++;
		}
		
		top = new Node(element, top);
	}

	@Override
	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		
		T removed = top.value;
		top = top.previous;
		size--;
		
		return removed;
	}

	@Override
	public T peek() {
		return top.value;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[\n");
		
		if (top != null) {
			Node n = top;
			while (n != null) {
				sb.append("  " + n.value + ",\n");
				n = n.previous;
			}
		}
		
		sb.append("] n=" + size());			
		
		return sb.toString();
	}
	
	private class Node {
		public T value;
		public Node previous;
		
		public Node(T value, Node previous) {
			this.value = value;
			this.previous = previous;
		}
		
		public void dropLast() {
			if (previous.previous == null) {
				previous = null;
			} else {
				previous.dropLast();
			}
		}
	}
	
}
