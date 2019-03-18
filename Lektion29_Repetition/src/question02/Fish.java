package question02;

public class Fish extends Animal {

	public Fish(String name, int daysOld) {
		super(name, daysOld);
	}

	@Override
	public void communicate() {
		System.out.println("Blub blub!");
	}
	
	@Override
	public void excreteWaste() {
		System.out.println("The water becomes murky.");
	}
	
}
