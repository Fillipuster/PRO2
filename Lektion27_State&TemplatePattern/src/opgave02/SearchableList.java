package opgave02;

import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {

	private int i;
	private List<E> list;
	
	public SearchableList(List<E> list) {
		this.list = list;
	}
	
	@Override
	protected void init() {
		i = 0;
	}

	@Override
	protected boolean hasMoreElements() {
		return i < list.size();
	}

	@Override
	protected E select() {
		return list.get(i);
	}

	@Override
	protected void split(E m) {
		i++;
	}
	
}
