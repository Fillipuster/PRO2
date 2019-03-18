package opgave03;

import java.util.EmptyStackException;

import opgave01.Stack;

public class ArrayDropOutStack<T> implements Stack<T> {

	T[] stack;
	int top;
	boolean wrapped;
	
	@SuppressWarnings("unchecked")
	public ArrayDropOutStack(int size) {
		stack = (T[]) new Object[size];
		top = 0;
		wrapped = false;
	}
	
	@Override
	public void push(T element) {
		if (top == stack.length) {
			top = 0;
			wrapped = true;
		}
		
		stack[top] = element;
		top++;
	}

	@Override
	public T pop() {
		if (top == 0 && wrapped) {
			top = stack.length;
			wrapped = false;
		}
		
		T removed = stack[--top];
		if (removed == null) {
			throw new EmptyStackException();
		}
		
		stack[top] = null;
		return removed;
	}

	@Override
	public T peek() {
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0 && !wrapped;
	}

	@Override
	public int size() {
		return wrapped ? stack.length : top;
		
//		int size = 0;
//		for (int i = 0; i < stack.length; i++) {
//			if (stack[i] != null) {
//				size++;
//			}
//		}
//		
//		return size;
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
		
		sb.append("]");
		
		return sb.toString();
	}
	
	public void display() {
		System.out.println(toString() + " n=" + size() + "\n");
	}

}
