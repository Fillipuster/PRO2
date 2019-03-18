package question02;

public class Human extends Animal {

	private String surName;
	private boolean breath = true;
	
	public Human(String name, String surName, int daysOld) {
		super(name, daysOld);
		setSurName(surName);
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getSurName() {
		return this.surName;
	}
	
	public String fullName() {
		return super.getName() + " " + getSurName();
	}
	
	@Override
	public void breathe() {
		System.out.println(fullName() + (breath ? " sucks in air." : " exhales air."));
		breath = !breath;
	}
	
	@Override
	public void communicate() {
		System.out.println(fullName() + " says: Hello!");
	}
	
	@Override
	public void excreteWaste() {
		System.out.println(fullName() + " takes a shit.");
	}

}
