package opgave02;

// Klasse lavet generisk jf. lektion 20 (Generics);
public class SortedDoublyLinkedList<T extends Comparable<T>> {

	private Node first, last;

	public SortedDoublyLinkedList() {
		first = new Node();
		last = new Node();

		first.previous = null;
		first.next = last;
		last.previous = first;
		last.next = null;
	}

	public void addElement(T element) {
		Node node = new Node();
		node.data = element;

		// In case the list is empty;
		if (first.next == last) {
			node.previous = first;
			node.next = first.next;
			
			first.next = node;
			last.previous = node;
			
			return;
		}
		
		// In case our element should be placed first;
		if (node.data.compareTo(first.next.data) < 0) {
			node.next = first.next;
			node.previous = first;
			
			first.next.previous = node;
			first.next = node;
			
			return;
		}
		
		// Any other case;
		Node pos = first.next;
		while (pos.hasNext()) {
			// Our element has to be placed last;
			if (pos.next.data == null) {
				node.next = last;
				node.previous = last.previous;

				last.previous.next = node;
				last.previous = node;

				return;
			}
			
			// Our element has found its correct position;
			if (node.data.compareTo(pos.data) >= 0 && node.data.compareTo(pos.next.data) <= 0) {
				node.previous = pos;
				node.next = pos.next;
				
				pos.next.previous = node;
				pos.next = node;
				
				return;
			}
				
			pos = pos.next;
		}
	}
	
	public boolean removeElement(String element) {
		Node pos = first.next; 
		
		while (pos.hasNext()) {
			if (pos.data.equals(element)) {
				pos.previous.next = pos.next;
				pos.next.previous = pos.previous;
				
				return true;
			}
			
			pos = pos.next;
		}
		
		return false;
	}
	
	public T removeFirst() {
		if (first.next == last) {
			return null;
		}
		
		T removed = first.next.data;
		first.next.next.previous = first;
		first.next = first.next.next;
		
		return removed;
	}

	public T removeLast() {
		if (last.previous == first) {
			return null;
		}
		
		T removed = last.previous.data;
		last.previous.previous.next = last;
		last.previous = last.previous.previous;
		
		return removed;
	}
	
	public int countElements() {		
		int count = 0;
		Node pos = first.next;
		while (pos.hasNext()) {
			count++;
			pos = pos.next;
		}
		
		return count;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node pos = first.next;
		while (pos.hasNext()) {
			sb.append(pos.data);
			if (pos.next.data != null) {
				sb.append(", ");				
			}
			
			pos = pos.next;
		}

		sb.append("]");
		return sb.toString();
	}

	private class Node {
		public T data;
		public Node next;
		public Node previous;

		public boolean hasNext() {
			return next != null;
		}
	}

}
