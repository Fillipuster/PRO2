package opgave02;

public abstract class SearchPattern<E extends Comparable<E>> {

	public final boolean search(E m) {
		boolean found = false;
		init();
		while (!found && hasMoreElements()) {
			E k = select();
			if (m.equals(k)) found = true;
			else split(m);
		}
		return found;
	}
	
	protected abstract void init();
	protected abstract boolean hasMoreElements();
	protected abstract E select();
	protected abstract void split(E m);
	
}
