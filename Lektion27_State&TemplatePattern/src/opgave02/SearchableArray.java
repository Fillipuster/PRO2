package opgave02;

public class SearchableArray<E extends Comparable<E>> extends SearchPattern<E> {

	private int i;
	private E[] arr;
	
	public SearchableArray(E[] arr) {
		this.arr = arr;
	}
	
	@Override
	protected void init() {
		i = 0;
	}

	@Override
	protected boolean hasMoreElements() {
		return i < arr.length;
	}

	@Override
	protected E select() {
		return arr[i];
	}

	@Override
	protected void split(E m) {
		i++;
	}

}
