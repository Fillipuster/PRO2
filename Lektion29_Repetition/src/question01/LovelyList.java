// Opgave 01:
// Hvad er fremgangsmåde for at konvertere LoveList til en generisk datastruktur?

package question01;

import java.util.ArrayList;

public class LovelyList {

	ArrayList<Object> elements;
	
	public LovelyList() {
		elements = new ArrayList<>();
	}
	
	public void add(Object element) {
		elements.add(element);
	}
	
	public void remove(Object element) {
		elements.remove(element);
	}
	
	public Object get(int index) {
		return elements.get(index);
	}
	
	@Override
	public String toString() {
		return elements.toString();
	}
	
}
