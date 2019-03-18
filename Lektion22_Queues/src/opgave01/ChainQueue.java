package opgave01;

public class ChainQueue<T> implements Queue<T> {

	Node first, last;
	int size = 0;

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void enqueue(T newElement) {
		Node n = new Node(newElement, null);
		if (first == null) {
			first = n;
			last = first;
		} else {
			last.next = n;
			last = n;
		}

		size++;
	}

	@Override
	public T dequeue() {
		if (first == null) {
			throw new EmptyQueueException();
		}

		T removed = first.value;
		first = first.next;

		size--;
		return removed;
	}

	@Override
	public T getFront() {
		if (first == null) {
			throw new EmptyQueueException();
		}

		return first.value;
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

	private class Node {
		public T value;
		public Node next;

		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public void display() {
		System.out.println(toString() + " " + size() + "/" + isEmpty() + "\n");
	}

}
