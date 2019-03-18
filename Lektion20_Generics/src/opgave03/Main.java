package opgave03;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person<Name>(new Name("Jonas", "Præstegaard")));
		people.add(new Person<Name>(new Name("Peter", "Hansen")));
		people.add(new Person<Name>(new Name("Peter", "Justesen")));
		people.add(new Person<Name>(new Name("Jens", "Hansen")));
		people.add(new Person<Name>(new Name("Alexander", "Skou")));
		people.add(new Person<Name>(new Name("Oscar", "Valentin")));
		people.add(new Person<Name>(new Name("Kennet", "Neiberg")));
		people.add(new Person<Name>(new Name("Morten", "Faber")));
		people.add(new Person<Name>(new Name("Frederik", "Stræde")));
		System.out.println(people);
		Collections.sort(people);
		System.out.println(people);
	}

}
