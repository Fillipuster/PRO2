package question02;

public class Robot {

	private String name;
	
	public Robot(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void communicate() {
		System.out.println("Beep boop!");
	}
	
	public void breathe() {
		throw new UnsupportedOperationException();
	}
	
	public void excreteWaste() {
		throw new UnsupportedOperationException();
	}
	
}
