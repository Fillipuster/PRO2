package opgave01;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

	T[] stack;
	int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		stack = (T[]) new Object[10];
		top = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void extendStack() {
		T[] temp = (T[]) new Object[stack.length * 2];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		
		stack = temp;
	}
	
	@Override
	public void push(T element) {
		if (top == stack.length) {
			extendStack();
		}
		
		stack[top] = element;
		top++;
	}

	@Override
	public T pop() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		
		T removed = stack[--top];
		stack[top] = null;
		return removed;
	}

	@Override
	public T peek() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for (int i = stack.length - 1; i >= 0; i--) {
			if (stack[i] != null) {
				sb.append(stack[i]);
				if (i > 0) {
					sb.append(", ");
				}
			}
		}
		
		sb.append("]" + " n=" + size());
		
		return sb.toString();
	}
	
}
