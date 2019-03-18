package opgave02;

import opgave01.Dequeue;
import opgave01.EmptyQueueException;

public class ChainDequeue<T> implements Dequeue<T> {

	Node first, last;
	int size;
	
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void addFirst(T newElement) {
		Node n = new Node(newElement, first, null);
		
		if (first == null) {
			first = n;
			return;
		}
		
		first.next.previous = n;
		first.next = n;
		first = n;
		size++;
	}

	@Override
	public void addLast(T newElement) {
		Node n = new Node(newElement, null, last);
		
		if (last == null) {
			last = n;
			return;
		}
		
		last.previous.next = n;
		last.previous = n;
		last = n;
		size++;
	}

	@Override
	public T removeFirst() {
		if (first == null) {
			throw new EmptyQueueException();
		}
		
		T removed = first.value;
		first = first.next;
		size--;
		return removed;
	}

	@Override
	public T removeLast() {
		if (last == null) {
			throw new EmptyQueueException();
		}
		
		T removed = last.value;
		last = last.previous;
		size--;
		return removed;
	}

	@Override
	public T getFirst() {
		if (first == null) {
			throw new EmptyQueueException();
		}
		
		return first.value;
	}

	@Override
	public T getLast() {
		if (last == null) {
			throw new EmptyQueueException();
		}
		
		return last.value;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node pos = first;
		while (pos != null) {
			sb.append(pos.value);
			if (pos.next != null) {
				sb.append(", ");
			}
			
			pos = pos.next;
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	public void display() {
		System.out.println(toString() + " " + size() + "/" + isEmpty() + "\n");
	}

	private class Node {
		public T value;
		public Node next, previous;
		
		public Node(T value, Node next, Node previous) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}
	}
	

}
