package opgave04;

public class MainApp {

	public static void main(String[] args) {
		
		Person[] people = new Person[] {
				new Person("Oscar", 22),
				new Person("Peter", 23),
				new Person("Kennet", 29),
				new Person("Morten", 20)
		};
		
		PersonAdministrator pa = PersonAdministrator.getInstance();
		for (int i = 0; i < people.length; i++) {
			pa.addPerson(people[i]);
		}
		
		pa.print();
		
		pa.removePerson(people[2]);
		
		System.out.println();
		
		pa.print();
		
	}

}
