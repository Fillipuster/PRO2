package opgave01;

public interface Dequeue<T> {

	/**
	 * Checks whether this deque is empty.
	 * 
	 * @return true if this queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Adds an element to the head of this deque.
	 * 
	 * @param newElement the element to add
	 */
	public void addFirst(T newElement);

	/**
	 * Adds an element to the tail of this deque.
	 * 
	 * @param newElement the element to add
	 */
	public void addLast(T newElement);

	/**
	 * Removes an element from the head of this deque.
	 * 
	 * @return the removed element
	 */
	public T removeFirst();

	/**
	 * Removes an element from the tail of this deque.
	 * 
	 * @return the removed element
	 */
	public T removeLast();

	/**
	 * Returns the head of this deque. The deque is unchanged.
	 * 
	 * @return the head element
	 */
	public T getFirst();

	/**
	 * Returns the tail of this deque. The deque is unchanged.
	 * 
	 * @return the tail element
	 */
	public T getLast();

	/**
	 * The number of elements on the deque.
	 * 
	 * @return the number of elements on the queue
	 */
	public int size();

}
