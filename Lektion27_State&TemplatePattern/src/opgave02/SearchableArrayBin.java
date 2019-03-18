package opgave02;

public class SearchableArrayBin<E extends Comparable<E>> extends SearchPattern<E> {

	private int left, right, middle;
	private E[] arr;
	
	public SearchableArrayBin(E[] arr) {
		this.arr = arr;
	}
	
	@Override
	protected void init() {
		left = 0;
		right = arr.length - 1;
		middle = -1;
	}

	@Override
	protected boolean hasMoreElements() {
		return left <= right;
	}

	@Override
	protected E select() {
		middle = (left + right) / 2;
		return arr[middle];
	}

	@Override
	protected void split(E m) {
		if (m.compareTo(arr[middle]) < 0) {
			right = middle - 1;
		} else {
			left = middle + 1;
		}
	}

}
