package opgave04;

public class NameComparison implements CustomerComparison {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getName().compareTo(c2.getName());
	}
	
}
