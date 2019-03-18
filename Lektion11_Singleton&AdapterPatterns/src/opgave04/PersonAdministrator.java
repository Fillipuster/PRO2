package opgave04;

import java.util.HashSet;
import java.util.Set;

public class PersonAdministrator {
	
	private static PersonAdministrator instance;
	
	private Set<Person> persons = new HashSet<>();
	
	// Singleton
	private PersonAdministrator() {};
	public static PersonAdministrator getInstance() {
		if (instance == null) {
			instance = new PersonAdministrator();
		}
		return instance;
	}

	public void addPerson(Person p) {
		persons.add(p);
	}
	
	public void removePerson(Person p) {
		persons.remove(p);
	}
	
	public Set<Person> getPersons() {
		return new HashSet<Person>(persons);
	}
	
	public void print() {
		System.out.println("Person Administrator administrating following people:");
		for (Person p : persons) {
			System.out.print(p + ", ");
		}
		System.out.println();
	}

}
