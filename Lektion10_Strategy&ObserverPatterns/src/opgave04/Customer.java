package opgave04;

public class Customer implements Comparable<Customer> {
	
	private String name;
	private String phoneNumber;
	
	private CustomerComparison customerComparison;
	
	public Customer(String name, String phoneNumber, CustomerComparison cc) {
		setName(name);
		setPhoneNumber(phoneNumber);
		setCustomerComparison(cc);
	}
	
	public Customer(String name, String phoneNumber) {
		this(name, phoneNumber, new NameComparison());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CustomerComparison getCustomerComparison() {
		return customerComparison;
	}

	public void setCustomerComparison(CustomerComparison customerComparison) {
		this.customerComparison = customerComparison;
	}
	
	@Override
	public int compareTo(Customer o) {
		return customerComparison.compare(this, o);
	}
	
	@Override
	public String toString() {
		return name + "(" + phoneNumber + ")";
	}
	
}
