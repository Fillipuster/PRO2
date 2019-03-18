package opgave01;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {

	private T[] queue;
	private int tail;

	public ArrayQueue() {
		queue = (T[]) new Object[2];
		tail = 0;
	}

	@Override
	public boolean isEmpty() {
		return tail == 0;
	}

	private void expand() {
		T[] temp = (T[]) new Object[queue.length * 2];

		for (int i = 0; i < queue.length; i++) {
			temp[i] = queue[i];
		}

		queue = temp;
	}

	@Override
	public void enqueue(T newElement) {
		if (tail >= queue.length) {
			expand();
		}

		queue[tail++] = newElement;
	}

	@Override
	public T dequeue() {
		if (tail == 0) {
			throw new EmptyQueueException();
		}

		T removed = queue[0];

		for (int i = 1; i < queue.length; i++) {
			queue[i - 1] = queue[i];
		}

		queue[tail--] = null;

		return removed;
	}

	@Override
	public T getFront() {
		if (tail == 0) {
			throw new EmptyQueueException();
		}
		
		return queue[0];
	}

	@Override
	public int size() {
		return tail;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < queue.length; i++) {
			if (queue[i] != null) {
				sb.append(queue[i]);
				if (i < queue.length - 1 && queue[i + 1] != null) {
					sb.append(", ");
				}
			}
		}

		sb.append("]");
		return sb.toString();
	}

	public void display() {
		System.out.println(toString() + " " + size() + "/" + isEmpty() + "\n");
	}

}
