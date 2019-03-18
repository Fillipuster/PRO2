package opgave01;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {

	LinkedList<T> list = new LinkedList<>();
	
	@Override
	public void push(T element) {
		list.addFirst(element);
	}

	@Override
	public T pop() {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return list.toString() + " n=" + size();
	}

}
