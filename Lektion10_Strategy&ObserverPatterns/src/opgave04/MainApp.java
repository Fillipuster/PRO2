package opgave04;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer("Jonas Præstegaard", "456"));
		customers.add(new Customer("Alexander Skou", "789"));
		customers.add(new Customer("Peter Justense", "123"));
		
		System.out.println("Unsorted\t" + customers);
		Collections.sort(customers);
		System.out.println("NameSort\t" + customers);
		
		for (Customer c : customers) {
			c.setCustomerComparison(new PhoneComparison());
		}
		
		Collections.sort(customers);
		System.out.println("PhoneSort\t" + customers);
	}

}
