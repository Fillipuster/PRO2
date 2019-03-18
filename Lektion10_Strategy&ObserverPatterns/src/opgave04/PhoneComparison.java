package opgave04;

public class PhoneComparison implements CustomerComparison {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getPhoneNumber().compareTo(c2.getPhoneNumber());
	}
	
}
