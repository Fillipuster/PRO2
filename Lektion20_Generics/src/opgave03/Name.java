package opgave03;

public class Name implements Comparable<Name> {

	private String first, last;
	
	public Name(String first, String last) {
		setFirst(first);
		setLast(last);
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", last, first);
	}

	@Override
	public int compareTo(Name o) {
		int comp = last.compareTo(o.last);
		return comp == 0 ? first.compareTo(o.first) : comp;
	}
	
}
