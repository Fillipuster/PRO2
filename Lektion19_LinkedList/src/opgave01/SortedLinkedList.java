package opgave01;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SortedLinkedList<T extends Comparable<T>> {
	
	private Node first;
	
	public SortedLinkedList() {
		first = null;
	}
	
	public void addElement(T element) {
		Node node = new Node(element);
		
		if (first == null) {
			first = node;
		} else {
			if (node.data.compareTo(first.data) < 0) {
				node.next = first;
				first = node;
				return;
			}
			
			boolean done = false;
			Node pos = first;
			
			while(!done && node.data.compareTo(pos.data) > 0) {
					if (pos.next != null) {
						if (node.data.compareTo(pos.next.data) < 0) {
							node.next = pos.next;
							pos.next = node;
							done = true;
						}
						pos = pos.next;				
					} else {
						pos.next = node;
						done = true;
					}
			}
		}
	}
	
	public boolean removeElement(String element) {
		if (first != null) {
			Node pos = first;
			Node prev = null;
			
			while(pos != null) {
				if (pos.data.equals(element)) {
					if (prev == null) {
						first = pos.next;
					} else {
						prev.next = pos.next;						
					}
					return true;
				} else {
					prev = pos;
					pos = pos.next;
				}
			}
			
			return false;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public int countElements() {
		if (first == null) {
			return 0;
		} else {
			int count = 0;
			Node pos = first;
			boolean done = false;
			
			while (!done) {
				count++;
				if (pos.next != null) {
					pos = pos.next;					
				} else {
					done = true;
				}
			}
			
			return count;			
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node pos = first;
		boolean done = false;
		while (!done) {
			sb.append(pos.data);
			sb.append(", ");
			
			if (pos.next != null) {
				pos = pos.next;
			} else {
				done = true;
			}
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	private class Node {
		public Node next;
		public T data;
		
		public Node(T data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
}